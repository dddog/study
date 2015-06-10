package com.jacademy.tx.p239;

import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

//PlatformTransactionManager에서 트랜잭션을 Commit할 것인지
//Rollback할 것인지를 결정하기 위해 사용한다.
public class ShowTransactionStatus implements TransactionStatus{

	@Override
	public Object createSavepoint() throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void releaseSavepoint(Object arg0) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollbackToSavepoint(Object arg0) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasSavepoint() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNewTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRollbackOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRollbackOnly() {
		// TODO Auto-generated method stub
		
	}

}
