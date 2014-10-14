package org.magnum.cs278.testdriven;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.magnum.cs278.testdriven.App;
import org.magnum.cs278.testdriven.Event;

public class AppClassFirstSeven {

	App app = new App();
	@Test
	public void testAttendanceGreaterThanFive() throws Exception {
		List<Event> events = app.AttendanceGreaterThanFive();
		assertTrue(events.size() > 0);
		for(Event event : events){
		 assertTrue(Integer.parseInt(event.getAttendance()) > 5);
			// System.err.println(event.getAttendance());
		}
	}
		

}
