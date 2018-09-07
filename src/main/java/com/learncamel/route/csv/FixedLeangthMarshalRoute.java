package com.learncamel.route.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;

import com.learncamel.domain.EmployeeWithFixedLeangth;

public class FixedLeangthMarshalRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:fixedLengthObjInput")
		.log("Recived Message is: ${body}")
		.marshal(new BindyFixedLengthDataFormat(EmployeeWithFixedLeangth.class))
		.log("Marshaled message is:${body}")
		.to("file:data/fixedlength/output?fileName=fixedlengthoutput.txt");
		
	}

}
