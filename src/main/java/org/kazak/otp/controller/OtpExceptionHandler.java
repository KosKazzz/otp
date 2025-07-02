package org.kazak.otp.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kazak.otp.dto.common.CommonResponse;
import org.kazak.otp.dto.common.ValidationError;
import org.kazak.otp.exception.OtpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class OtpExceptionHandler {

    private final RestClient.Builder builder;

    @ExceptionHandler(Exception.class)
    public CommonResponse<?> handleException(Exception e) {
        log.error("Не предвиденная ошибка {}", e.getMessage(), e);

        return CommonResponse.builder()
                .id(UUID.randomUUID())
                .errorMessage("Не предвиденная ошибка " + e.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        List<ValidationError> errorList = bindingResult.getFieldErrors().stream().map(err -> ValidationError.builder()
                .field(err.getField())
                .message(err.getDefaultMessage())
                .build()).toList();

        log.warn("Ошибка валидации. {} ", errorList, e);

        return CommonResponse.builder()
                .id(UUID.randomUUID())
                .errorMessage("Ошибка валидации")
                .validationErrorList(errorList)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public CommonResponse<?> handleInvalidFormatException(HttpMessageNotReadableException e) {
        if (e.getCause() instanceof InvalidFormatException ife) {
            String path = ife.getPath().stream()
                    .map(JsonMappingException.Reference::getFieldName).collect(Collectors.joining("."));

            String message = "Ошибка валидации, указан некорректный формат поля  -  " + path;

            log.warn(message, ife);

            return CommonResponse.builder()
                    .errorMessage(message)
                    .build();
        }
        return handleException(e);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(OtpException.class)
    public CommonResponse<?> otpExceptionHandler(OtpException e) {
        log.warn("Ошибка сервиса One Time Password - {}",e.getMessage());

        return CommonResponse.builder()
                .errorMessage(e.getMessage())
                .build();
    }
}