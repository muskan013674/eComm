package com.example.eComm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceProjectApplication implements CommandLineRunner {

//    ProductService productService;
//
//    public ECommerceProjectApplication (ProductService productService) {
//        this.productService = productService;
//    }

    @Override
    public void run(String... args) {
      //  productService.create("top","Ginger top", 1000.9);
       // productService.read();
      //  productService.delete();
    }

    public static void main(String[] args) {
        SpringApplication.run(ECommerceProjectApplication.class, args);

   }

}
