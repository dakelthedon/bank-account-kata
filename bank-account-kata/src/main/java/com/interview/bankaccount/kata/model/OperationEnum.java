package com.interview.bankaccount.kata.model;

import java.util.Arrays;

public enum OperationEnum {
	CREDIT("C"), DEBIT("D"), BALANCE("B"), HISTORY("H");
	
	private String code;
	OperationEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	public static OperationEnum fromCode(String code) {
		return Arrays.stream(OperationEnum.values())
				.filter(op -> op.getCode().equalsIgnoreCase(code))
				.findFirst()
				.orElse(HISTORY);
	}
}
