package com.peri.billingservice.web;

import com.peri.billingservice.entities.Bill;
import com.peri.billingservice.repositories.BillRepository;
import com.peri.billingservice.repositories.ProductItemRepository;
import com.peri.billingservice.feign.CustomerRestClient;
import com.peri.billingservice.feign.ProductRestClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillRestController(BillRepository billRepository,
                              ProductItemRepository productItemRepository,
                              CustomerRestClient customerRestClient,
                              ProductRestClient productRestClient
    ) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.productRestClient = productRestClient;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/fullBill/{id}")
    public Bill getBill(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).get();

        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(productRestClient.getProductById(String.valueOf(pi.getProductId())));
        });

        return bill;
    }
}
