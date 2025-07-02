package org.kazak.otp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.kazak.loggingstarter.annotation.LogExecutionTime;
import org.kazak.otp.dto.CheckOtpRequest;
import org.kazak.otp.dto.GenerateAndSendOtpRequest;
import org.kazak.otp.dto.common.CommonRequest;
import org.kazak.otp.dto.common.CommonResponse;
import org.kazak.otp.service.OtpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/v1/otp"))
public class OtpController {

    private final OtpService otpService;

    @LogExecutionTime
    @PostMapping("/generateAndSend")
    public CommonResponse<Void> generateAndSend(@RequestBody @Valid CommonRequest<GenerateAndSendOtpRequest> request) {

        otpService.generateAndSendPassInfo(request.getBody());

        return CommonResponse.<Void>builder().id(UUID.randomUUID()).build();
    }

    @LogExecutionTime
    @PostMapping("/check")
    public CommonResponse<Void> chek(@RequestBody @Valid CommonRequest<CheckOtpRequest> request) {

        return CommonResponse.<Void>builder().id(UUID.randomUUID()).build();
    }
}