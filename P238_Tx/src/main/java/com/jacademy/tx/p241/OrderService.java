package com.jacademy.tx.p241;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class OrderService {

	@Resource(name = "txManager")
	protected DataSourceTransactionManager txManager;
	protected TransactionTemplate transactionTemplate;

	@PostConstruct
	public void init() {
		transactionTemplate = new TransactionTemplate(txManager);
	}

	public void myTran(final PutAccountInfoRequest request) throws Exception {
		// write log
		MyTranResult result = (MyTranResult) transactionTemplate.execute(
				new TransactionCallback<Object>() {
					@Override
					public Object doInTransaction(TransactionStatus status) {
						boolean success = false;
						Exception exception = null;
						try {
							// 트랜잭션1
							// 트랜잭션2
						} catch (Exception ex) {
							exception = ex;
							status.setRollbackOnly();
						}
						return new MyTranResult();
					}
				});
		// write transaction result
	}
}
