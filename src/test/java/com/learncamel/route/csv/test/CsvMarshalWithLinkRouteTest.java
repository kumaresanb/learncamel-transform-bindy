package com.learncamel.route.csv.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.Address;
import com.learncamel.domain.StudentWithAddress;
import com.learncamel.route.csv.CsvMarshalWithLinkRoute;

public class CsvMarshalWithLinkRouteTest extends CamelTestSupport {
	
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new CsvMarshalWithLinkRoute();
	}
	
	@Test
	public void csvMarshalWithLinkRoute() {
		List<StudentWithAddress> suWithAddressList=new ArrayList<StudentWithAddress>();
		StudentWithAddress suWithAddress=new StudentWithAddress();
		Address address=new Address();
		address.setAddressLine("80 nmr layout");
		address.setCity("bangalore");
		address.setState("karnataka");
		address.setCountry("india");
		suWithAddress.setId("1242");
		suWithAddress.setFirstName("kumaresan");
		suWithAddress.setLastName("balakrishnan");
		suWithAddress.setAddress(address);
		suWithAddressList.add(suWithAddress);
		
		StudentWithAddress suWithAddress1=new StudentWithAddress();
		Address address1=new Address();
		address1.setAddressLine("80 west Street");
		address1.setCity("trichy");
		address1.setState("tamilnadu");
		address1.setCountry("india");
		suWithAddress1.setId("24242");
		suWithAddress1.setFirstName("ram");
		suWithAddress1.setLastName("kumar");
		suWithAddress1.setAddress(address1);
		suWithAddressList.add(suWithAddress1);
		template.sendBody("direct:objWihLinkInput",suWithAddressList);
		File fileOutput=new File("data/csv/output-link");
		assertTrue(fileOutput.isDirectory());
	}

}
