package com.learncamel.domain;

import java.time.LocalDate;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

import lombok.Getter;
import lombok.Setter;

@FixedLengthRecord(ignoreTrailingChars = true)
@Setter
@Getter
public class EmployeeWithFixedLeangth {
	@DataField(pos = 1, length = 4)
	private int id;
	@DataField(pos = 2, length = 10, trim = true, align = "L")
	private String name;
	@DataField(pos = 3, length = 8, trim = true, align = "L")
	private String role;
	@DataField(pos = 4, length = 9, pattern = "ddMMMyyyy")
	private LocalDate joiningDate;
	@DataField(pos = 5, delimiter = "^")
	private int age;

	@Override
	public String toString() {
		return "EmployeeWithFixedLeangth [id=" + id + ", name=" + name + ", role=" + role + ", joiningDate="
				+ joiningDate + ", age=" + age + "]";
	}

}
