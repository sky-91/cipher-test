package com.example.ciphertest.router;

import com.example.ciphertest.enums.AccountTypeEnum;
import com.example.ciphertest.service.AccountTypeOperator;
import com.example.commoncipher.operator.OperatorRouter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AccountTypeOperatorRouter extends OperatorRouter<AccountTypeEnum, AccountTypeOperator> {

    @Override
    protected void handleBadRoute(AccountTypeEnum routeKey) {
        log.info("AccountTypeOperatorRouter handleBadRoute routeKey : {}", routeKey.getCode());
        // 提前抛异常，避免空指针异常
    }

    @Override
    public Class<AccountTypeOperator> getOperatorClass() {
        return AccountTypeOperator.class;
    }

}
