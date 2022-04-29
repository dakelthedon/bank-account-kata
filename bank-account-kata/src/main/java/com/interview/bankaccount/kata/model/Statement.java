package com.interview.bankaccount.kata.model;

import java.math.BigDecimal;
import java.util.Date;

import com.interview.bankaccount.kata.util.UtilHelper;

public class Statement {
	private Date date;
	private OperationEnum operation;
	private BigDecimal amount;
	private String label;
	
	public Statement(OperationEnum operation, BigDecimal amount, String label) {
		super();
		this.date = new Date();
		this.operation = operation;
		this.amount = amount;
		this.label = label; 
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public OperationEnum getOperation() {
		return operation;
	}
	public void setOperation(OperationEnum operation) {
		this.operation = operation;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * Method to display a statement
	 */
	public void displayStatement() {
		StringBuilder statementSb = new StringBuilder();
		statementSb.append(UtilHelper.formatDate(date));
		statementSb.append(UtilHelper.SEPARATOR_STR);
		statementSb.append(operation);
		statementSb.append(UtilHelper.SEPARATOR_STR);
		statementSb.append(OperationEnum.DEBIT.equals(operation) ? "-" + UtilHelper.formatAmount(amount) : UtilHelper.formatAmount(amount));
		statementSb.append(UtilHelper.SEPARATOR_STR);
		statementSb.append(label);
		statementSb.append(UtilHelper.SEPARATOR_STR);
		System.out.println(statementSb.toString());
	}
}
