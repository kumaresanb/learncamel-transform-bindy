package com.learncamel.route.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

import com.learncamel.domain.StudentWithAddress;

public class CsvUnmarshalWithLinkRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:data/csv/input?fileName=file-with-address.txt&noop=true")
		.unmarshal(new BindyCsvDataFormat(StudentWithAddress.class))
		.log("Unmarshal message received is: ${body}")
		.to("direct:output");
	}

}
