package com.learncamel.route.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

import com.learncamel.domain.StudentWithAddress;

public class CsvMarshalWithLinkRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:objWihLinkInput")
		.log("Recived Message is: ${body}")
		.marshal(new BindyCsvDataFormat(StudentWithAddress.class))
		.log("Marshaled message is:${body}")
		.to("file:data/csv/output-link?fileName=output-with-address.txt");
		
	}

}
