package rishi.springFramework.mmscbrewary.web.controller.mapper;

import org.mapstruct.Mapper;
import rishi.springFramework.mmscbrewary.domain.Customer;
import rishi.springFramework.mmscbrewary.model.CustomerDto;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
