package com.example.eComm;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    ProductService productService;

    @Autowired
    OrderDetService orderDetService;

    @Autowired
    CustomerService customerService;


    //For Product and Category
    @RequestMapping(value = "/addCategory/{Cid}/{Cname}/{Name}/{Rate}", method = RequestMethod.POST)
    public String create(@PathVariable int Cid,@PathVariable String Cname, @PathVariable String Name, @PathVariable Double Rate) {
       return productService.create(Cid,Cname, Name, Rate);
    }

    @RequestMapping(value = "/readAllProducts" , method = RequestMethod.GET)
    public List<String> readAll() {
        return productService.readAll();
    }

    @RequestMapping(value = "/searchByProductId/{id}" , method = RequestMethod.GET)
    public String searchByProductId(@PathVariable int id) {
        return productService.searchByProductId(id);
    }

    @RequestMapping(value = "/searchByCategoryId/{id}" , method = RequestMethod.GET)
    public String searchByCategoryId(@PathVariable int id) {
        return productService.searchByCategoryId(id);
    }

    @RequestMapping(value = "/deleteByProductId/{id}", method = RequestMethod.DELETE)
    public int  deleteByProductId(@PathVariable int id) {
        return productService.deleteByProductId(id);
    }

    @RequestMapping(value = "/deleteByCategoryId/{id}", method = RequestMethod.DELETE)
    public int  deleteByCategoryId(@PathVariable int id) {
        return productService.deleteByCategoryId(id);
    }

    @RequestMapping(value = "/searchByCategoryName/{s}", method = RequestMethod.GET)
    public List<String> searchByCategoryName(@PathVariable String s) {
        return productService.searchByCategoryName(s);
    }

    @RequestMapping(value = "/searchByProductName/{s}", method = RequestMethod.GET)
    public List<String>  searchByProductName(@PathVariable String s) {
        return productService.searchByProductName(s);
    }

    @RequestMapping(value = "/listProductsByCategoryId/{id}", method = RequestMethod.GET)
    public List<String> listProductsByCategoryId(@PathVariable int id) {
        return productService.listProductsByCategoryId(id);
    }

    @RequestMapping(value = "/filterProductByRange/{low}/{high}", method = RequestMethod.GET)
    public List<String>  filterProductByRate(@PathVariable double low,@PathVariable double high) {
        return productService.filterProductByRate(low, high);
    }

//    orderDetails
  @PostMapping(value = "/createOrder")
    public String createOrder(@RequestBody(required = true) OrderCreateProjection orderCreateProjection ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate  date1 = LocalDate.parse(orderCreateProjection.getOdate() ,formatter);
        LocalDate date2 = LocalDate.parse(orderCreateProjection.getOdel_date(),formatter);
      return orderDetService.createOrder(orderCreateProjection.getPid(), date1, date2, orderCreateProjection.getQuantity() , orderCreateProjection.getCid());
  }

    @RequestMapping(value = "/readAllOrders" , method = RequestMethod.GET)
    public List<String> readAllOrder() {
        return orderDetService.readAllOrder();
    }
    @RequestMapping(value = "/searchOrderById/{id}" , method = RequestMethod.GET)
    public List<String> readOrderById(@PathVariable int id) {
        return orderDetService.findOrderDetById(id);
    }

    @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.DELETE)
    public int deleteOrderById(@PathVariable int id) {
        return orderDetService.deleteOrderById(id);
    }

    //For customer
    @RequestMapping(value = "/addCustomer/{Cid}/{Cname}", method = RequestMethod.POST)
    public List<Customer> createCustomer(@PathVariable int Cid,@PathVariable String Cname) {
        return customerService.createCustomer(Cid,Cname);
    }

    @RequestMapping(value = "/findCustomerById/{id}" , method = RequestMethod.GET)
    public String findCustomerById(@PathVariable int id) {
        return customerService.findCustomerById(id);
    }

    @RequestMapping(value = "/findCustomerOrderById/{id}" , method = RequestMethod.GET)
    public List<String> findCustomerOrderById(@PathVariable int id) {
        return customerService.findCustomerOrderById(id);
    }

    @RequestMapping(value = "/deleteCustomerById/{id}", method = RequestMethod.DELETE)
    public int deleteCustomerById(@PathVariable int id) {
        return customerService.deleteCustomerById(id);
    }


}
