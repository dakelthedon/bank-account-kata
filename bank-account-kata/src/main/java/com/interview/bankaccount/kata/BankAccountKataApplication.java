package com.interview.bankaccount.kata;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.Logger;

import com.interview.bankaccount.kata.model.Account;
import com.interview.bankaccount.kata.model.OperationEnum;
import com.interview.bankaccount.kata.util.UtilHelper;

public class BankAccountKataApplication {
	private static final Logger logger = Logger.getLogger(BankAccountKataApplication.class.getName());

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// init account
		Account myAccount = new Account(new BigDecimal("1000"));
		myAccount.processOperation(null, OperationEnum.BALANCE, null);
		// adding operations
		myAccount.processOperation(new BigDecimal("40"), OperationEnum.DEBIT, "Huge coffee");
		myAccount.processOperation(new BigDecimal("40.45"), OperationEnum.CREDIT, "Refund Huge coffee");
		myAccount.processOperation(null, OperationEnum.HISTORY, null);
		
		System.out.println("Please enter your operation...\nC for Credit, D for debit, H for History and B for balance");
		OperationEnum opInput = OperationEnum.fromCode(sc.nextLine());
		if (OperationEnum.HISTORY.equals(opInput)) {
			myAccount.processOperation(null, opInput, null);
		} else {
			System.out.println("Please enter an amount...");
			try {
				// getting amount from input
				BigDecimal amount = new BigDecimal(sc.nextLine());
				String label = null;
				if (amount.compareTo(UtilHelper.THOUSAND) > 0) {
					System.out.println("You are not allowed to make an operation (debit or credit) with more than 1.000");
				} else {
					if (OperationEnum.DEBIT.equals(opInput) && amount.compareTo(myAccount.getBalance()) > 0) {
						System.out.println("You are not allowed to have a negative balance");
					} else {
						System.out.println("Please enter a label...");
						// getting label from input
						label = sc.nextLine();
						myAccount.processOperation(amount, opInput, label);
					}
				}
				myAccount.processOperation(null, OperationEnum.HISTORY, null);
			} catch (NumberFormatException nbEx) {
				logger.warning(nbEx.getMessage());
				System.out.println("An error occurred with the amount provided");
			}
		}
		sc.close();
	}
}
