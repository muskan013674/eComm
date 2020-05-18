//package com.example.eComm;
//
//import org.hibernate.criterion.Order;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//import java.util.List;
//
//@RestController
//public class OrderController {
//
//    @Autowired
//    OrderDetService orderDetService;
//
//    public OrderController(OrderDetService orderDetService) {
//      this.orderDetService = orderDetService;
//    }
//    //    orderDet
//    @RequestMapping(value = "/createOrder/{Pid}/{Odate}/{Odel_date}/{Quantity}", method = RequestMethod.POST)
//    public List<Product> createOrder(@PathVariable int Pid, @PathVariable Date Odate, @PathVariable Date Odel_date, @PathVariable Double Quantity ) {
//        return orderDetService.createOrder(Pid,Odate,Odel_date,Quantity);
//    }
//
//    @RequestMapping(value = "/readAllOrder" , method = RequestMethod.GET)
//    public List<String> readAllOrder() {
//        return orderDetService.readAllOrder();
//    }
//    @RequestMapping(value = "/readOrderById/{id}" , method = RequestMethod.GET)
//    public String readOrderById(@PathVariable int id) {
//        return orderDetService.findByOrderId(id).toString();
//    }
//
//    @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.DELETE)
//    public int deleteOrderById(@PathVariable int id) {
//        return orderDetService.deleteOrderById(id);
//    }
//
//}
