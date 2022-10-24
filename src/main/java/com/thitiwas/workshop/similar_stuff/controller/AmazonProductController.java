package com.thitiwas.workshop.similar_stuff.controller;


import com.thitiwas.workshop.similar_stuff.model.AmazonProductM;
import com.thitiwas.workshop.similar_stuff.model.ResponseListAmazonProduct;
import com.thitiwas.workshop.similar_stuff.service.AmazonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/amazon-product")
@Slf4j
public class AmazonProductController {
    private final AmazonService amazonService;

    @Autowired
    public AmazonProductController(AmazonService amazonService) {
        this.amazonService = amazonService;
    }

    @GetMapping("/v1/{productId}")
    @Transactional
    public ResponseEntity<AmazonProductM> getOne(@PathVariable("productId") String productId) {

        Optional<AmazonProductM> amazonProduct = amazonService.findById(productId);

        if (amazonProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(amazonProduct.get());
    }

    @GetMapping("/v1/list")
    @Transactional
    public ResponseEntity<ResponseListAmazonProduct> list(@RequestParam("page") int page, @RequestParam("size") int size) {

        return ResponseEntity.ok(amazonService.getList(size, page));
    }
}
