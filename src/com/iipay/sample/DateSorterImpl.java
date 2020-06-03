package com.iipay.sample;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class DateSorterImpl implements DateSorter {
	private static final String RCHAR="r"; 

	public SortedSet<LocalDate> sortDates(Set<LocalDate> unsortedDates) {
		SortedSet<LocalDate> sortedDates = new TreeSet<LocalDate>(new DateComparator());
		sortedDates.addAll(unsortedDates);
		return sortedDates;
	}
	
	private class DateComparator implements Comparator<LocalDate> {
		@Override
		public int compare(LocalDate o1, LocalDate o2) {
			boolean o1hasR = nameOfMonthContains(o1,RCHAR);
			boolean o2hasR = nameOfMonthContains(o2,RCHAR);

			if (o1hasR == o2hasR) { // if both have the same "R-ank"
				if (o1.isEqual(o2))
					return 0; // dates are equal
				if (o1.isAfter(o2)) {
					return o1hasR ? 1 : -1; // return compare result in direction according to R order
				}
			}
			return o1hasR ? -1 : 1; // else the one that contains R has higher order OR same if "R-anks" are equal
		}
	}

	private static boolean nameOfMonthContains(LocalDate date, String contain) {
		if (date==null || contain==null) return false;
		return date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).contains(contain);
	}

	public static void main(String[] args) {
		DateSorter ds = new DateSorterImpl();
		
		var originalTestSet = Set.of(LocalDate.of(2019, 7, 1), LocalDate.of(2019, 1, 2), LocalDate.of(2019, 1, 1), LocalDate.of(2019, 5, 3));
		System.out.println(ds.sortDates(originalTestSet));

		var testset2 = Set.of(LocalDate.of(2019, 10, 23), LocalDate.of(2019, 7, 1), LocalDate.of(2019, 12, 30), LocalDate.of(2019, 8, 6), LocalDate.of(2019, 6, 14), LocalDate.of(2019, 2, 7), LocalDate.of(2019, 1, 2),
				LocalDate.of(2019, 1, 1), LocalDate.of(2019, 5, 3));
		System.out.println(ds.sortDates(testset2));
	}
}
