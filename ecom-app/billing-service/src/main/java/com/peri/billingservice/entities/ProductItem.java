package com.peri.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.peri.billingservice.models.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private Integer quantity;
    private Double price;
    private Double discount;
    @Transient
    private Product product;
}
