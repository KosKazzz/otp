package org.kazak.otp.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T>{

    private UUID id;
    private T body;

    private String errorMessage;
    private List<ValidationError> validationErrorList;
}