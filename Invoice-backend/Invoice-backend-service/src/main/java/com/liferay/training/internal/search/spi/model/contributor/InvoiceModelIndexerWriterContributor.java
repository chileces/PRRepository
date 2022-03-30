package com.liferay.training.internal.search.spi.model.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.liferay.training.model.PersistedInvoice;
import com.liferay.training.service.PersistedInvoiceLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = "indexer.class.name=com.liferay.training.model.PersistedInvoice", service = ModelIndexerWriterContributor.class)
public class InvoiceModelIndexerWriterContributor implements ModelIndexerWriterContributor<PersistedInvoice> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod((PersistedInvoice persistedInvoice) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(persistedInvoice);
			batchIndexingActionable.addDocuments(document);
		});

	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory
				.getBatchIndexingActionable(persistedInvoiceLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(PersistedInvoice baseModel) {
		return baseModel.getCompanyId();
	}

	@Reference
	protected PersistedInvoiceLocalService persistedInvoiceLocalService;

	@Reference
	protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

}
