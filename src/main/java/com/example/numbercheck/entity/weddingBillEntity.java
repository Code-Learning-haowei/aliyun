package com.example.numbercheck.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wei.haothoughtworks.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "wedding_bill")

public class weddingBillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_price")
    private BigDecimal price;

    @Column(name = "item_category")
    @Enumerated(EnumType.STRING)
    private categoryTpye categoryTpye;

    @Column(name = "created_at")
    @CreatedDate
    private Date createdDate;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedDate;

}
