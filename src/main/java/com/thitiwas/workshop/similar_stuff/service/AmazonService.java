package com.thitiwas.workshop.similar_stuff.service;

import com.thitiwas.workshop.similar_stuff.entity.AmazonProductEntity;
import com.thitiwas.workshop.similar_stuff.model.AmazonProductM;
import com.thitiwas.workshop.similar_stuff.model.Pagination;
import com.thitiwas.workshop.similar_stuff.model.ResponseListAmazonProduct;
import com.thitiwas.workshop.similar_stuff.repository.AmazonProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public ResponseListAmazonProduct getList(int size, int page) {
        List<AmazonProductM> products = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<AmazonProductEntity> amazonProductEntities = amazonProductRepository.findAll(pageRequest);

        for (AmazonProductEntity amazonProductEntity : amazonProductEntities.getContent()) {
            products.add(convertEntityToModel(amazonProductEntity));
        }


        return ResponseListAmazonProduct.builder()
                .products(products)
                .pagination(Pagination.builder()
                        .page(page)
                        .pageSize(size)
                        .pageCount(amazonProductEntities.getTotalPages())
                        .total((int) amazonProductEntities.getTotalElements())
                        .build())
                .build();
    }

    public AmazonProductM convertEntityToModel(AmazonProductEntity a) {
        List<String> categories = new ArrayList<>();
        try {
            categories = Arrays.asList(a.getCategory().split("\\|"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> productSpeci = new ArrayList<>();
        try {
            productSpeci = Arrays.asList(a.getProductSpecification().split("\\|"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> technicalDetails = new ArrayList<>();
        try {
            technicalDetails = Arrays.asList(a.getTechnicalDetails().split("\\|"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> aboutProduct = new ArrayList<>();
        try {
            aboutProduct = Arrays.asList(a.getAboutProduct().split("\\|"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AmazonProductM.builder()
                .id(a.getId())
                .productName(a.getProductName())
                .brandName(a.getBrandName())
                .categories(categories)
                .sellingPrice(a.getSellingPrice())
                .productSpecification(productSpeci)
                .technicalDetails(technicalDetails)
                .image(a.getImage())
                .productUrl(a.getProductUrl())
                .aboutProduct(aboutProduct)
                .build();
    }
}
