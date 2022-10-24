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
public class ResponseListAmazonProduct {
    private List<AmazonProductM> products;
    private Pagination pagination;
}
