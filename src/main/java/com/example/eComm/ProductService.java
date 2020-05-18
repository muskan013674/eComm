package com.example.eComm;

import org.springframework.stereotype.Service;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.*;

@Service
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
//    private final OrderDetRepository orderDetRepository;
//    private final CustomerRepository customerRepository;

    public ProductService(CategoryRepository categoryRepository,
                          ProductRepository productRepository)
//                          OrderDetRepository orderDetRepository,
//                          CustomerRepository customerRepository)
    {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
//        this.orderDetRepository = orderDetRepository;
//        this.customerRepository = customerRepository;
    }

    public String create(int Cid, String Cname, String name, double rate) {
        List<Category> categories = new ArrayList<>();
        Category cat1 = categoryRepository.findById(Cid);
        Optional<Category> cat = Optional.ofNullable(cat1);
        if(cat.isPresent())
        {
            Product product = new Product(name, rate);
            product.setCategory(cat1);
            categories.add(cat1);
            categoryRepository.saveAll(categories);
            return "Product: " + name + " added to Category: " + Cname;
        }
        else {
            Category category = new Category(Cname);
            Product product = new Product(name, rate);
            product.setCategory(category);
            categories.add(category);
            categoryRepository.saveAll(categories);
            return "Product: " + name + " added to Category: " + Cname;
        }
    }

    public List<String> readAll() {
        List<Product> products = productRepository.findAll();
        List<String> list = new ArrayList<String>();
        for (Product prod : products) {
            list.add(  "Product Id : " + prod.getPid() + " " +
                       "Product Name : " + prod.getName() + " " +
                       "Category Id : " + prod.getCategory().getCid()+ " " +
                       "Category Name : " + prod.getCategory().getCname()+ " " +
                       "Product Rate : " + prod.getRate());
        }
        return list;
    }

    public String searchByProductId(int id) {
       Product prod =  productRepository.searchByProductId(id);
        return  "Product Id : " + prod.getPid() + " " +
                "Product Name : " + prod.getName() + " " +
                "Category Id : " + prod.getCategory().getCid()+ " " +
                "Category Name : " + prod.getCategory().getCname()+ " " +
                "Product Rate : " + prod.getRate();
    }
    public String  searchByCategoryId(int id) {
        Category cat =  productRepository.searchByCategoryId(id);
        return  "Category Id : " + cat.getCid() + " " +
                "Category Name : " + cat.getCname();
    }

    public int deleteByProductId(int id) {
        return  productRepository.deleteByProductId(id);
    }

    public int deleteByCategoryId(int id) {
        return  productRepository.deleteByCategoryId(id);
    }

    public List<String> searchByCategoryName(String s) {
        return productRepository.searchByCategoryName(s);
    }
    public List<String> searchByProductName(String s) {
        return productRepository.searchByProductName(s);
    }

    public List<String> listProductsByCategoryId(int id) {
        List<String> products = productRepository.listProductsByCategoryId(id);
//        List<String> list = new ArrayList<String>();
//        for (String prod : products) {
//            list.add(  "Product Id : " + products.Pid() + " " +
//                    "Product Name : " + prod.getName() + " " +
//                    "Product Rate : " + prod.getRate());
//        }
        return products;
    }

    public List<String> filterProductByRate(double low, double high) {
        return productRepository.filterProductByRate(low, high);
    }

//    public Category findCategoryById(int id) {
//        return categoryRepository.findById(id);
//    }
//




//For orderDet
//public List<Product> createOrder(int Pid, LocalDate Odate, LocalDate Odel_date, double Quantity, int Cid) {
//    List<Product> products = new ArrayList<>();
//    List<Customer> customers = new ArrayList<>();
//
//    Product prod1 = productRepository.findProductById(Pid);
//    Customer cus1 = customerRepository.findById(Cid);
//
//    Optional<Customer> cus = Optional.ofNullable(cus1);
//    Optional<Product> prod = Optional.ofNullable(prod1);
//
//    if(prod.isPresent() && cus.isPresent()) {
//        OrderDet orderDet = new OrderDet(prod1,Odate, Odel_date, Quantity,cus1);
//        orderDet.setProduct(prod1);
//        products.add(prod1);
//        return productRepository.saveAll(products);
//    }
//    return products;
//}
//
//    public List<String> readAllOrder() {
//        List<OrderDet> orderDet = orderDetRepository.findAll();
//        List<String> list = new ArrayList<String>();
//        for (OrderDet orderDet1 : orderDet) {
//            list.add(  "Order Id : " + orderDet1.getOid() + " " +
//                    "Order Date : " + orderDet1.getOdate()+ " " +
//                    "Order Delivery Date : " + orderDet1.getOdel_date()+ " " +
//                    "Product Quantity : " + orderDet1.getQuantity());
//        }
//        return list;
//    }
//    public String findOrderDetById(int id) {
//        return orderDetRepository.findOrderDetById(id).toString();
//    }
//
//    public int deleteOrderById(int id) {
//        return orderDetRepository.deleteByOrderDetId(id);
//
//    }

    // For customer

//    public List<Customer> createCustomer(int Cid, String Cname) {
//        List<Customer> customers = new ArrayList<>();
//        Customer customer1 = customerRepository.findById(Cid);
//        Optional<Customer> cus = Optional.ofNullable(customer1);
//        if(!cus.isPresent())
//        {
//            Set<OrderDet> orderDet = new HashSet<OrderDet>();
//            Customer customer = new Customer(Cname,orderDet);
//            customer.setOrderDet(orderDet);
//            customers.add(customer);
//            return customerRepository.saveAll(customers);
//        }
//        return  customers;
//    }
//
//    public String findCustomerById(int id) {
//        return customerRepository.findCustomerById(id).toString();
//    }
//
//    public List<String> findCustomerOrderById(int id) {
//        return customerRepository.findCustomerOrderById(id);
//    }
//
//    public int deleteCustomerById(int id) {
//        return customerRepository.deleteCustomerById(id);
//    }



}