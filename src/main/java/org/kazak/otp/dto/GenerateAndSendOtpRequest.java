package org.kazak.otp.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.kazak.otp.validation.ValidTargetAddress;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ValidTargetAddress
public class GenerateAndSendOtpRequest {

    @NotNull(message = "значение идентификатора не может быть пустым")
    private UUID processId;
    @NotNull(message = "значение канала отправки не может быть пустым")
    @Pattern(regexp = "telegram|console")
    private String sendingChannel;
    private String target;
    private String message;
    @NotNull(message = "значение длинны пароля не может быть пустым")
    @Range(min = 4, max = 8)
    private Integer length;
    @NotNull(message = "значение времени жизни не может быть пустым")
    @Range(min = 30)
    private Integer ttl;
    @NotNull(message = "значение количества возможных повторных отправок не может быть пустым")
    @Range(min = 1, max = 3)
    private Integer resendAttempts;
    @NotNull(message = "значение таймаута не может быть пустым")
    @Range(min = 30)
    private Integer resendTimeout;
}