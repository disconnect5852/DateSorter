/*
* Copyright 2004-2019 Integrated International Payroll, Ltd.
* All rights reserved. Unauthorized use is forbidden.
* Contact iiPay Ltd in the case of any uncertainty.
*/
package com.iipay.sample;

import java.time.LocalDate;
import java.util.Set;
import java.util.SortedSet;

/**
* The Date sorter interface, implement the single method
* within this interface.
*/
public interface DateSorter {
	/**
	* The implementation of this method should sort dates. The
	* output should be in the following order:
	* Dates with an &#39;r&#39; in the month, sorted ascending
	* (first to last),
	* then dates without an &#39;r&#39; in the month, sorted descending
	* (last to first).
	* thus: (01/07/19, 02/01/19, 01/01/19, 03/05/19) would sort
	* to (01/01/19, 02/01/19, 01/07/19, 03/05/19)
	* @param unsortedDates - an unsorted list of dates
	* @return The list of dates now sorted as per the spec
	*/
	SortedSet<LocalDate> sortDates(Set<LocalDate> unsortedDates);
	
}
