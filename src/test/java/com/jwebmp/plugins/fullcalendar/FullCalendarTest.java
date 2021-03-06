/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwebmp.plugins.fullcalendar;

import com.jwebmp.plugins.fullcalendar.options.FullCalendarEvent;
import com.jwebmp.plugins.fullcalendar.options.enumerations.FullCalendarHeaderParts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author GedMarc
 */
public class FullCalendarTest
{

	public FullCalendarTest()
	{
	}

	@Test
	public void testSomeMethod()
	{
		FullCalendar fc = new FullCalendar();
		fc.setID("fc");
		System.out.println(fc.renderJavascript());
		Assertions.assertEquals("$(\"#fc\").fullCalendar();\n", fc.renderJavascript()
		                                                          .toString());
	}

	@Test
	public void testTag()
	{
		FullCalendar fc = new FullCalendar();
		fc.setID("fc");
		System.out.println(fc.toString(true));
		Assertions.assertEquals("<div id=\"fc\"></div>", fc.toString(true));
	}

	@Test
	public void testComplex()
	{
		FullCalendar calendar = new FullCalendar();

		Date evDate = new Date(2017, 4, 4, 0, 0, 0);

		calendar.getOptions()
		        .setNavLinks(true);
		calendar.getOptions()
		        .setEditable(true);
		calendar.getOptions()
		        .setTheme(true);

		calendar.getOptions()
		        .getEvents()
		        .getEvents()
		        .add(new FullCalendarEvent().setTitle("Event 1")
		                                    .setStart(evDate));

		calendar.getOptions()
		        .getEvents()
		        .getEvents()
		        .add(new FullCalendarEvent().setTitle("Event 2")
		                                    .setStart(evDate));
		calendar.getOptions()
		        .getEvents()
		        .getEvents()
		        .add(new FullCalendarEvent().setTitle("Event 3")
		                                    .setStart(evDate));
		calendar.getOptions()
		        .getEvents()
		        .getEvents()
		        .add(new FullCalendarEvent().setTitle("Event 4")
		                                    .setStart(evDate));
		calendar.getOptions()
		        .getEvents()
		        .getEvents()
		        .add(new FullCalendarEvent().setTitle("Event 5")
		                                    .setStart(evDate));
		calendar.getOptions()
		        .getEvents()
		        .getEvents()
		        .add(new FullCalendarEvent().setTitle("Event 6")
		                                    .setStart(evDate));

		calendar.getOptions()
		        .getHeader()
		        .setLeft(FullCalendarHeaderParts.prev, FullCalendarHeaderParts.next, FullCalendarHeaderParts.space, FullCalendarHeaderParts.today);
		calendar.getOptions()
		        .getHeader()
		        .setCenter(FullCalendarHeaderParts.title);
		calendar.getOptions()
		        .getHeader()
		        .setRight(FullCalendarHeaderParts.month, FullCalendarHeaderParts.agendaWeek, FullCalendarHeaderParts.agendaDay, FullCalendarHeaderParts.listWeek);

		calendar.setID("fc");

		System.out.println(calendar.renderJavascript());

		Assertions.assertEquals(
				"$(\"#fc\").fullCalendar({\n" +
				"  \"header\" : {\n" +
				"    \"left\" : \"prev,next, today\",\n" +
				"    \"right\" : \"month,agendaWeek,agendaDay,listWeek\",\n" +
				"    \"center\" : \"title\"\n" +
				"  },\n" +
				"  \"navLinks\" : true,\n" +
				"  \"editable\" : true,\n" +
				"  \"events\" : [ {\n" +
				"    \"title\" : \"Event 1\",\n" +
				"    \"start\" : 61451992800000\n" +
				"  }, {\n" +
				"    \"title\" : \"Event 2\",\n" +
				"    \"start\" : 61451992800000\n" +
				"  }, {\n" +
				"    \"title\" : \"Event 3\",\n" +
				"    \"start\" : 61451992800000\n" +
				"  }, {\n" +
				"    \"title\" : \"Event 4\",\n" +
				"    \"start\" : 61451992800000\n" +
				"  }, {\n" +
				"    \"title\" : \"Event 5\",\n" +
				"    \"start\" : 61451992800000\n" +
				"  }, {\n" +
				"    \"title\" : \"Event 6\",\n" +
				"    \"start\" : 61451992800000\n" +
				"  } ],\n" +
				"  \"theme\" : true\n" +
				"});",
				calendar.renderJavascript()
				        .toString()
				        .trim());
	}

}
