package com.thitiwas.workshop.similar_stuff.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "amazon_product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AmazonProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "asian")
    private String asian;
    @Column(name = "category")
    private String category;
    @Column(name = "upc_ean_code")
    private String upcEanCode;
    @Column(name = "list_price")
    private String listPrice;
    @Column(name = "selling_price")
    private String sellingPrice;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "product_specification")
    private String productSpecification;
    @Column(name = "about_product")
    private String aboutProduct;
    @Column(name = "technical_details")
    private String technicalDetails;
    @Column(name = "shipping_weight")
    private String shippingWeight;
    @Column(name = "product_dimensions")
    private String productDimensions;
    @Column(name = "image")
    private String image;
    @Column(name = "variants")
    private String variants;
    @Column(name = "sku")
    private String sku;
    @Column(name = "product_url")
    private String productUrl;
    @Column(name = "stock")
    private String stock;
    @Column(name = "product_details")
    private String productDetails;
    @Column(name = "dimensions")
    private String dimensions;
    @Column(name = "color")
    private String color;
    @Column(name = "ingredients")
    private String ingredients;
    @Column(name = "direction_to_use")
    private String directionToUse;
    @Column(name = "is_amazon_seller")
    private String isAmazonSeller;
    @Column(name = "size_quantity_variant")
    private String sizeQuantityVariant;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "model_number")
    private String modelNumber;
}
