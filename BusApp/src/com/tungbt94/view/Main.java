package com.tungbt94.view;

import com.tungbt94.model.Bus;

public class Main {
	public static void main(String[] args) {
		Bus bus = new Bus();
		bus.setStart("Nhổn");
		bus.setEnd("PTIT");
		bus.getJourney();
	}
}
