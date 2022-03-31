package com.liferay.training.service.util.validator;


import com.liferay.commerce.exception.CommerceOrderValidatorException;
import com.liferay.training.service.validator.CustomInvoiceValidator;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = CustomInvoiceValidator.class)
public class CustomInvoiceValidatorImpl implements CustomInvoiceValidator {

	@Override
	public void validateFreightAmount(Double value) throws CommerceOrderValidatorException {
		if (value < 0) {
			throw new CommerceOrderValidatorException("Freight amount must not be negative");
		}
	}

}
