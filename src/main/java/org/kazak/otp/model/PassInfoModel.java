package org.kazak.otp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassInfoModel {

    private UUID processId;
    private String telegramChadId;
    private String message;
    private Byte length;
    private Integer ttl;
    private Byte resendAttempts;
    private Integer resendTimeout;
}
