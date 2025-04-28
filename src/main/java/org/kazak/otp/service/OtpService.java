package org.kazak.otp.service;

import org.kazak.otp.model.PassInfoModel;

public interface OtpService {

    PassInfoModel generatePassInfo();

    void sendPassInfo(PassInfoModel passInfoModel);
}
