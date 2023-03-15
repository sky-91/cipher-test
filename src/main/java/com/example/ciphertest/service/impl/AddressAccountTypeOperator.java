package com.example.ciphertest.service.impl;

import com.example.ciphertest.enums.AccountTypeEnum;
import com.example.ciphertest.param.CustomerParam;
import com.example.ciphertest.service.AccountTypeOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;
import java.util.function.Function;

@Component
@Slf4j
public class AddressAccountTypeOperator implements AccountTypeOperator {

    @Override
    public AccountTypeEnum getName() {
        return AccountTypeEnum.ADDRESS;
    }

    @Override
    public BiConsumer<CustomerParam, String> getAccountSetter() {
        return CustomerParam::setAddress;
    }

    @Override
    public Function<CustomerParam, String> getAccountGetter() {
        return CustomerParam::getAddress;
    }

    @Override
    public void checkAccountNotExists(CustomerParam customer) {
        log.info("AddressAccountTypeOperator checkAccountNotExists : {}", customer.getAddress());
        // 校验地址是否已被使用. 若被使用, 则抛异常
    }

    @Override
    public void checkAccountExists(CustomerParam customer) {
        log.info("AddressAccountTypeOperator checkAccountExists : {}", customer.getAddress());
        // 校验地址是否已被使用. 若没找到对应记录, 则抛异常
    }
}
