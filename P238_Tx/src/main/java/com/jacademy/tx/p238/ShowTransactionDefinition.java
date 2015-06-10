package com.jacademy.tx.p238;

import org.springframework.transaction.TransactionDefinition;

public class ShowTransactionDefinition implements TransactionDefinition{

	@Override
	public int getIsolationLevel() {
		//트랜잭션의 격리레벨을 결정
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPropagationBehavior() {
		//트랜잭션이 실행되어야 하는 범위에 대한 제어 및 여러개의 트랜잭션이 상호작용하는 것에 대한 결정
		return 0;
	}

	@Override
	public int getTimeout() {
		//실행하는 트랜잭션이 시작해서 종료할 때 까지의 시간을 초단위 제어
		return 0;
	}

	@Override
	public boolean isReadOnly() {
		//실행하는 트랜잭션이 red-only상태 여부를 결정가능
		return false;
	}

}
