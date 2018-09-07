package com.learncamel.route.csv.test;

import java.time.LocalDate;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.EmployeeWithFixedLeangth;
import com.learncamel.route.csv.FixedLeangthUnMarshalRoute;

public class FixedLeangthUnMarshalRouteTest extends CamelTestSupport {
	
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new FixedLeangthUnMarshalRoute();
	}
	
	@Test
	public void fixedLengthUnmarshal() throws InterruptedException {
		Exchange exchange=consumer.receive("direct:output");
		Thread.sleep(5000);
		List<EmployeeWithFixedLeangth>  liEmployeeWithFixedLeangths =  (List<EmployeeWithFixedLeangth>) exchange.getIn().getBody();
		assertNotNull(liEmployeeWithFixedLeangths);
		assertEquals(1234, liEmployeeWithFixedLeangths.get(0).getId());
		assertEquals("kamal", liEmployeeWithFixedLeangths.get(1).getName());
		assertEquals("Tester", liEmployeeWithFixedLeangths.get(1).getRole());
		LocalDate localDate=LocalDate.of(2011, 6, 12);
		LocalDate localDate2=LocalDate.of(2018, 8, 12);
		assertEquals(localDate.getYear(), liEmployeeWithFixedLeangths.get(0).getJoiningDate().getYear());
		assertEquals(localDate2.getYear(), liEmployeeWithFixedLeangths.get(1).getJoiningDate().getYear());
		assertEquals(31, liEmployeeWithFixedLeangths.get(0).getAge());
		assertEquals(34, liEmployeeWithFixedLeangths.get(1).getAge());
		
	}

}
