package com.iiht.training.helper;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Locale;

public class LibraryUtilities {

	public static final String SDF_MMDDYYYY = "MM/dd/yyyy";

	public static Date dateFromString(final String sDate, final String dateFormat) {

		final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);

		try {

			return sdf.parse(sDate);

		} catch (ParseException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return null;

	}

}
