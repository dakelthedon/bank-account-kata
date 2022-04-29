package com.interview.bankaccount.kata.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.interview.bankaccount.kata.util.UtilHelper;

public class Account {
	
	private BigDecimal balance;
	private List<Statement> statements = new ArrayList<>();
	
	public Account(BigDecimal balance) {
		super();
		this.balance = balance;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public List<Statement> getStatements() {
		return statements;
	}
	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}
	
	public void processOperation(BigDecimal amount, OperationEnum operation, String label) {
		switch (operation) {
			case BALANCE:
			displayBalance();
				break;
			case HISTORY:
				System.out.println(UtilHelper.HISTORY_HEADER);
				this.statements.stream().forEach(Statement::displayStatement);
				this.displayBalance();
				break;
			case CREDIT:
				// adding amount to balance
				this.balance = this.balance.add(amount);
				// adding new statement
				this.statements.add(new Statement(operation, amount, label));
				System.out.println("a new deposit of " + UtilHelper.formatAmount(amount) + " has been made on your account");
				break;
			case DEBIT:
				this.balance = this.balance.subtract(amount);
				// adding new statement
				this.statements.add(new Statement(operation, amount, label));
				System.out.println("a new withdrawal of " + UtilHelper.formatAmount(amount) + " has been made on your account");
				break;
			default:
				break;
		}
	}
	private void displayBalance() {
		System.out.println(UtilHelper.formatDate(new Date()) + " your balance is " + UtilHelper.formatAmount(this.balance));
	}
}
