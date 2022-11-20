package uz.tuitfb.exportdata.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class SeedData {
    private CustomerRepository customerRepository;

    public SeedData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private List<Customer> customers = Arrays.asList(
            new Customer("Sam", "Jeffersan", " sam@gmail.com", new Address("Uzbekisan", "Fergana", "Fergana", "Moturudiy")),
            new Customer("Zam", "Jeffersan", " sam@gmail.com", new Address("Uzbekisan", "Fergana", "Fergana", "Moturudiy")),
            new Customer("Mam", "Jeffersan", " sam@gmail.com", new Address("Uzbekisan", "Fergana", "Fergana", "Moturudiy")),
            new Customer("Nam", "Jeffersan", " sam@gmail.com", new Address("Uzbekisan", "Fergana", "Fergana", "Moturudiy")),
            new Customer("Cam", "Jeffersan", " sam@gmail.com", new Address("Uzbekisan", "Fergana", "Fergana", "Moturudiy")),
            new Customer("Xam", "Jeffersan", " sam@gmail.com", new Address("Uzbekisan", "Fergana", "Fergana", "Moturudiy")),
            new Customer("Zam", "Jeffersan", " sam@gmail.com", new Address("Uzbekisan", "Fergana", "Fergana", "Moturudiy")),
            new Customer("Kam", "Jeffersan", " sam@gmail.com", new Address("Uzbekisan", "Fergana", "Fergana", "Moturudiy"))
    );

    @PostConstruct
    public void saveCustomers() {
        customerRepository.saveAll(customers);
    }
}
