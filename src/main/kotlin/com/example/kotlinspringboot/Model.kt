package com.example.kotlinspringboot

import java.time.OffsetDateTime
import javax.persistence.*

enum class Category {
    Phone, Laptop, Keyboard
}

@Entity
data class Product(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String,
        @Enumerated(EnumType.STRING)
        val category: Category,
        val createDateTime: OffsetDateTime = OffsetDateTime.now(),
        val udpateDateTime: OffsetDateTime? = null
) {


}