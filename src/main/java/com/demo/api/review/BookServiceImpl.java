package com.demo.api.review;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    @Override
    public void doNotTransactionAction() {
        log.info("doNotTransactionAction : {}",
            TransactionSynchronizationManager.getCurrentTransactionName());
        Assert.isNull(TransactionSynchronizationManager.getCurrentTransactionName());
        doTransactionAction();
    }

    @Transactional(readOnly = true)
    @Override
    public void doTransactionAction() {
        log.info("doTransactionAction : {}",
            TransactionSynchronizationManager.getCurrentTransactionName());
        Assert.notNull(TransactionSynchronizationManager.getCurrentTransactionName());
    }
}
