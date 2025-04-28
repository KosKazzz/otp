package org.kazak.otp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kazak.otp.dto.OtpDto;
import org.kazak.otp.dto.PassInfo;
import org.kazak.otp.dto.common.CommonRequest;
import org.kazak.otp.model.PassInfoModel;
import org.kazak.otp.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController("/otp/api/v1/otp")
public class OtpController {

    @Autowired
    private final OtpService otpService;

    @PostMapping("/generateAndSend")
    public ResponseEntity<String> generateAndSend(@RequestBody CommonRequest<PassInfo> request) {
        log.info("Поступил запрос на генерацию и отпрпавку одноразового пароля:  {}", request.getBody());

        otpService.generatePassInfo();

        PassInfoModel passInfoModel = PassInfoModel.builder()
                .ttl(request.getBody().getTtl())
                .length(request.getBody().getLength())
                .message(request.getBody().getMessage())
                .processId(request.getBody().getProcessId())
                .resendAttempts(request.getBody().getResendAttempts())
                .resendTimeout(request.getBody().getResendTimeout())
                .resendTimeout(request.getBody().getResendTimeout())
                .build();

        otpService.sendPassInfo(passInfoModel);

        log.info("Выполнен запрос на генерацию и отпрпавку одноразового пароля:  {}", request.getBody());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/chek")
    public ResponseEntity<String> chek(@RequestBody CommonRequest<OtpDto> request) {
        log.info("Поступил запрос  одноразового пароля:  {}", request.getBody());

        return ResponseEntity.ok().build();
    }
}
