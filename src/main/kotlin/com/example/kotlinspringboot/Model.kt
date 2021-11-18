package com.example.kotlinspringboot

import org.hibernate.usertype.UserType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
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


@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
open class BaseEntityModel {

    @CreatedDate
    @Column(name = "created_dt", insertable = false, updatable = false)
    lateinit var createdDateTime: LocalDateTime

    @LastModifiedDate
    @Column(name = "updated_dt", insertable = false, updatable = false)
    lateinit var updateDateTime: LocalDateTime

}

@Entity
data class Mapping(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
        val senderType: String,
        val senderId: Long,
        val receiverType: String,
        val receiverId: Long,
        val approval: Boolean
): BaseEntityModel() {

}
