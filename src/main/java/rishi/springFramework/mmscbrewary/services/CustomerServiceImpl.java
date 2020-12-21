package rishi.springFramework.mmscbrewary.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rishi.springFramework.mmscbrewary.model.BeerDto;
import rishi.springFramework.mmscbrewary.model.CustomerDto;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Rishi")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        // impl
    }

    @Override
    public void deleteBeer(UUID customerId) {
        log.debug("Deleting a beer");
    }
}
