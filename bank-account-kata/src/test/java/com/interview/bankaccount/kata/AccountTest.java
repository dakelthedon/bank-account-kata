package com.interview.bankaccount.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.interview.bankaccount.kata.model.Account;
import com.interview.bankaccount.kata.model.OperationEnum;
import com.interview.bankaccount.kata.util.UtilHelper;

public class AccountTest {
	
	@Test
	public void processOperation_test() {
		Account account = new Account(UtilHelper.THOUSAND);
		account.processOperation(new BigDecimal(10), OperationEnum.CREDIT, "");
		assertEquals(account.getBalance(), new BigDecimal(1010));
		account.processOperation(new BigDecimal(10), OperationEnum.DEBIT, "");
		assertEquals(account.getBalance(), UtilHelper.THOUSAND);
		account.processOperation(null, OperationEnum.BALANCE, "");
		account.processOperation(null, OperationEnum.HISTORY, "");
	}
}
