package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.Link;

import lombok.Getter;
import lombok.Setter;

@CsvRecord(separator = ",", skipFirstLine = true,generateHeaderColumns=true)
@Getter
@Setter
public class StudentWithAddress {
	@DataField(pos = 1)
	private String id;
	@DataField(pos = 2)
	private String firstName;
	@DataField(pos = 3)
	private String lastName;
	@Link
	Address address;
	@Override
	public String toString() {
		return "StudentWithAddress [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + "]";
	}
}
