package com.interview.bankaccount.kata.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilHelper {
	public static final BigDecimal THOUSAND = new BigDecimal(1000);
	public static final String SEPARATOR_STR = " || ";
	public static final String HISTORY_HEADER = "      Date       ||  Operation ||  Amount  || Label  ";
	
	private UtilHelper() {}
	
	/**
	 * Method to format amount with 2 decimals
	 * @param amount : BigDecimal
	 * @return : String
	 */
	public static String formatAmount(BigDecimal amount) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		return amount != null ? decimalFormat.format(amount) : "";
	}
	
	/**
	 * Method to format date
	 * @param date : Date
	 * @return : String
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return date != null ? simpleDateFormat.format(date) : "";
		
	}
	
	/**
	 * Method to check if data string is defined
	 * @param data : String
	 * @return : boolean
	 */
	public static boolean isDefined(String data) {
		return data != null && data.length() > 0;
	}
}
