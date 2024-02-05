package com.annotation;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateDOB implements ConstraintValidator<DOBValidation, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.isEmpty()) {
			return false;// Not Allow empty values
		}

		try {
			LocalDate dob = LocalDate.parse(value);
			LocalDate now = LocalDate.now();

			int age = now.getYear() - dob.getYear();

			// Perform age validation
			return age >= 18 && age <= 60;
		} catch (DateTimeParseException e) {
			return false; // Invalid date format
		}
	}
}
