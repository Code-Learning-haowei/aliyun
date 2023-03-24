package com.example.numbercheck.controller;

import com.example.numbercheck.dto.weddingBillResponse;
import com.example.numbercheck.service.WeddingBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wei.haothoughtworks.com
 */
@RestController
@RequestMapping("/wedding-bill/")
public class WeddingBillController {

    @Autowired
    private WeddingBillService weddingBillService;

    @GetMapping("/all")
    public weddingBillResponse getWeddingBill() {
        return weddingBillService.getAll();
    }

}
