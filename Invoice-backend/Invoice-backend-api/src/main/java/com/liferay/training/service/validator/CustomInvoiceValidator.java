package com.liferay.training.service.validator;

import com.liferay.commerce.exception.CommerceOrderValidatorException;

public interface CustomInvoiceValidator {
	public void validateFreightAmount(Double value) throws CommerceOrderValidatorException;	
}
