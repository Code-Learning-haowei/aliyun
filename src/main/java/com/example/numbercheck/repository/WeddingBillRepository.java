package com.example.numbercheck.repository;

import com.example.numbercheck.entity.weddingBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wei.haothoughtworks.com
 */
@Repository
public interface WeddingBillRepository extends JpaRepository<weddingBillEntity, Integer> {

    List<weddingBillEntity> findAll();
}
