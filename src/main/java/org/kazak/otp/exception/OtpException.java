package org.kazak.otp.exception;

public class OtpException extends RuntimeException {
    public OtpException(String message) {
        super(message);
    }
    public OtpException(String message, Exception e) {
      super(message, e);
    }
}