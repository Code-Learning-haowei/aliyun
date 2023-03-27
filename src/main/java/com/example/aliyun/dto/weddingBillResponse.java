package com.example.aliyun.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class weddingBillResponse {
    private List<WeddingBillDTO> data;
}
