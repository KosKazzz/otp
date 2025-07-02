package org.kazak.otp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.kazak.otp.dto.GenerateAndSendOtpRequest;

public class ValidTargetAddressValidator implements ConstraintValidator<ValidTargetAddress, GenerateAndSendOtpRequest> {

    public static final String TELEGRAM_CHAT_ID_PATTERN = "\\d+";

    @Override
    public boolean isValid(GenerateAndSendOtpRequest value, ConstraintValidatorContext context) {
        if(value.getSendingChannel().equalsIgnoreCase("telegram")) {
            return value.getTarget().matches(TELEGRAM_CHAT_ID_PATTERN);
        } else {
            value.setTarget("");
        }
        return true;
    }
}