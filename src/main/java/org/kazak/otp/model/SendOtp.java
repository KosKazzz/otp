package org.kazak.otp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kazak.otp.model.enums.DeliveryStatus;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SendOtp extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    /**
     * Идентификатор процесса в рамках которого запрашивается одноразовый пароль
     */
    private String processId;
    /**
     * Канал отправки
     */
    private String sendingChannel;
    /**
     * Адрес, куда будет выполнена оправка в канале
     */
    private String target;
    /**
     * Текст сообщения
     */
    private String message;
    /**
     * Длина одноразавого пароля
     */
    private Integer length;
    /**
     * Время жизниодноразового пароля в секундах
     */
    private Integer ttl;
    /**
     * Количество возможных повторных отправок кода
     */
    private Integer resendAttempts;
    /**
     * Таймаут перед повторным запросом кода, в секундах
     */
    private Integer resendTimeout;
    /**
     * Зашифрованный одноразовый пароль
     */
    private String encodedOtp;
    /**
     * Идентефикатор сообщения, отправляемого во внешнюю систему
     */
    private String sendMessageKey;
    /**
     * Статус отправки сообщения
     */
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    /**
     * Время отправки одноразового пароля
     */
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