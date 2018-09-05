package com.learncamel.route.csv.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.Student;
import com.learncamel.route.csv.CsvMarshalRoute;

public class CsvMarshalRouteTest extends CamelTestSupport {
	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new CsvMarshalRoute();
	}

	@Test
	public void csvMarshalRoute() {
		Student student = new Student();
		List<Student> listStudents = new ArrayList<Student>();
		student.setId("12345");
		student.setFirstName("kumaresan");
		student.setLastName("balakrishnan");
		listStudents.add(student);
		
		Student student1 = new Student();
		student1.setId("36453");
		student1.setFirstName("ram");
		student1.setLastName("kumar");
		listStudents.add(student1);
		template.sendBody("direct:objInput", listStudents);
		File fileOutput=new File("data/csv/output");
		assertTrue(fileOutput.isDirectory());
	}
}
