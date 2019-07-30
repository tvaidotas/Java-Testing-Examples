package com.qa;

import com.qa.controllers.HomeController;
import com.qa.models.Customer;
import com.qa.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testHomepageReturn() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("Welcome to homepage");
    }

    @Test
    public void testAddDefaultPeople() throws Exception {
        Customer customer = new Customer("a", "b");
        Customer customer2 = new Customer();
        repository.save(customer);
        List<Customer> myList = new ArrayList<>();
        myList.add(customer);
        myList.add(customer2);
        when(repository.findAll()).thenReturn(myList);
        assertEquals(repository.findAll(), myList);
        this.restTemplate.getForObject("http://localhost:" + port + "/addDefaultPeople", String.class);
    }

}
