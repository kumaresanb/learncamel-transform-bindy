package com.learncamel.route.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

import com.learncamel.domain.Student;

public class CsvUnmarshalRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:data/csv/input?fileName=file.txt&noop=true")
		.unmarshal(new BindyCsvDataFormat(Student.class))
		.log("Unmarshal message body is ${body}")
		.to("direct:output");
	}

}
