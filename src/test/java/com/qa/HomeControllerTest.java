package com.qa;

import com.qa.controllers.HomeController;
import com.qa.models.Customer;
import com.qa.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {

    @Autowired
    @InjectMocks
    private HomeController controller;

    @Mock
    private CustomerRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testHomepageReturn() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("Welcome to homepage");
    }

    @Test
    public void testAddDefaultPeople() {
        Customer customer = new Customer("a", "b");
        Customer customer2 = new Customer();
        repository.save(customer);
        repository.save(customer2);
        this.restTemplate.getForObject("http://localhost:" + port + "/addDefaultCustomers", Void.class);
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer();
        customer.toString();
        repository.save(customer);
        this.restTemplate.postForEntity("http://localhost:" + port + "/saveCustomer", customer, Void.class);
    }

}
