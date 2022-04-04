package com.liferay.training.internal.search.spi.model.contributor;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.liferay.training.model.PersistedInvoice;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
		 immediate = true,
		 property = "indexer.class.name=com.liferay.training.model.PersistedInvoice",
		 service = ModelDocumentContributor.class
		)
public class InvoiceModelDocumentContributor implements ModelDocumentContributor<PersistedInvoice>{

	@Override
	public void contribute(Document document, PersistedInvoice baseModel) {
		//Strip HTML
		String cardName = HtmlUtil.extractText(baseModel.getCardName());

		document.addText("cardName", cardName);
		String cardCode = HtmlUtil.extractText(baseModel.getCardCode());

		document.addText("cardCode", cardCode);
		
		document.addDate(Field.MODIFIED_DATE, baseModel.getModifiedDate());
		
		String documentNumber = baseModel.getDocumentNumber();

		document.addNumber("documentNumber", documentNumber);
		document.addNumber("invoiceTotal", baseModel.getInvoiceTotal());
		document.addNumber("commerceAccountId", baseModel.getCommerceAccountId());
		//handle localized fields
		for (Locale locale : LanguageUtil.getAvailableLocales(baseModel.getGroupId())) {
			String languageId = LocaleUtil.toLanguageId(locale);
			document.addText(LocalizationUtil.getLocalizedName("cardName", languageId), cardName);
			document.addText(LocalizationUtil.getLocalizedName("cardCode", languageId), cardCode);
			document.addText(LocalizationUtil.getLocalizedName("documentNumber", languageId), documentNumber);
			document.addNumber(LocalizationUtil.getLocalizedName("invoiceTotal", languageId), baseModel.getInvoiceTotal());

		}
		
	}

}
