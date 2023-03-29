package com.example.aliyun.service;

import com.example.aliyun.controller.createWeddingBillItemRequest;
import com.example.aliyun.dto.WeddingBillDTO;
import com.example.aliyun.controller.WeddingBillResponse;
import com.example.aliyun.entity.WeddingBillEntity;
import com.example.aliyun.repository.WeddingBillRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class WeddingBillService {

    @Autowired
    private WeddingBillRepository weddingBillRepository;

    public WeddingBillResponse getAll() {
        List<WeddingBillDTO> all = weddingBillRepository.findAll().stream().map(WeddingBillDTO::new).collect(toList());
        return WeddingBillResponse.builder().data(all).build();
    }

    public WeddingBillResponse createItem(createWeddingBillItemRequest request) {
        WeddingBillEntity entity = entityBuild(request);
        WeddingBillEntity save = weddingBillRepository.save(entity);
        WeddingBillDTO responseDTO = new WeddingBillDTO(save);
        ArrayList<WeddingBillDTO> response = new ArrayList<>();
        response.add(responseDTO);
        return WeddingBillResponse.builder().data(response).build();
    }

    private WeddingBillEntity entityBuild(createWeddingBillItemRequest requestData) {
        WeddingBillEntity entity = new WeddingBillEntity();
        System.out.println(requestData);
        entity.setName(requestData.getName());
        entity.setCategoryTpye(requestData.getCategoryTpye());
        entity.setPrice(requestData.getPrice());
        entity.setCreatedDate(new Date());
        entity.setUpdatedDate(new Date());
        return entity;
    }
}
