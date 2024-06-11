package com.store.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {


    @GetMapping("/products")
    public void getProducts(@RequestParam(required = false) String type) {
    }

}