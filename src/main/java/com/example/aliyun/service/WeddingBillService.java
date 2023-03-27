package com.example.aliyun.service;

import com.example.aliyun.dto.WeddingBillDTO;
import com.example.aliyun.dto.weddingBillResponse;
import com.example.aliyun.repository.WeddingBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class WeddingBillService {

    @Autowired
    private WeddingBillRepository weddingBillRepository;

    public weddingBillResponse getAll() {
        List<WeddingBillDTO> all = weddingBillRepository.findAll().stream().map(WeddingBillDTO::new).collect(toList());
        return weddingBillResponse.builder().data(all).build();
    }
}
