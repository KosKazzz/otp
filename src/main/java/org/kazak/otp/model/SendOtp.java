package org.kazak.otp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kazak.otp.model.enums.DeliveryStatus;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SendOtp extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String processId;
    private String sendingChannel;
    private String target;
    private String message;
    private Integer length;
    private Integer ttl;
    private Integer resendAttempts;
    private Integer resendTimeout;
    private String encodedOtp;
    private String sendMessageKey;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    private LocalDateTime sendTime;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SendOtp sendOtp = (SendOtp) o;
        return Objects.equals(id, sendOtp.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}