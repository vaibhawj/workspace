package day1;

import java.util.Calendar;
import java.util.Date;

public class ImmutableBreaker {

	public static void main(String[] args) {
		Date d1 = Calendar.getInstance().getTime();
		Date d2 = Calendar.getInstance().getTime();
		// System.out.println(myDate);
		MyImmutableDate myDate = new MyImmutableDate(d1);
		System.out.println(myDate);
		myDate.getDate().toInstant();

	}

}
