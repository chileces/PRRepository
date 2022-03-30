package com.liferay.training.headless.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author ces-user
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/headless-invoice",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=HeadlessInvoice"
	},
	service = Application.class
)
@Generated("")
public class HeadlessInvoiceApplication extends Application {
}