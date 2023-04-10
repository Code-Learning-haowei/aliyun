package com.example.aliyun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.example.aliyun.entity.categoryTpye;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryTotalCost {
    private categoryTpye type;
    private BigDecimal cost;
}
