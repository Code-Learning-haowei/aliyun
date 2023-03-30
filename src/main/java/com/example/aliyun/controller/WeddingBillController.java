package com.example.aliyun.controller;

import com.example.aliyun.entity.categoryTpye;
import com.example.aliyun.service.WeddingBillService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wei.haothoughtworks.com
 */
@RestController
@RequestMapping("/wedding-bill/")
public class WeddingBillController {

    @Autowired
    private WeddingBillService weddingBillService;

    @ApiOperation("获取全部账单")
    @GetMapping(value = "/all")
    public weddingBillResponse getWeddingBill() {
        return weddingBillService.getAll();
    }

    @ApiOperation("根据id获取账单明细")
    @GetMapping(value = "/detail/{id}")
    public weddingBillResponse getWeddingBillById(@PathVariable("id") Integer id) {
        return weddingBillService.getById(id);
    }

    @ApiOperation("根据类别获取账单明细")
    @GetMapping(value = "/detail")
    public weddingBillResponse getWeddingBillByCategoryType(@RequestParam("type") categoryTpye type) {
        return weddingBillService.getByCategoryType(type);
    }

    @ApiOperation("插入新的账单")
    @PostMapping(value = "/create-item")
    public weddingBillResponse createWeddingBillItem(@RequestBody createWeddingBillItemRequest request) {
        return weddingBillService.createItem(request);
    }

}
