package org.magnum.cs278.testdriven;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AppTestPt2 {

    private static final String TEST_LOCATION = "Centennial Park Event Shelter";
    private App mApp = new App();

    @Test
    public void testGetEventsLargerThan() throws Exception {
        for (Event e : mApp.getEventsLargerThan(5))
            assertTrue(Integer.parseInt(e.getAttendance()) > 5);
    }

    @Test
    public void testGetEventsWithLocation() throws Exception {
        for (Event e : mApp.getEventsWithLocation(TEST_LOCATION))
            assertTrue(e.getLocation().equals(TEST_LOCATION));
    }

    @Test
    public void testGetFirstEventOfMonth() throws Exception {
        final List<Event> evts = mApp.getMarchEvents2014();
        Event first = evts.get(0);
        for (Event e : evts)
            if (e.getDateTime().isBefore(first.getDateTime()))
                first = e;
        assertEquals(first.getDate(), mApp.getFirstEventOfMonth("Mar-2014").getDate());
    }

    @Test
    public void testGetMarchEvents2014() throws Exception {
        for (Event e : mApp.getMarchEvents2014()) {
            assertTrue(e.getMonth().equals("Mar-2014"));
        }
    }

//    @Test
//    public void testGetNamesEvents() throws Exception{
//        assertEquals(mApp.getParkSpecialPermits().size(), mApp.getNamesEvents().size());
//        List<String> names = new ArrayList<String>();
//        for(Event evt: mApp.getParkSpecialPermits()){
//            names.add(evt.getName());
//        }
//        for (int i = 0; i < names.size(); i++) {
//            assertTrue(names.get(i).equals(mApp.getNamesEvents().get(i)));
//        }
//    }

}
