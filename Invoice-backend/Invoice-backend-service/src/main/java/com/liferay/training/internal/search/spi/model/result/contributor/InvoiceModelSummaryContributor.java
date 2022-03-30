package com.liferay.training.internal.search.spi.model.result.contributor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = "indexer.class.name=com.liferay.training.model.PersistedInvoice", service = ModelSummaryContributor.class)
public class InvoiceModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {

		return _createSummary(document,
				LocalizationUtil.getLocalizedName("cardName", LocaleUtil.toLanguageId(locale)),
				LocalizationUtil.getLocalizedName("cardCode", LocaleUtil.toLanguageId(locale)));
	}

	private Summary _createSummary(Document document, String cardName, String cardCode) {
		String prefix = Field.SNIPPET + StringPool.UNDERLINE;
		Summary summary = new Summary(document.get(prefix + cardCode, cardCode),
				document.get(prefix + cardName, cardName));
		summary.setMaxContentLength(200);
		return summary;
	}
}
