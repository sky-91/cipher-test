package com.example.ciphertest.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@DynamicUpdate
@Entity(name = "TEST_CUSTOMER")
public class Customer implements Serializable {

    @Id
    private Long id;

    @Column(unique = true, length = 32)
    private String name;

    @Column(unique = true)
    private String cardNo;

    @Column
    private String cardNoMac;

    @Column
    private String phone;

    @Column(length = 128)
    private String address;
}
