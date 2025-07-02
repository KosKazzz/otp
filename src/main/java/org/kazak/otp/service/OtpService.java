package org.kazak.otp.service;

import org.kazak.otp.dto.GenerateAndSendOtpRequest;

public interface OtpService {

    void generateAndSendPassInfo(GenerateAndSendOtpRequest passInfo);
}