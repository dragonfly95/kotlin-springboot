package com.example.kotlinspringboot

@RestController
class HelloController {

    @GetMapping("/")
    fun hello(): String {
        return "Hello API"
    }
}