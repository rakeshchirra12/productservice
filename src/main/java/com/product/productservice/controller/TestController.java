package com.product.productservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/api")
    public ResponseEntity<String> testApi() {
        String s = "Product Service Application Test ApI";
        return ResponseEntity.accepted().body(s);
    }
}
