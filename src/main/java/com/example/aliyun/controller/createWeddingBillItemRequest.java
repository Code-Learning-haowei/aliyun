package com.example.aliyun.controller;

import com.example.aliyun.entity.categoryTpye;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class createWeddingBillItemRequest {

    @JsonProperty("name")
    @NotBlank
    @NotNull
    private String name;

    @JsonProperty("price")
    @NotBlank
    @NotNull
    private BigDecimal price;

    @JsonProperty("categoryTpye")
    @NotBlank
    @NotNull
    private categoryTpye categoryTpye;

}
