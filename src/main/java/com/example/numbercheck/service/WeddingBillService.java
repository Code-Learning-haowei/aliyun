package com.example.numbercheck.service;

import com.example.numbercheck.dto.WeddingBillDTO;
import com.example.numbercheck.dto.weddingBillResponse;
import com.example.numbercheck.repository.WeddingBillRepository;
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
