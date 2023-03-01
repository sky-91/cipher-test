package com.example.ciphertest.controller;

import com.example.ciphertest.param.CustomerParam;
import com.example.ciphertest.result.CustomerResult;
import com.example.ciphertest.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @PostMapping("/add")
    public Integer add(@RequestBody CustomerParam param) {
        return customerService.insert(param);
    }

    @PostMapping("/update")
    public Integer update(@RequestBody CustomerParam param) {
        return customerService.update(param);
    }

    @PostMapping("/delete")
    public Integer delete(@RequestBody CustomerParam param) {
        return customerService.delete(param);
    }

    @PostMapping("/query")
    public List<CustomerResult> query(@RequestBody CustomerParam param) {
        return customerService.query(param);
    }
}
