package com.example.kotlinspringboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Autowired
    private lateinit var productRepository: Repository

    @GetMapping("/")
    fun hello(): List<Product> {
        return productRepository.findAllBy()
//        return "Hello API"
    }
}