package com.interview.bankaccount.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.interview.bankaccount.kata.util.UtilHelper;

public class UtilHelperTest {

	@Test
	public void allUtils_test() {
		assertEquals(UtilHelper.formatAmount(new BigDecimal("10.456")), "10,46");
		assertEquals(UtilHelper.formatAmount(null), "");
		
		assertEquals(UtilHelper.formatDate(new Date()).length(), 16);
		assertEquals(UtilHelper.formatDate(null), "");
	}
}
