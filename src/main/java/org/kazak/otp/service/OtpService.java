package org.kazak.otp.service;

import org.kazak.otp.dto.GenerateAndSendOtpRequest;
import org.kazak.otp.model.PassInfoModel;

public interface OtpService {

    PassInfoModel generatePassInfo(GenerateAndSendOtpRequest passInfo);

    void sendPassInfo(PassInfoModel passInfoModel);
}
