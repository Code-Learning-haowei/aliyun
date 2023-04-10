package com.example.aliyun.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EachTypeCostResponse {
    private BigDecimal totalCost;
    private BigDecimal wddingPhotos;
    private BigDecimal stageBuild;
    private BigDecimal kingkang;
    private BigDecimal hotel;
    private BigDecimal restaurant;
}
