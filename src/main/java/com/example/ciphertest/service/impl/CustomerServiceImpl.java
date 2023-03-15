package com.example.ciphertest.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.example.ciphertest.aop.HelloPoint;
import com.example.ciphertest.entity.Customer;
import com.example.ciphertest.enums.AccountTypeEnum;
import com.example.ciphertest.param.CustomerParam;
import com.example.ciphertest.repository.CustomerRepository;
import com.example.ciphertest.result.CustomerResult;
import com.example.ciphertest.router.AccountTypeOperatorRouter;
import com.example.ciphertest.service.AccountTypeOperator;
import com.example.ciphertest.service.CustomerService;
import com.example.commoncipher.annotation.EnDecryptMapperMethod;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private AccountTypeOperatorRouter accountTypeRouter;

    @Override
    @HelloPoint
    @EnDecryptMapperMethod
    public Integer insert(CustomerParam customer) {
        AccountTypeEnum typeEnum = AccountTypeEnum.parseOfNullable(customer.getAccountType());
        AccountTypeOperator operator = accountTypeRouter.route(typeEnum);
        operator.checkAccountExists(customer);

        Customer entity = BeanUtil.copyProperties(customer, Customer.class);
        customerRepository.save(entity);
        return 1;
    }

    @Override
    @HelloPoint
    @EnDecryptMapperMethod
    public Integer update(CustomerParam customer) {
        customerRepository.findById(customer.getId()).ifPresent(entity -> {
            BeanUtil.copyProperties(customer, entity, CopyOptions.create().setIgnoreNullValue(true));
            customerRepository.save(entity);
        });
        return 1;
    }

    @Override
    public Integer delete(CustomerParam customer) {
        customerRepository.deleteById(customer.getId());
        return 1;
    }

    @Override
    @EnDecryptMapperMethod
    public List<CustomerResult> query(CustomerParam customer) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("phone", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Customer> example = Example.of(BeanUtil.copyProperties(customer, Customer.class), matcher);

        return BeanUtil.copyToList(customerRepository.findAll(example), CustomerResult.class);
    }
}
