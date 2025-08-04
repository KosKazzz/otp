package org.kazak.otp.repository;

import org.kazak.otp.model.CheckOtp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckOtpRepository extends JpaRepository<CheckOtp , UUID> {
}
