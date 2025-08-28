package org.kazak.otp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CheckOtp extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    /**
     * Идентефикатор процесса, в рамках которого запрашивается одноразовый пароль
     */
    private String processId;
    /**
     * Введённый клиентом код
     */
    private String otp;
    /**
     * Время проверки
     */
    private LocalDateTime checkTime;
    /**
     * Признак корректности введённого пароля
     */
    private Boolean correct;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CheckOtp checkOtp = (CheckOtp) o;
        return Objects.equals(id, checkOtp.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
