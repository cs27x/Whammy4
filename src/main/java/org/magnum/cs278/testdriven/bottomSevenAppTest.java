package org.magnum.cs278.testdriven;

import static org.junit.Assert.*;

import java.util.*;

import org.joda.time.DateTime;
import org.junit.Test;

public class bottomSevenAppTest {
	App app = new App();
	@Test
	public void testGetTodaysEvents() throws Exception {
		
		ArrayList<Event> todaysEvents = new ArrayList<Event>();
		List<Event> events = app.getParkSpecialPermits();
		Calendar calendar = Calendar.getInstance();
	    int year = calendar.get(Calendar.YEAR);
	    int month = calendar.get(Calendar.MONTH);
	    int day = calendar.get(Calendar.DATE);
	    calendar.set(year, month, day, 0, 0, 0);
		for (Event evt : events) {
			if(evt.getDateTime().equals(calendar.getTimeInMillis())){
				todaysEvents.add(evt);
			}
		}
		assertEquals(todaysEvents.toString(), app.getTodaysEvents().toString());
	}
	
	@Test
	public void testGetThreeThingsToDo() throws Exception {
		
		List<Event> toDo = new ArrayList<Event>();
		List<Event> evts = app.getParkSpecialPermits();

		DateTime now = DateTime.now();
		for (Event evt : evts) {
			if (evt.getDateTime().isAfter(now)) {
				toDo.add(evt);
				if (toDo.size() >= 3) {
					break;
				}
			}
		}
		assertEquals(toDo.toString(), app.getThreeThingsToDo().toString());
	}
	
	@Test
	public void testGetRiverFronParkSpecialPermits() throws Exception {
		List<Event> evts = new ArrayList<Event>();

        for (Event evt : app.getParkSpecialPermits()) {
            if (evt.getLocation().toLowerCase().equals("riverfront park")) {
                evts.add(evt);
            }
        }
        assertEquals(evts.toString(), app.getRiverfrontParkSpecialPermits().toString());
	}
	
	@Test
	public void testGetParkSpecialPermitsByAttendance() throws Exception{
		List<Event> evts = app.getParkSpecialPermits();
		Collections.sort(evts, new EventAttendanceComparator());
		assertEquals(evts.toString(), app.getParkSpecialPermitsByAttendance().toString());
	}
	
	@Test
	public void testGetParkSpecialPermits() throws Exception{
		assertEquals(app.getParkSpecialPermits().size(), 390);
	}
	

}
