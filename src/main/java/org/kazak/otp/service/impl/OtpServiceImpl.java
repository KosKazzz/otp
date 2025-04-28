package org.kazak.otp.service.impl;

import org.kazak.otp.model.PassInfoModel;
import org.kazak.otp.service.OtpService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OtpServiceImpl implements OtpService {

    @Override
    public PassInfoModel generatePassInfo() {
        return null;
    }

    @Override
    public void sendPassInfo(PassInfoModel passInfoModel) {

    }
}
