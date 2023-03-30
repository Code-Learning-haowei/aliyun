package com.example.aliyun.service;

import com.example.aliyun.controller.createWeddingBillItemRequest;
import com.example.aliyun.dto.WeddingBillDTO;
import com.example.aliyun.controller.weddingBillResponse;
import com.example.aliyun.entity.WeddingBillEntity;
import com.example.aliyun.entity.categoryTpye;
import com.example.aliyun.repository.WeddingBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
public class WeddingBillService {

    @Autowired
    private WeddingBillRepository weddingBillRepository;

    public weddingBillResponse getAll() {
        List<WeddingBillDTO> all = weddingBillRepository.findAll().stream().map(WeddingBillDTO::new).collect(toList());
        return weddingBillResponse.builder().data(all).build();
    }

    public weddingBillResponse createItem(createWeddingBillItemRequest request) {
        return getWeddingBillResponse(weddingBillRepository.save(entityBuild(request)));
    }

    public weddingBillResponse getById(Integer id) {
        return weddingBillRepository.findById(id).map(this::getWeddingBillResponse).orElse(null);
    }

    private weddingBillResponse getWeddingBillResponse(WeddingBillEntity entity) {
        WeddingBillDTO responseDTO = new WeddingBillDTO(entity);
        return weddingBillResponse.builder().data(Collections.singletonList(responseDTO)).build();
    }

    public weddingBillResponse getByCategoryType(categoryTpye type) {
        List<WeddingBillDTO> collect = weddingBillRepository.findByCategoryTpye(type).stream().map(WeddingBillDTO::new).collect(toList());
        return weddingBillResponse.builder().data(collect).build();
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
