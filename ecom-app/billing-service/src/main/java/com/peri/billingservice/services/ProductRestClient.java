package com.peri.billingservice.services;

import com.peri.billingservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping(path = "/products/{id}")
    Product findProductById(@PathVariable("id") String id);

    @GetMapping(path = "/products")
    PagedModel<Product> allProducts();
}
