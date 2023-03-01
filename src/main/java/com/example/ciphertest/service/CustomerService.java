package com.example.ciphertest.service;


import com.example.ciphertest.param.CustomerParam;
import com.example.ciphertest.result.CustomerResult;

import java.util.List;

public interface CustomerService {

    Integer insert(CustomerParam customer);

    Integer update(CustomerParam customer);

    Integer delete(CustomerParam customer);

    List<CustomerResult> query(CustomerParam customer);
}
