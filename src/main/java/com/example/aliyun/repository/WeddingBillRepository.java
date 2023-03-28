package com.example.aliyun.repository;

import com.example.aliyun.entity.WeddingBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wei.haothoughtworks.com
 */
@Repository
@Component
public interface WeddingBillRepository extends JpaRepository<WeddingBillEntity, Integer> {

    List<WeddingBillEntity> findAll();
}
