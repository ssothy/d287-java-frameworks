package com.example.demo.controllers;


import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping ("/buy-product")
    public String buyProduct(@RequestParam Long productId) {
        boolean success = productService.buyProduct(productId);
        if (success) {
            return "redirect:/success-page?message=Purchase successful!";
        } else {
            return "redirect:/error-page?message=Failed to purchase product. Product may be out of stock.";
        }
    }

}
