package com.example.aliyun.service;

import com.example.aliyun.controller.createWeddingBillItemRequest;
import com.example.aliyun.controller.EachTypeCostResponse;
import com.example.aliyun.controller.WeddingBillResponse;
import com.example.aliyun.dto.CategoryTotalCost;
import com.example.aliyun.dto.WeddingBillDTO;
import com.example.aliyun.entity.WeddingBillEntity;
import com.example.aliyun.entity.categoryTpye;
import com.example.aliyun.repository.WeddingBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Service
public class WeddingBillService {

    @Autowired
    private WeddingBillRepository weddingBillRepository;

    public WeddingBillResponse getAll() {
        List<WeddingBillDTO> all = weddingBillRepository.findAll().stream().map(WeddingBillDTO::new).collect(toList());
        return WeddingBillResponse.builder().data(all).build();
    }

    public WeddingBillResponse createItem(createWeddingBillItemRequest request) {
        return getWeddingBillResponse(weddingBillRepository.save(entityBuild(request)));
    }

    public WeddingBillResponse getById(Integer id) {
        return weddingBillRepository.findById(id).map(this::getWeddingBillResponse).orElse(null);
    }

    private WeddingBillResponse getWeddingBillResponse(WeddingBillEntity entity) {
        WeddingBillDTO responseDTO = new WeddingBillDTO(entity);
        return WeddingBillResponse.builder().data(Collections.singletonList(responseDTO)).build();
    }

    public WeddingBillResponse getByCategoryType(categoryTpye type) {
        List<WeddingBillDTO> collect = weddingBillRepository.findByCategoryTpye(type).stream().map(WeddingBillDTO::new).collect(toList());
        return WeddingBillResponse.builder().data(collect).build();
    }

    public EachTypeCostResponse getCostByTypeTemp() {
        List<Object[]> costList = weddingBillRepository.calculateCostByTypeTemp();
        List<CategoryTotalCost> collect = getCategoryTotalCosts(costList);
        return getEachTypeCostResponse(collect);
    }

    private List<CategoryTotalCost> getCategoryTotalCosts(List<Object[]> costList) {
        return costList.stream().map(
                obj -> CategoryTotalCost.builder().
                        type(categoryTpye.valueOf(obj[0].toString())).
                        cost(new BigDecimal(obj[1].toString())).
                        build()).
                collect(toList());
    }

    private EachTypeCostResponse getEachTypeCostResponse(List<CategoryTotalCost> collect) {
        EachTypeCostResponse eachTypeCostResponse = new EachTypeCostResponse();
        collect.forEach(item -> {
            BigDecimal cost = item.getCost();
            switch (item.getType()) {
                case HOTEL:
                    eachTypeCostResponse.setHotel(cost);
                    break;
                case KING_KANG:
                    eachTypeCostResponse.setKingkang(cost);
                    break;
                case RESTAURANT:
                    eachTypeCostResponse.setRestaurant(cost);
                    break;
                case WEDDING_PHOTOS:
                    eachTypeCostResponse.setWddingPhotos(cost);
                    break;
                case STAGE_BUILD:
                    eachTypeCostResponse.setStageBuild(cost);
                    break;
                default:
                    break;
            }
        });
        eachTypeCostResponse.setTotalCost(collect.stream().map(CategoryTotalCost::getCost).reduce(BigDecimal.ZERO, BigDecimal::add));
        return eachTypeCostResponse;
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
