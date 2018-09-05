package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import lombok.Getter;
import lombok.Setter;

@CsvRecord(separator = ",", skipFirstLine = true, generateHeaderColumns = true)
@Getter
@Setter
public class Address {
	@DataField(pos = 4)
	private String addressLine;
	@DataField(pos = 5)
	private String city;
	@DataField(pos = 6)
	private String state;
	@DataField(pos = 7)
	private String country;
	@Override
	public String toString() {
		return "Address [addressLine=" + addressLine + ", city=" + city + ", state=" + state + ", country=" + country
				+ "]";
	}
}
