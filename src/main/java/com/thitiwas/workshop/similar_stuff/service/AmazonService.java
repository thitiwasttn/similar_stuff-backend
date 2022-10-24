package com.thitiwas.workshop.similar_stuff.service;

import com.thitiwas.workshop.similar_stuff.repository.AmazonProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmazonService {
    private final AmazonProductRepository amazonProductRepository;

    @Autowired
    public AmazonService(AmazonProductRepository amazonProductRepository) {
        this.amazonProductRepository = amazonProductRepository;
    }
}
