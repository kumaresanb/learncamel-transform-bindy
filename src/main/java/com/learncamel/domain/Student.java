package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import lombok.Getter;
import lombok.Setter;

@CsvRecord(separator = ":", skipFirstLine = true)
@Getter
@Setter
public class Student {
	@DataField(pos = 1)
	private String id;
	@DataField(pos = 2)
	private String firstName;
	@DataField(pos = 3)
	private String lastName;
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
