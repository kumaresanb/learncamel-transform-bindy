package com.learncamel.route.csv.test;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.Student;
import com.learncamel.route.csv.CsvUnmarshalRoute;

public class CsvUnmarshalRouteTest extends CamelTestSupport {
	
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new CsvUnmarshalRoute();
	}
	
	@Test
	public void csvUnmarshalRoute() throws InterruptedException {
		Exchange exchange=consumer.receive("direct:output");
		Thread.sleep(5000);
		List<Student>  listStudents = (List<Student>) exchange.getIn().getBody();
		assertEquals("1234", listStudents.get(0).getId());
		assertEquals("ram", listStudents.get(1).getFirstName());
	}

}
