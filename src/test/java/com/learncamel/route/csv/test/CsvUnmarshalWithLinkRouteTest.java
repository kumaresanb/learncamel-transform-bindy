package com.learncamel.route.csv.test;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.StudentWithAddress;
import com.learncamel.route.csv.CsvUnmarshalWithLinkRoute;

public class CsvUnmarshalWithLinkRouteTest extends CamelTestSupport {
	
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new CsvUnmarshalWithLinkRoute();
	}
	
	
	@Test
	public void csvUnmarshalWithLinkRoute() throws InterruptedException {
		Exchange exchange=consumer.receive("direct:output");
		Thread.sleep(5000);
		List<StudentWithAddress>  liStudentWithAddresses = (List<StudentWithAddress>) exchange.getIn().getBody();
		assertEquals("1234", liStudentWithAddresses.get(0).getId());
		assertEquals("ram", liStudentWithAddresses.get(1).getFirstName());
		assertEquals("bangalore", liStudentWithAddresses.get(0).getAddress().getCity());
		assertEquals("tamilnadu", liStudentWithAddresses.get(1).getAddress().getState());
		
	}

}
