package com.example.aliyun.dto;

import com.example.aliyun.entity.categoryTpye;
import com.example.aliyun.entity.WeddingBillEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wei.haothoughtworks.com
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeddingBillDTO {

    private Integer id;

    private String name;

    private BigDecimal price;

    private categoryTpye categoryTpye;

    private Date createdDate;

    private Date updatedDate;

    public WeddingBillDTO(WeddingBillEntity weddingBillEntity) {
        this.id = weddingBillEntity.getId();
        this.name = weddingBillEntity.getName();
        this.price = weddingBillEntity.getPrice();
        this.categoryTpye = weddingBillEntity.getCategoryTpye();
        this.createdDate = weddingBillEntity.getCreatedDate();
        this.updatedDate = weddingBillEntity.getUpdatedDate();
    }
}
