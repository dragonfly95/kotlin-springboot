package com.example.kotlinspringboot

import org.springframework.data.repository.CrudRepository

interface Repository: CrudRepository<Product, Long> {
    fun findAllBy(): List<Product>
}