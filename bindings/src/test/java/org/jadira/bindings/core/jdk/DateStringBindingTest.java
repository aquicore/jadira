/*
 *  Copyright 2010 Chris Pheby
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.jadira.bindings.core.jdk;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;

public class DateStringBindingTest {

    private static final DateStringBinding BINDING = new DateStringBinding();
    
    @Test
    public void testUnmarshal() {

        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(0); cal.set(2000, 10, 1, 23, 45);
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        assertEquals(cal.getTime(), BINDING.unmarshal("2000-11-01T23:45:00.000+00:00"));      
    }
    
    @Test
    public void testMarshal() {
        
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(0); cal.set(2000, 10, 1, 23, 45);
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        assertEquals("2000-11-01T23:45:00.000+00:00", BINDING.marshal(cal.getTime()));
    }
}
