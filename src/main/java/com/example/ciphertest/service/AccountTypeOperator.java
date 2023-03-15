package com.example.ciphertest.service;

import com.example.ciphertest.enums.AccountTypeEnum;
import com.example.ciphertest.param.CustomerParam;
import com.example.commoncipher.operator.Operator;

import java.util.function.BiConsumer;
import java.util.function.Function;

public interface AccountTypeOperator extends Operator<AccountTypeEnum> {

    /**
     *
     * @return
     */
    BiConsumer<CustomerParam, String> getAccountSetter();

    /**
     *
     * @return
     */
    Function<CustomerParam, String> getAccountGetter();

    /**
     * 校验账号不存在. 若存在, 则抛异常
     * @param customer
     */
    void checkAccountNotExists(CustomerParam customer);

    /**
     * 校验账号存在. 若不存在, 则抛异常
     * @param customer
     */
    void checkAccountExists(CustomerParam customer);

    default String getAccount(CustomerParam customer) {
        return getAccountGetter().apply(customer);
    }

    default void setAccount(CustomerParam customer, String account) {
        getAccountSetter().accept(customer, account);
    }

}
