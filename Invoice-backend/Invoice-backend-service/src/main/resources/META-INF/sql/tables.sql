create table CustomInvoice_CustomInvoice (
	customInvoiceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	gst DOUBLE,
	cardCode VARCHAR(75) null,
	cardName VARCHAR(75) null,
	carrier VARCHAR(75) null,
	documentDate DATE null,
	documentNumber VARCHAR(75) null,
	documentStatus VARCHAR(75) null,
	dueDate DATE null,
	freightAmount DOUBLE,
	invoiceTotal DOUBLE
);

create table CustomInvoice_CustomInvoiceLine (
	customInvoiceLineId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customInvoiceId LONG,
	price DOUBLE,
	quantity LONG,
	discountPercent DOUBLE,
	itemCode VARCHAR(75) null,
	lineNum LONG,
	lineTotal DOUBLE,
	salesOrder LONG,
	salesOrderlineNum LONG
);

create table CustomInvoice_PersistedInvoice (
	persistedInvoiceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	gst DOUBLE,
	cardCode VARCHAR(75) null,
	cardName VARCHAR(75) null,
	carrier VARCHAR(75) null,
	documentDate DATE null,
	documentNumber VARCHAR(75) null,
	documentStatus VARCHAR(75) null,
	dueDate DATE null,
	freightAmount DOUBLE,
	invoiceTotal DOUBLE
);

create table CustomInvoice_PersistedInvoiceLine (
	persistedInvoiceLineId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	persistedInvoiceId LONG,
	price DOUBLE,
	quantity INTEGER,
	discountPercent DOUBLE,
	itemCode VARCHAR(75) null,
	lineNum INTEGER,
	lineTotal DOUBLE,
	salesOrder LONG,
	salesOrderlineNum INTEGER
);