package com.learncamel.route.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

import com.learncamel.domain.Student;


public class CsvMarshalRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:objInput")
		.log("Recived Message is: ${body}")
		.marshal(new BindyCsvDataFormat(Student.class))
		.log("Marshaled message is:${body}")
		.to("file:data/csv/output?fileName=output.txt");
	}

}
