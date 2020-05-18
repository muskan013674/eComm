package com.example.eComm;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class OrderDetService {

    private final ProductRepository productRepository;
    private final OrderDetRepository orderDetRepository;
    private final CustomerRepository customerRepository;

    public OrderDetService(
                          ProductRepository productRepository,
                          OrderDetRepository orderDetRepository,
                          CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.orderDetRepository = orderDetRepository;
        this.customerRepository = customerRepository;
    }
    public String createOrder(int Pid, LocalDate Odate, LocalDate Odel_date, double Quantity, int Cid) {
        List<Product> products = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        Product prod1 = productRepository.findProductById(Pid);
        Customer cus1 = customerRepository.findById(Cid);

        Optional<Customer> cus = Optional.ofNullable(cus1);
        Optional<Product> prod = Optional.ofNullable(prod1);

        if(prod.isPresent() && cus.isPresent()) {
            OrderDet orderDet = new OrderDet(prod1,Odate, Odel_date, Quantity,cus1);
            orderDet.setProduct(prod1);
            products.add(prod1);
            productRepository.saveAll(products);
            return "Order created for Pid: " + Pid + " for Customer Id : " + Cid;
        }
        return "Order not created";
    }

    public List<String> readAllOrder() {
        List<OrderDet> orderDet = orderDetRepository.findAll();
        List<String> list = new ArrayList<String>();
        for (OrderDet orderDet1 : orderDet) {
            list.add( "Order Id : " + orderDet1.getOid() + " " +
                    "Order Date : " + orderDet1.getOdate()+ " " +
                    "Order Delivery Date : " + orderDet1.getOdel_date()+ " " +
                    "Product Id : " + orderDet1.getProduct().getPid() + " " +
                    "Product Name : " + orderDet1.getProduct().getName() + " " +
                    "Product Rate : " + orderDet1.getProduct().getRate() + " " +
                    "Product Quantity : " + orderDet1.getQuantity());
        }
        return list;
    }

    public List<String> findOrderDetById(int id) {
        List<OrderDet> orderDet = orderDetRepository.findOrderDetById(id);
        List<String> list = new ArrayList<String>();
        for (OrderDet orderDet1 : orderDet) {
            list.add( "Order Id : " + orderDet1.getOid() + " " +
                    "Order Date : " + orderDet1.getOdate()+ " " +
                    "Order Delivery Date : " + orderDet1.getOdel_date()+ " " +
                    "Product Id : " + orderDet1.getProduct().getPid() + " " +
                    "Product Name : " + orderDet1.getProduct().getName() + " " +
                    "Product Rate : " + orderDet1.getProduct().getRate() + " " +
                    "Product Quantity : " + orderDet1.getQuantity());
        }

       return list;

    }

    public int deleteOrderById(int id) {
        return orderDetRepository.deleteByOrderDetId(id);

    }

}
