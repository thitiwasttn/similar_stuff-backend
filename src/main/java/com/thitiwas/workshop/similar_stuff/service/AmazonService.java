package com.thitiwas.workshop.similar_stuff.service;

import com.thitiwas.workshop.similar_stuff.entity.AmazonProductEntity;
import com.thitiwas.workshop.similar_stuff.model.AmazonProductM;
import com.thitiwas.workshop.similar_stuff.repository.AmazonProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AmazonService {
    private final AmazonProductRepository amazonProductRepository;

    @Autowired
    public AmazonService(AmazonProductRepository amazonProductRepository) {
        this.amazonProductRepository = amazonProductRepository;
    }

    public Optional<AmazonProductM> findById(String id) {
        Optional<AmazonProductEntity> amazonProduct = amazonProductRepository.findById(id);
        if (amazonProduct.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(convertEntityToModel(amazonProduct.get()));
    }

    public AmazonProductM convertEntityToModel(AmazonProductEntity a) {
        List<String> categories = new ArrayList<>();
        try {
            categories = Arrays.asList(a.getCategory().split("\\|"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AmazonProductM.builder()
                .id(a.getId())
                .productName(a.getProductName())
                .brandName(a.getBrandName())
                .categories(categories)
                .sellingPrice(a.getSellingPrice())
                .productSpecification(a.getProductSpecification())
                .technicalDetails(a.getTechnicalDetails())
                .image(a.getImage())
                .productUrl(a.getProductUrl())
                .build();
    }
}
