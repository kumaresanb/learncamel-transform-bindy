package com.learncamel.route.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;

import com.learncamel.domain.EmployeeWithFixedLeangth;

public class FixedLeangthUnMarshalRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:data/fixedlength/input?fileName=fixedlength.txt&noop=true")
		.unmarshal(new BindyFixedLengthDataFormat(EmployeeWithFixedLeangth.class))
		.log("Unmarshal message body is ${body}")
		.to("direct:output");
	}

}
