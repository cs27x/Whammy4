package org.magnum.cs278.testdriven;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

public class EventWhammyTests {

	@Test
	public void testGetName() throws Exception{
		Event event = new Event("Party", "Nashville", "100", "January", "1/1/12");
		assertTrue("Party".equals(event.getName()));
	}
	
	@Test
	public void testGetLocation() throws Exception {
		Event event = new Event("Party", "Nashville", "100", "January", "1/1/12");
		assertTrue("Nashville".equals(event.getLocation()));
	}
	
	@Test
	public void testGetAttendance() throws Exception{
		Event event = new Event("Party", "Nashville", "100", "January", "1/1/12");
		assertTrue("100".equals(event.getAttendance()));
	}
	
	@Test
	public void testGetMonth() throws Exception{
		Event event = new Event("Party", "Nashville", "100", "January", "1/1/12");
		assertTrue("January".equals(event.getMonth()));
	}
	
	@Test
	public void testGetDate() throws Exception {
		Event event = new Event("Party", "Nashville", "100", "January", "1/1/12");
		assertTrue("1/1/12".equals(event.getDate()));
	}
	
	@Test
	public void testGetDateTimeNoError() throws Exception {
		Event event = new Event("Party", "Nashville", "100", "January", "1/1/12");
		DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormat.forPattern("M/d/yy");
		assertTrue((DATE_TIME_FORMAT.parseDateTime("1/1/12")).equals(event.getDateTime()));
	}
	
	@Test
	public void testToString() throws Exception {
		Event event = new Event("Party", "Nashville", "100", "January", "1/1/12");
		assertTrue("Party / Nashville / 100 / January / 1/1/12".equals(event.toString()));
	}
	
	

}
