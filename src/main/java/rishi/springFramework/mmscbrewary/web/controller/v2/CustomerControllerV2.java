package rishi.springFramework.mmscbrewary.web.controller.v2;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rishi.springFramework.mmscbrewary.model.CustomerDto;
import rishi.springFramework.mmscbrewary.services.CustomerService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Validated
@RequestMapping("/api/v2/customer")
@RestController
public class CustomerControllerV2 {

    private final CustomerService customerService;

    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getBeer(@NotNull @PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> handlePost(@NotNull @Valid @RequestBody CustomerDto customerDto) {
        CustomerDto customer = customerService.saveCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        // ToDo add hostname to url
        headers.add("Location", "/api/v2/customer/" + customer.getId().toString());
        return new ResponseEntity<CustomerDto>(headers, HttpStatus.OK);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> handlePut(@PathVariable("customerId") UUID customerId, @Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity<CustomerDto>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomer(customerId);
    }
}
