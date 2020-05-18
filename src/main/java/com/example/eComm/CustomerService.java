package com.example.eComm;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> createCustomer(int Cid, String Cname) {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = customerRepository.findById(Cid);
        Optional<Customer> cus = Optional.ofNullable(customer1);
        if(!cus.isPresent())
        {
            Set<OrderDet> orderDet = new HashSet<OrderDet>();
            Customer customer = new Customer(Cname,orderDet);
            customer.setOrderDet(orderDet);
            customers.add(customer);
            return customerRepository.saveAll(customers);
        }
        return  customers;
    }

    public String findCustomerById(int id) {
        return customerRepository.findCustomerById(id).toString();
    }

    public List<String> findCustomerOrderById(int id) {
        return customerRepository.findCustomerOrderById(id);
    }

    public int deleteCustomerById(int id) {
        return customerRepository.deleteCustomerById(id);
    }
}
