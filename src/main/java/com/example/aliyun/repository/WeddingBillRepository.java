package com.example.aliyun.repository;

import com.example.aliyun.dto.CategoryTotalCost;
import com.example.aliyun.entity.WeddingBillEntity;
import com.example.aliyun.entity.categoryTpye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wei.haothoughtworks.com
 */
@Repository
@Component
public interface WeddingBillRepository extends JpaRepository<WeddingBillEntity, Integer> {
    List<WeddingBillEntity> findByCategoryTpye(categoryTpye categoryTpye);

    @Query(value = "SELECT categoryTpye as type, SUM(price) as cost FROM WeddingBillEntity GROUP BY categoryTpye")
    List<Object[]> calculateCostByTypeTemp();

    @Query("SELECT categoryTpye as type FROM WeddingBillEntity GROUP BY categoryTpye")
    List<String> getTypes();
}
