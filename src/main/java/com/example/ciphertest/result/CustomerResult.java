package com.example.ciphertest.result;

import com.example.commoncipher.annotation.EnDecryptField;
import lombok.Data;

@Data
public class CustomerResult {

    private Long id;

    private String name;

    @EnDecryptField(macField = "cardNoMac")
    private String cardNo;

    private String cardNoMac;

    @EnDecryptField
    private String phone;

    private String address;
}
