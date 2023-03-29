package com.example.aliyun.controller;

import com.example.aliyun.service.WeddingBillService;
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

    @GetMapping("/all")
    public WeddingBillResponse getWeddingBill() {
        return weddingBillService.getAll();
    }

    @PostMapping("/create-item")
    public WeddingBillResponse createWeddingBillItem(@RequestBody createWeddingBillItemRequest request) {
        return weddingBillService.createItem(request);
    }

}
