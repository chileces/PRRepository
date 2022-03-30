/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.training.exception.NoSuchPersistedInvoiceException;
import com.liferay.training.model.PersistedInvoice;
import com.liferay.training.model.impl.PersistedInvoiceImpl;
import com.liferay.training.model.impl.PersistedInvoiceModelImpl;
import com.liferay.training.service.persistence.PersistedInvoicePersistence;
import com.liferay.training.service.persistence.PersistedInvoiceUtil;
import com.liferay.training.service.persistence.impl.constants.CustomInvoicePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the persisted invoice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PersistedInvoicePersistence.class)
public class PersistedInvoicePersistenceImpl
	extends BasePersistenceImpl<PersistedInvoice>
	implements PersistedInvoicePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersistedInvoiceUtil</code> to access the persisted invoice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersistedInvoiceImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PersistedInvoicePersistenceImpl() {
		setModelClass(PersistedInvoice.class);

		setModelImplClass(PersistedInvoiceImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the persisted invoice in the entity cache if it is enabled.
	 *
	 * @param persistedInvoice the persisted invoice
	 */
	@Override
	public void cacheResult(PersistedInvoice persistedInvoice) {
		entityCache.putResult(
			PersistedInvoiceImpl.class, persistedInvoice.getPrimaryKey(),
			persistedInvoice);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the persisted invoices in the entity cache if it is enabled.
	 *
	 * @param persistedInvoices the persisted invoices
	 */
	@Override
	public void cacheResult(List<PersistedInvoice> persistedInvoices) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (persistedInvoices.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PersistedInvoice persistedInvoice : persistedInvoices) {
			if (entityCache.getResult(
					PersistedInvoiceImpl.class,
					persistedInvoice.getPrimaryKey()) == null) {

				cacheResult(persistedInvoice);
			}
		}
	}

	/**
	 * Clears the cache for all persisted invoices.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersistedInvoiceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the persisted invoice.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersistedInvoice persistedInvoice) {
		entityCache.removeResult(PersistedInvoiceImpl.class, persistedInvoice);
	}

	@Override
	public void clearCache(List<PersistedInvoice> persistedInvoices) {
		for (PersistedInvoice persistedInvoice : persistedInvoices) {
			entityCache.removeResult(
				PersistedInvoiceImpl.class, persistedInvoice);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PersistedInvoiceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new persisted invoice with the primary key. Does not add the persisted invoice to the database.
	 *
	 * @param persistedInvoiceId the primary key for the new persisted invoice
	 * @return the new persisted invoice
	 */
	@Override
	public PersistedInvoice create(long persistedInvoiceId) {
		PersistedInvoice persistedInvoice = new PersistedInvoiceImpl();

		persistedInvoice.setNew(true);
		persistedInvoice.setPrimaryKey(persistedInvoiceId);

		persistedInvoice.setCompanyId(CompanyThreadLocal.getCompanyId());

		return persistedInvoice;
	}

	/**
	 * Removes the persisted invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedInvoiceId the primary key of the persisted invoice
	 * @return the persisted invoice that was removed
	 * @throws NoSuchPersistedInvoiceException if a persisted invoice with the primary key could not be found
	 */
	@Override
	public PersistedInvoice remove(long persistedInvoiceId)
		throws NoSuchPersistedInvoiceException {

		return remove((Serializable)persistedInvoiceId);
	}

	/**
	 * Removes the persisted invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persisted invoice
	 * @return the persisted invoice that was removed
	 * @throws NoSuchPersistedInvoiceException if a persisted invoice with the primary key could not be found
	 */
	@Override
	public PersistedInvoice remove(Serializable primaryKey)
		throws NoSuchPersistedInvoiceException {

		Session session = null;

		try {
			session = openSession();

			PersistedInvoice persistedInvoice = (PersistedInvoice)session.get(
				PersistedInvoiceImpl.class, primaryKey);

			if (persistedInvoice == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersistedInvoiceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(persistedInvoice);
		}
		catch (NoSuchPersistedInvoiceException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PersistedInvoice removeImpl(PersistedInvoice persistedInvoice) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(persistedInvoice)) {
				persistedInvoice = (PersistedInvoice)session.get(
					PersistedInvoiceImpl.class,
					persistedInvoice.getPrimaryKeyObj());
			}

			if (persistedInvoice != null) {
				session.delete(persistedInvoice);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (persistedInvoice != null) {
			clearCache(persistedInvoice);
		}

		return persistedInvoice;
	}

	@Override
	public PersistedInvoice updateImpl(PersistedInvoice persistedInvoice) {
		boolean isNew = persistedInvoice.isNew();

		if (!(persistedInvoice instanceof PersistedInvoiceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(persistedInvoice.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					persistedInvoice);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in persistedInvoice proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PersistedInvoice implementation " +
					persistedInvoice.getClass());
		}

		PersistedInvoiceModelImpl persistedInvoiceModelImpl =
			(PersistedInvoiceModelImpl)persistedInvoice;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (persistedInvoice.getCreateDate() == null)) {
			if (serviceContext == null) {
				persistedInvoice.setCreateDate(date);
			}
			else {
				persistedInvoice.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!persistedInvoiceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				persistedInvoice.setModifiedDate(date);
			}
			else {
				persistedInvoice.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(persistedInvoice);
			}
			else {
				persistedInvoice = (PersistedInvoice)session.merge(
					persistedInvoice);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PersistedInvoiceImpl.class, persistedInvoice, false, true);

		if (isNew) {
			persistedInvoice.setNew(false);
		}

		persistedInvoice.resetOriginalValues();

		return persistedInvoice;
	}

	/**
	 * Returns the persisted invoice with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persisted invoice
	 * @return the persisted invoice
	 * @throws NoSuchPersistedInvoiceException if a persisted invoice with the primary key could not be found
	 */
	@Override
	public PersistedInvoice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersistedInvoiceException {

		PersistedInvoice persistedInvoice = fetchByPrimaryKey(primaryKey);

		if (persistedInvoice == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersistedInvoiceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return persistedInvoice;
	}

	/**
	 * Returns the persisted invoice with the primary key or throws a <code>NoSuchPersistedInvoiceException</code> if it could not be found.
	 *
	 * @param persistedInvoiceId the primary key of the persisted invoice
	 * @return the persisted invoice
	 * @throws NoSuchPersistedInvoiceException if a persisted invoice with the primary key could not be found
	 */
	@Override
	public PersistedInvoice findByPrimaryKey(long persistedInvoiceId)
		throws NoSuchPersistedInvoiceException {

		return findByPrimaryKey((Serializable)persistedInvoiceId);
	}

	/**
	 * Returns the persisted invoice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param persistedInvoiceId the primary key of the persisted invoice
	 * @return the persisted invoice, or <code>null</code> if a persisted invoice with the primary key could not be found
	 */
	@Override
	public PersistedInvoice fetchByPrimaryKey(long persistedInvoiceId) {
		return fetchByPrimaryKey((Serializable)persistedInvoiceId);
	}

	/**
	 * Returns all the persisted invoices.
	 *
	 * @return the persisted invoices
	 */
	@Override
	public List<PersistedInvoice> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoices
	 * @param end the upper bound of the range of persisted invoices (not inclusive)
	 * @return the range of persisted invoices
	 */
	@Override
	public List<PersistedInvoice> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoices
	 * @param end the upper bound of the range of persisted invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted invoices
	 */
	@Override
	public List<PersistedInvoice> findAll(
		int start, int end,
		OrderByComparator<PersistedInvoice> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoices
	 * @param end the upper bound of the range of persisted invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted invoices
	 */
	@Override
	public List<PersistedInvoice> findAll(
		int start, int end,
		OrderByComparator<PersistedInvoice> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PersistedInvoice> list = null;

		if (useFinderCache) {
			list = (List<PersistedInvoice>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERSISTEDINVOICE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERSISTEDINVOICE;

				sql = sql.concat(PersistedInvoiceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PersistedInvoice>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the persisted invoices from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersistedInvoice persistedInvoice : findAll()) {
			remove(persistedInvoice);
		}
	}

	/**
	 * Returns the number of persisted invoices.
	 *
	 * @return the number of persisted invoices
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PERSISTEDINVOICE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "persistedInvoiceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSISTEDINVOICE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersistedInvoiceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the persisted invoice persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PersistedInvoiceModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PersistedInvoice.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setPersistedInvoiceUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPersistedInvoiceUtilPersistence(null);

		entityCache.removeCache(PersistedInvoiceImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPersistedInvoiceUtilPersistence(
		PersistedInvoicePersistence persistedInvoicePersistence) {

		try {
			Field field = PersistedInvoiceUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, persistedInvoicePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = CustomInvoicePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CustomInvoicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CustomInvoicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PERSISTEDINVOICE =
		"SELECT persistedInvoice FROM PersistedInvoice persistedInvoice";

	private static final String _SQL_COUNT_PERSISTEDINVOICE =
		"SELECT COUNT(persistedInvoice) FROM PersistedInvoice persistedInvoice";

	private static final String _ORDER_BY_ENTITY_ALIAS = "persistedInvoice.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PersistedInvoice exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PersistedInvoicePersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class PersistedInvoiceModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			PersistedInvoiceModelImpl persistedInvoiceModelImpl =
				(PersistedInvoiceModelImpl)baseModel;

			long columnBitmask = persistedInvoiceModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					persistedInvoiceModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						persistedInvoiceModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(PersistedInvoicePersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					persistedInvoiceModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PersistedInvoiceModelImpl persistedInvoiceModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						persistedInvoiceModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = persistedInvoiceModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= PersistedInvoiceModelImpl.getColumnBitmask(
				"createDate");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}