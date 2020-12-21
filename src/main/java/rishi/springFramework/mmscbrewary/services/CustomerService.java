package rishi.springFramework.mmscbrewary.services;

import rishi.springFramework.mmscbrewary.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);

    CustomerDto saveCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteBeer(UUID customerId);
}
