package org.kazak.otp.repository;

import org.kazak.otp.model.SendOtp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SendOtpRepository extends JpaRepository<SendOtp, UUID> {
}
