package com.example.kotlinspringboot

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import javax.transaction.Transactional

@SpringBootTest
class KotlinSpringbootApplicationTests {

	@Autowired
	private lateinit var productRepository: Repository

	@Test
	@Transactional
	@Rollback(false)
	fun contextLoads() {
		val product = Product(null, "oo", Category.Phone);
		productRepository.save(product)
	}

}
