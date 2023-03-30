package com.example.aliyun.controller;

import com.example.aliyun.dto.WeddingBillDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class weddingBillResponse {
    private List<WeddingBillDTO> data;
}
