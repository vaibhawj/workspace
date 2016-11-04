package day1;

import java.util.Date;

public class MyImmutableDate {

	private Date date;

	public MyImmutableDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return this.date.toString();
	}
}
