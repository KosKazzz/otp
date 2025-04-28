package org.kazak.otp.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassInfo {

    private UUID processId;
    private String telegramChadId;
    private String message;
    @NotNull(message = "значение длинны пароля не может быть пустым")
    @Size(min = 4, max = 8)
    private Byte length;
    @NotNull(message = "значение времени жизни не может быть пустым")
    @Size(min = 30)
    private Integer ttl;
    @NotNull(message = "значение количества возможных повторных отправок не может быть пустым")
    @Size(min = 1, max = 3)
    private Byte resendAttempts;
    @NotNull(message = "значение таймаута не может быть пустым")
    @Size(min = 30)
    private Integer resendTimeout;
}
