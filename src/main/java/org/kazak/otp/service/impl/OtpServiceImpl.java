package org.kazak.otp.service.impl;

import org.kazak.otp.dto.GenerateAndSendOtpRequest;
import org.kazak.otp.model.PassInfoModel;
import org.kazak.otp.service.OtpService;
import org.springframework.stereotype.Service;

@Service
public class OtpServiceImpl implements OtpService {

    @Override
    public PassInfoModel generatePassInfo(GenerateAndSendOtpRequest passInfo) {
        return null;
    }

    @Override
    public void sendPassInfo(PassInfoModel passInfoModel) {

    }
}
