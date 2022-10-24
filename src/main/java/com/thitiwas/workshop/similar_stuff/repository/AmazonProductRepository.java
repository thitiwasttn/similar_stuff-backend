package com.thitiwas.workshop.similar_stuff.repository;

import com.thitiwas.workshop.similar_stuff.entity.AmazonProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmazonProductRepository extends JpaRepository<AmazonProductEntity, String> {
}
