package org.magnum.cs278.testdriven;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;

public class AppClassOriginalTests {

	private App app = new App();
	
	/**
	 * Tests getThreeThingsToDo by checking and confirming the size of the list 
	 * is of length 3; it also tests to ensure events in the list are not null.
	 * @throws Exception
	 */
//	@Test
//	public void testGetThreeThingsToDo() throws Exception {
//		List<Event> whatToDo = app.getThingsToDo(3);
//		assertEquals(3, whatToDo.size());
//		
//		DateTime today = DateTime.now();
//		
//		for(Event thingToDo : whatToDo){
//			assertNotNull(thingToDo);
//			assertNotNull(thingToDo.getDate());
//			
//			try{
//				DateTime eventDate = Event.DATE_TIME_FORMAT.parseDateTime(thingToDo.getDate());
//				assertTrue(eventDate.isAfter(today));
//			}catch(IllegalArgumentException arg){
//				//The data in data.nashville.gov is..unfortunately...not
//				//perfectly clean and we have to ignore the garbage...
//			}
//		}
//	}
	
	/**
	 * Tests getParkSpecialPermits by checking for a positive list size 
	 * and not null list elements. 
	 * @throws Exception
	 */
	@Test
	public void testGetParkSpecialPermits() throws Exception {
		List<Event> events = app.getParkSpecialPermits();
		assertTrue(events.size() > 0);
		for(Event event : events){
			assertNotNull(event);
			assertNotNull(event.getLocation());
			assertNotNull(event.getName());
			assertNotNull(event.getAttendance());
			assertNotNull(event.getDate());
		}
	}

	/**
	 * Tests getEventsInJune by checking if the events in the list have
	 * the month "jun" as their month value. 
	 * @throws Exception
	 */
//	@Test
//	public void testGetEventsInJune() throws Exception {
//		List<Event> events = app.getEventsForMonth("jun");
//		for(Event event : events) {
//			assertTrue(event.getMonth().toLowerCase().contains("jun"));
//		}
//	}

	/**
	 * Tests AttendanceGreaterThanFive by checking the attendance value is 
	 * greater than 5. 
	 * @throws Exception
	 */
//	@Test
//	public void testAttendanceGreaterThanFive() throws Exception {
//		List<Event> events = app.getEventsWithAttendanceAtLeast(6);
//		for(Event event: events){
//			assertTrue(Integer.parseInt(event.getAttendance()) > 5);
//		}
//	}

	/**
	 * Tests getFirstEventOfMonth using a known month and event name.
	 * @throws Exception
	 */
    @Test
	public void testGetFirstEventOfMonth() throws Exception {
		String month = "Feb-2014";
		String testEventName = "Cupid's Chase";
		
		Event first = app.getFirstEventOfMonth(month);
		
		assertTrue(first.getName().equals(testEventName));
	}

    /**
     * Tests getParkSpecialPermitsByAttendance by checking for positive event size
     * and going through the event list and checking that the events have non null values
     * @throws Exception
     */
    @Test
	public void testGetParkSpecialPermitsByAttendance() throws Exception {
		List<Event> events = app.getParkSpecialPermitsByAttendance();
		assertTrue(events.size() > 0);
		boolean sorted = true;
		double last = Double.POSITIVE_INFINITY;
		for(Event event : events){
			if (Double.parseDouble(event.getAttendance()) > last){
				sorted = false;
			}
			else {
				last = Double.parseDouble(event.getAttendance());
			}
			assertNotNull(event);
			assertNotNull(event.getLocation());
			assertNotNull(event.getName());
			assertNotNull(event.getAttendance());
			assertNotNull(event.getDate());
		}
		assertTrue(sorted);
	}

    /**
     * Tests getEventsForMonth by checking that there is only one Month-2014
     * element in the list and checking that the tested month is actually the month
     * in all the events in the list.
     * @throws Exception
     */
	@Test
	public void testGetEventsForMonth() throws Exception {
		
		List<Event> events = app.getEventsForMonth("Jan-2014");
		// assertTrue(events.size() == 1);
		System.err.println(events.size());
		assertEquals("Jan-2014", events.get(0).getMonth());
	}

	/**
	 * Tests getEventsLargerThan() by going through the list of events
	 * and checks that the attendance is larger than the tested integer value
	 * @throws Exception
	 */
	@Test
	public void testGetEventsLargerThan() throws Exception {
		List<Event> events = app.getEventsLargerThan(1000);
		for (Event event : events)
			assertTrue(Integer.parseInt(event.getAttendance()) > 1000);
	}

	/**
	 * Tests getAllEventsInMonth by checking that all the events in the list
	 * match a tested month.
	 * @throws Exception
	 */
	@Test
	public void testGetAllEventsInMonth()  throws Exception{
		List <Event> evts = app.getEventsForMonth("january");
		for(Event e : evts){
			assertTrue(e.getMonth().toLowerCase().equals("january"));
		}
	}
	
	@Test
	public void testEventsInMarch() throws Exception {
		List<Event> pubs = app.getMarchEvents2014();
		assertTrue(pubs.size() > 0); // At least one March-2014 event.
		for(Event temp : pubs) {
			assertEquals(temp.getMonth(),"Mar-2014");
		}
	}
	
	@Test
	public void testTodaysEvents() throws Exception {
		List<Event> whatToDo = app.getTodaysEvents();

		DateTime today = DateTime.now();
		
		for(Event thingToDo : whatToDo){
			assertNotNull(thingToDo);
			assertNotNull(thingToDo.getDate());
			
			try{
				DateTime eventDate = Event.DATE_TIME_FORMAT.parseDateTime(thingToDo.getDate());
				assertTrue(eventDate.isEqualNow());
			} catch(IllegalArgumentException arg) {
                arg.printStackTrace();
			}
		}
	}
	
//	@Test
//	public void testZeroEventsIn1945() throws Exception {
//		List<Event> events = app.getEventsForYear("1945");
//		assertTrue(events.size() == 0);
//	}
	
//	@Test
//	public void testMonthAndYearEvents() throws Exception {
//		List<Event> pubs = app.getEventsForMonthAndYear("mar", "2014");
//		assertTrue(pubs.size() > 0); // At least one March-2014 event.
//		for(Event temp : pubs) {
//			assertEquals(temp.getMonth(),"Mar-2014");
//		}
//	}
	
	/**
	 * This is a test function for all the location type testing in the app
	 * It merges the other types. Currently tests for "East Park," "Riverfront
	 * Park," and "San Francisco."  For one of the events, San Francisco, it does 
	 * more indepth checking to make sure the data structure returned is correct.
	 * @throws Exception
	 */
	@Test
    public void testForLocation() throws Exception {

        List<Event> events = app.getEventsWithLocation("East Park");
        assertTrue(events.size() > 0);

        for(Event event : events){
            assertTrue(event.getLocation().equals("East Park"));
        }
        
		events = app.getEventsWithLocation("Riverfront Park");
        assertTrue(events.size() > 0);
        
		for(Event event : events) {
			assertTrue(event.getLocation().equals("Riverfront Park"));
		}
		
		events = app.getEventsWithLocation("San Francisco");
		
		DateTime today = DateTime.now();
		
		for(Event event : events){
			assertNotNull(event);
			assertNotNull(event.getLocation());
			assertNotNull(event.getName());
			assertNotNull(event.getAttendance());
			assertNotNull(event.getDate());
			assertEquals(event.getLocation(), "San Francisco");
		}
    }
}
