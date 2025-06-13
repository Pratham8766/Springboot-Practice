package com.mylearning.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class StudentMarksDTO {
    private String name;
    private String email;
    private BigDecimal math;
    private BigDecimal science;
    private BigDecimal english;
}
