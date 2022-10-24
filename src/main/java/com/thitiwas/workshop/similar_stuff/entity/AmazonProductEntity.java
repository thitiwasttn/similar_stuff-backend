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
    public String productName;
    @Column(name = "brand_name")
    public String brandName;
    @Column(name = "asian")
    public String asian;
    @Column(name = "category")
    public String category;
    @Column(name = "upc_ean_code")
    public String upcEanCode;
    @Column(name = "list_price")
    public String listPrice;
    @Column(name = "selling_price")
    public String sellingPrice;
    @Column(name = "quantity")
    public String quantity;
    @Column(name = "product_specification")
    public String productSpecification;
    @Column(name = "about_product")
    public String aboutProduct;
    @Column(name = "technical_details")
    public String technicalDetails;
    @Column(name = "shipping_weight")
    public String shippingWeight;
    @Column(name = "product_dimensions")
    public String productDimensions;
    @Column(name = "image")
    public String image;
    @Column(name = "variants")
    public String variants;
    @Column(name = "sku")
    public String sku;
    @Column(name = "product_url")
    public String productUrl;
    @Column(name = "stock")
    public String stock;
    @Column(name = "product_details")
    public String productDetails;
    @Column(name = "dimensions")
    public String dimensions;
    @Column(name = "color")
    public String color;
    @Column(name = "ingredients")
    public String ingredients;
    @Column(name = "direction_to_use")
    public String directionToUse;
    @Column(name = "is_amazon_seller")
    public String isAmazonSeller;
    @Column(name = "size_quantity_variant")
    public String sizeQuantityVariant;
    @Column(name = "product_description")
    public String productDescription;
    @Column(name = "model_number")
    public String modelNumber;
}
