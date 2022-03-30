package com.liferay.training.headless.internal.odata.entity.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.DoubleEntityField;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InvoiceEntityModel implements EntityModel {
	public InvoiceEntityModel() {
		_entityFieldsMap = Stream.of(
				// we'll support filtering based upon gst number
				new DoubleEntityField("gst", locale -> Field.getSortableFieldName("gst")),

				// sorting/filtering on card name is okay too
				new StringEntityField(
						"cardName", locale -> Field.getSortableFieldName("cardName")),
				// and the card code
				new StringEntityField(
						"cardCode", locale -> Field.getSortableFieldName("cardCode"))
		).collect(
				Collectors.toMap(EntityField::getName, Function.identity())
		);
	}

	@Override
	public Map<String, EntityField> getEntityFieldsMap() {
		return _entityFieldsMap;
	}
	private final Map<String, EntityField> _entityFieldsMap;

}
