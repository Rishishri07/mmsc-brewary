package rishi.springFramework.mmscbrewary.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rishi.springFramework.mmscbrewary.model.BeerDto;
import rishi.springFramework.mmscbrewary.model.CustomerDto;
import rishi.springFramework.mmscbrewary.services.CustomerService;

import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> insertCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto dto = customerService.saveCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + dto.getId().toString());
        return new ResponseEntity<CustomerDto>(headers, HttpStatus.OK);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> handlePut(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteBeer(customerId);
    }
}
