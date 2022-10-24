package com.thitiwas.workshop.similar_stuff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AmazonProductM {
    private String id;
    private String productName;
    private String brandName;
    private List<String> categories;
    private String sellingPrice;
    private List<String> productSpecification;
    private List<String> technicalDetails;
    private String image;
    private String productUrl;
    private List<String> aboutProduct;
}
