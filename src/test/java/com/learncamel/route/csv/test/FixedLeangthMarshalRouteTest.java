package com.learncamel.route.csv.test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.EmployeeWithFixedLeangth;
import com.learncamel.route.csv.FixedLeangthMarshalRoute;

public class FixedLeangthMarshalRouteTest extends CamelTestSupport {
	
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new FixedLeangthMarshalRoute();
	}
	
	@Test
	public void fixedLengthMarshalTest() {
		List<EmployeeWithFixedLeangth> emFixedLeangths=new ArrayList<EmployeeWithFixedLeangth>();
		
		EmployeeWithFixedLeangth employeeWithFixedLeangth=new EmployeeWithFixedLeangth();
		employeeWithFixedLeangth.setId(3424);
		employeeWithFixedLeangth.setName("ravi");
		employeeWithFixedLeangth.setRole("fresher");
		employeeWithFixedLeangth.setJoiningDate(LocalDate.now());
		employeeWithFixedLeangth.setSalary(new BigDecimal("1000.00"));
		
		emFixedLeangths.add(employeeWithFixedLeangth);
		
		EmployeeWithFixedLeangth employeeWithFixedLeangth1=new EmployeeWithFixedLeangth();
		employeeWithFixedLeangth1.setId(2233);
		employeeWithFixedLeangth1.setName("ramu");
		employeeWithFixedLeangth1.setRole("manager");
		employeeWithFixedLeangth1.setJoiningDate(LocalDate.now());
		employeeWithFixedLeangth1.setSalary(new BigDecimal("2000.00"));
		
		emFixedLeangths.add(employeeWithFixedLeangth1);
		
		template.sendBody("direct:fixedLengthObjInput",emFixedLeangths);
		File fileOutput=new File("data/fixedlength/output");
		assertTrue(fileOutput.isDirectory());		
	}
	

}
