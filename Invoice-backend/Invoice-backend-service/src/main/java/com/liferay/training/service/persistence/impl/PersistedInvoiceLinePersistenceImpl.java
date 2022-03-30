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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.training.exception.NoSuchPersistedInvoiceLineException;
import com.liferay.training.model.PersistedInvoiceLine;
import com.liferay.training.model.impl.PersistedInvoiceLineImpl;
import com.liferay.training.model.impl.PersistedInvoiceLineModelImpl;
import com.liferay.training.service.persistence.PersistedInvoiceLinePersistence;
import com.liferay.training.service.persistence.PersistedInvoiceLineUtil;
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
 * The persistence implementation for the persisted invoice line service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PersistedInvoiceLinePersistence.class)
public class PersistedInvoiceLinePersistenceImpl
	extends BasePersistenceImpl<PersistedInvoiceLine>
	implements PersistedInvoiceLinePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersistedInvoiceLineUtil</code> to access the persisted invoice line persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersistedInvoiceLineImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCustomInvoiceId;
	private FinderPath _finderPathWithoutPaginationFindByCustomInvoiceId;
	private FinderPath _finderPathCountByCustomInvoiceId;

	/**
	 * Returns all the persisted invoice lines where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @return the matching persisted invoice lines
	 */
	@Override
	public List<PersistedInvoiceLine> findByCustomInvoiceId(
		long persistedInvoiceId) {

		return findByCustomInvoiceId(
			persistedInvoiceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted invoice lines where persistedInvoiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param start the lower bound of the range of persisted invoice lines
	 * @param end the upper bound of the range of persisted invoice lines (not inclusive)
	 * @return the range of matching persisted invoice lines
	 */
	@Override
	public List<PersistedInvoiceLine> findByCustomInvoiceId(
		long persistedInvoiceId, int start, int end) {

		return findByCustomInvoiceId(persistedInvoiceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted invoice lines where persistedInvoiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param start the lower bound of the range of persisted invoice lines
	 * @param end the upper bound of the range of persisted invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted invoice lines
	 */
	@Override
	public List<PersistedInvoiceLine> findByCustomInvoiceId(
		long persistedInvoiceId, int start, int end,
		OrderByComparator<PersistedInvoiceLine> orderByComparator) {

		return findByCustomInvoiceId(
			persistedInvoiceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted invoice lines where persistedInvoiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param start the lower bound of the range of persisted invoice lines
	 * @param end the upper bound of the range of persisted invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted invoice lines
	 */
	@Override
	public List<PersistedInvoiceLine> findByCustomInvoiceId(
		long persistedInvoiceId, int start, int end,
		OrderByComparator<PersistedInvoiceLine> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCustomInvoiceId;
				finderArgs = new Object[] {persistedInvoiceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCustomInvoiceId;
			finderArgs = new Object[] {
				persistedInvoiceId, start, end, orderByComparator
			};
		}

		List<PersistedInvoiceLine> list = null;

		if (useFinderCache) {
			list = (List<PersistedInvoiceLine>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedInvoiceLine persistedInvoiceLine : list) {
					if (persistedInvoiceId !=
							persistedInvoiceLine.getPersistedInvoiceId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PERSISTEDINVOICELINE_WHERE);

			sb.append(_FINDER_COLUMN_CUSTOMINVOICEID_PERSISTEDINVOICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersistedInvoiceLineModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(persistedInvoiceId);

				list = (List<PersistedInvoiceLine>)QueryUtil.list(
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
	 * Returns the first persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a matching persisted invoice line could not be found
	 */
	@Override
	public PersistedInvoiceLine findByCustomInvoiceId_First(
			long persistedInvoiceId,
			OrderByComparator<PersistedInvoiceLine> orderByComparator)
		throws NoSuchPersistedInvoiceLineException {

		PersistedInvoiceLine persistedInvoiceLine =
			fetchByCustomInvoiceId_First(persistedInvoiceId, orderByComparator);

		if (persistedInvoiceLine != null) {
			return persistedInvoiceLine;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("persistedInvoiceId=");
		sb.append(persistedInvoiceId);

		sb.append("}");

		throw new NoSuchPersistedInvoiceLineException(sb.toString());
	}

	/**
	 * Returns the first persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted invoice line, or <code>null</code> if a matching persisted invoice line could not be found
	 */
	@Override
	public PersistedInvoiceLine fetchByCustomInvoiceId_First(
		long persistedInvoiceId,
		OrderByComparator<PersistedInvoiceLine> orderByComparator) {

		List<PersistedInvoiceLine> list = findByCustomInvoiceId(
			persistedInvoiceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a matching persisted invoice line could not be found
	 */
	@Override
	public PersistedInvoiceLine findByCustomInvoiceId_Last(
			long persistedInvoiceId,
			OrderByComparator<PersistedInvoiceLine> orderByComparator)
		throws NoSuchPersistedInvoiceLineException {

		PersistedInvoiceLine persistedInvoiceLine = fetchByCustomInvoiceId_Last(
			persistedInvoiceId, orderByComparator);

		if (persistedInvoiceLine != null) {
			return persistedInvoiceLine;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("persistedInvoiceId=");
		sb.append(persistedInvoiceId);

		sb.append("}");

		throw new NoSuchPersistedInvoiceLineException(sb.toString());
	}

	/**
	 * Returns the last persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted invoice line, or <code>null</code> if a matching persisted invoice line could not be found
	 */
	@Override
	public PersistedInvoiceLine fetchByCustomInvoiceId_Last(
		long persistedInvoiceId,
		OrderByComparator<PersistedInvoiceLine> orderByComparator) {

		int count = countByCustomInvoiceId(persistedInvoiceId);

		if (count == 0) {
			return null;
		}

		List<PersistedInvoiceLine> list = findByCustomInvoiceId(
			persistedInvoiceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persisted invoice lines before and after the current persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceLineId the primary key of the current persisted invoice line
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a persisted invoice line with the primary key could not be found
	 */
	@Override
	public PersistedInvoiceLine[] findByCustomInvoiceId_PrevAndNext(
			long persistedInvoiceLineId, long persistedInvoiceId,
			OrderByComparator<PersistedInvoiceLine> orderByComparator)
		throws NoSuchPersistedInvoiceLineException {

		PersistedInvoiceLine persistedInvoiceLine = findByPrimaryKey(
			persistedInvoiceLineId);

		Session session = null;

		try {
			session = openSession();

			PersistedInvoiceLine[] array = new PersistedInvoiceLineImpl[3];

			array[0] = getByCustomInvoiceId_PrevAndNext(
				session, persistedInvoiceLine, persistedInvoiceId,
				orderByComparator, true);

			array[1] = persistedInvoiceLine;

			array[2] = getByCustomInvoiceId_PrevAndNext(
				session, persistedInvoiceLine, persistedInvoiceId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedInvoiceLine getByCustomInvoiceId_PrevAndNext(
		Session session, PersistedInvoiceLine persistedInvoiceLine,
		long persistedInvoiceId,
		OrderByComparator<PersistedInvoiceLine> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PERSISTEDINVOICELINE_WHERE);

		sb.append(_FINDER_COLUMN_CUSTOMINVOICEID_PERSISTEDINVOICEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PersistedInvoiceLineModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(persistedInvoiceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedInvoiceLine)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersistedInvoiceLine> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted invoice lines where persistedInvoiceId = &#63; from the database.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 */
	@Override
	public void removeByCustomInvoiceId(long persistedInvoiceId) {
		for (PersistedInvoiceLine persistedInvoiceLine :
				findByCustomInvoiceId(
					persistedInvoiceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(persistedInvoiceLine);
		}
	}

	/**
	 * Returns the number of persisted invoice lines where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @return the number of matching persisted invoice lines
	 */
	@Override
	public int countByCustomInvoiceId(long persistedInvoiceId) {
		FinderPath finderPath = _finderPathCountByCustomInvoiceId;

		Object[] finderArgs = new Object[] {persistedInvoiceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERSISTEDINVOICELINE_WHERE);

			sb.append(_FINDER_COLUMN_CUSTOMINVOICEID_PERSISTEDINVOICEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(persistedInvoiceId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String
		_FINDER_COLUMN_CUSTOMINVOICEID_PERSISTEDINVOICEID_2 =
			"persistedInvoiceLine.persistedInvoiceId = ?";

	public PersistedInvoiceLinePersistenceImpl() {
		setModelClass(PersistedInvoiceLine.class);

		setModelImplClass(PersistedInvoiceLineImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the persisted invoice line in the entity cache if it is enabled.
	 *
	 * @param persistedInvoiceLine the persisted invoice line
	 */
	@Override
	public void cacheResult(PersistedInvoiceLine persistedInvoiceLine) {
		entityCache.putResult(
			PersistedInvoiceLineImpl.class,
			persistedInvoiceLine.getPrimaryKey(), persistedInvoiceLine);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the persisted invoice lines in the entity cache if it is enabled.
	 *
	 * @param persistedInvoiceLines the persisted invoice lines
	 */
	@Override
	public void cacheResult(List<PersistedInvoiceLine> persistedInvoiceLines) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (persistedInvoiceLines.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PersistedInvoiceLine persistedInvoiceLine :
				persistedInvoiceLines) {

			if (entityCache.getResult(
					PersistedInvoiceLineImpl.class,
					persistedInvoiceLine.getPrimaryKey()) == null) {

				cacheResult(persistedInvoiceLine);
			}
		}
	}

	/**
	 * Clears the cache for all persisted invoice lines.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersistedInvoiceLineImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the persisted invoice line.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersistedInvoiceLine persistedInvoiceLine) {
		entityCache.removeResult(
			PersistedInvoiceLineImpl.class, persistedInvoiceLine);
	}

	@Override
	public void clearCache(List<PersistedInvoiceLine> persistedInvoiceLines) {
		for (PersistedInvoiceLine persistedInvoiceLine :
				persistedInvoiceLines) {

			entityCache.removeResult(
				PersistedInvoiceLineImpl.class, persistedInvoiceLine);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				PersistedInvoiceLineImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new persisted invoice line with the primary key. Does not add the persisted invoice line to the database.
	 *
	 * @param persistedInvoiceLineId the primary key for the new persisted invoice line
	 * @return the new persisted invoice line
	 */
	@Override
	public PersistedInvoiceLine create(long persistedInvoiceLineId) {
		PersistedInvoiceLine persistedInvoiceLine =
			new PersistedInvoiceLineImpl();

		persistedInvoiceLine.setNew(true);
		persistedInvoiceLine.setPrimaryKey(persistedInvoiceLineId);

		persistedInvoiceLine.setCompanyId(CompanyThreadLocal.getCompanyId());

		return persistedInvoiceLine;
	}

	/**
	 * Removes the persisted invoice line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedInvoiceLineId the primary key of the persisted invoice line
	 * @return the persisted invoice line that was removed
	 * @throws NoSuchPersistedInvoiceLineException if a persisted invoice line with the primary key could not be found
	 */
	@Override
	public PersistedInvoiceLine remove(long persistedInvoiceLineId)
		throws NoSuchPersistedInvoiceLineException {

		return remove((Serializable)persistedInvoiceLineId);
	}

	/**
	 * Removes the persisted invoice line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persisted invoice line
	 * @return the persisted invoice line that was removed
	 * @throws NoSuchPersistedInvoiceLineException if a persisted invoice line with the primary key could not be found
	 */
	@Override
	public PersistedInvoiceLine remove(Serializable primaryKey)
		throws NoSuchPersistedInvoiceLineException {

		Session session = null;

		try {
			session = openSession();

			PersistedInvoiceLine persistedInvoiceLine =
				(PersistedInvoiceLine)session.get(
					PersistedInvoiceLineImpl.class, primaryKey);

			if (persistedInvoiceLine == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersistedInvoiceLineException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(persistedInvoiceLine);
		}
		catch (NoSuchPersistedInvoiceLineException noSuchEntityException) {
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
	protected PersistedInvoiceLine removeImpl(
		PersistedInvoiceLine persistedInvoiceLine) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(persistedInvoiceLine)) {
				persistedInvoiceLine = (PersistedInvoiceLine)session.get(
					PersistedInvoiceLineImpl.class,
					persistedInvoiceLine.getPrimaryKeyObj());
			}

			if (persistedInvoiceLine != null) {
				session.delete(persistedInvoiceLine);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (persistedInvoiceLine != null) {
			clearCache(persistedInvoiceLine);
		}

		return persistedInvoiceLine;
	}

	@Override
	public PersistedInvoiceLine updateImpl(
		PersistedInvoiceLine persistedInvoiceLine) {

		boolean isNew = persistedInvoiceLine.isNew();

		if (!(persistedInvoiceLine instanceof PersistedInvoiceLineModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(persistedInvoiceLine.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					persistedInvoiceLine);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in persistedInvoiceLine proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PersistedInvoiceLine implementation " +
					persistedInvoiceLine.getClass());
		}

		PersistedInvoiceLineModelImpl persistedInvoiceLineModelImpl =
			(PersistedInvoiceLineModelImpl)persistedInvoiceLine;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (persistedInvoiceLine.getCreateDate() == null)) {
			if (serviceContext == null) {
				persistedInvoiceLine.setCreateDate(date);
			}
			else {
				persistedInvoiceLine.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!persistedInvoiceLineModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				persistedInvoiceLine.setModifiedDate(date);
			}
			else {
				persistedInvoiceLine.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(persistedInvoiceLine);
			}
			else {
				persistedInvoiceLine = (PersistedInvoiceLine)session.merge(
					persistedInvoiceLine);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PersistedInvoiceLineImpl.class, persistedInvoiceLineModelImpl,
			false, true);

		if (isNew) {
			persistedInvoiceLine.setNew(false);
		}

		persistedInvoiceLine.resetOriginalValues();

		return persistedInvoiceLine;
	}

	/**
	 * Returns the persisted invoice line with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persisted invoice line
	 * @return the persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a persisted invoice line with the primary key could not be found
	 */
	@Override
	public PersistedInvoiceLine findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersistedInvoiceLineException {

		PersistedInvoiceLine persistedInvoiceLine = fetchByPrimaryKey(
			primaryKey);

		if (persistedInvoiceLine == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersistedInvoiceLineException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return persistedInvoiceLine;
	}

	/**
	 * Returns the persisted invoice line with the primary key or throws a <code>NoSuchPersistedInvoiceLineException</code> if it could not be found.
	 *
	 * @param persistedInvoiceLineId the primary key of the persisted invoice line
	 * @return the persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a persisted invoice line with the primary key could not be found
	 */
	@Override
	public PersistedInvoiceLine findByPrimaryKey(long persistedInvoiceLineId)
		throws NoSuchPersistedInvoiceLineException {

		return findByPrimaryKey((Serializable)persistedInvoiceLineId);
	}

	/**
	 * Returns the persisted invoice line with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param persistedInvoiceLineId the primary key of the persisted invoice line
	 * @return the persisted invoice line, or <code>null</code> if a persisted invoice line with the primary key could not be found
	 */
	@Override
	public PersistedInvoiceLine fetchByPrimaryKey(long persistedInvoiceLineId) {
		return fetchByPrimaryKey((Serializable)persistedInvoiceLineId);
	}

	/**
	 * Returns all the persisted invoice lines.
	 *
	 * @return the persisted invoice lines
	 */
	@Override
	public List<PersistedInvoiceLine> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted invoice lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoice lines
	 * @param end the upper bound of the range of persisted invoice lines (not inclusive)
	 * @return the range of persisted invoice lines
	 */
	@Override
	public List<PersistedInvoiceLine> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted invoice lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoice lines
	 * @param end the upper bound of the range of persisted invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted invoice lines
	 */
	@Override
	public List<PersistedInvoiceLine> findAll(
		int start, int end,
		OrderByComparator<PersistedInvoiceLine> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted invoice lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoice lines
	 * @param end the upper bound of the range of persisted invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted invoice lines
	 */
	@Override
	public List<PersistedInvoiceLine> findAll(
		int start, int end,
		OrderByComparator<PersistedInvoiceLine> orderByComparator,
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

		List<PersistedInvoiceLine> list = null;

		if (useFinderCache) {
			list = (List<PersistedInvoiceLine>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERSISTEDINVOICELINE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERSISTEDINVOICELINE;

				sql = sql.concat(PersistedInvoiceLineModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PersistedInvoiceLine>)QueryUtil.list(
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
	 * Removes all the persisted invoice lines from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersistedInvoiceLine persistedInvoiceLine : findAll()) {
			remove(persistedInvoiceLine);
		}
	}

	/**
	 * Returns the number of persisted invoice lines.
	 *
	 * @return the number of persisted invoice lines
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_PERSISTEDINVOICELINE);

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
		return "persistedInvoiceLineId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSISTEDINVOICELINE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersistedInvoiceLineModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the persisted invoice line persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PersistedInvoiceLineModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PersistedInvoiceLine.class.getName()));

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

		_finderPathWithPaginationFindByCustomInvoiceId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCustomInvoiceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"persistedInvoiceId"}, true);

		_finderPathWithoutPaginationFindByCustomInvoiceId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCustomInvoiceId",
			new String[] {Long.class.getName()},
			new String[] {"persistedInvoiceId"}, true);

		_finderPathCountByCustomInvoiceId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCustomInvoiceId",
			new String[] {Long.class.getName()},
			new String[] {"persistedInvoiceId"}, false);

		_setPersistedInvoiceLineUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPersistedInvoiceLineUtilPersistence(null);

		entityCache.removeCache(PersistedInvoiceLineImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPersistedInvoiceLineUtilPersistence(
		PersistedInvoiceLinePersistence persistedInvoiceLinePersistence) {

		try {
			Field field = PersistedInvoiceLineUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, persistedInvoiceLinePersistence);
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

	private static final String _SQL_SELECT_PERSISTEDINVOICELINE =
		"SELECT persistedInvoiceLine FROM PersistedInvoiceLine persistedInvoiceLine";

	private static final String _SQL_SELECT_PERSISTEDINVOICELINE_WHERE =
		"SELECT persistedInvoiceLine FROM PersistedInvoiceLine persistedInvoiceLine WHERE ";

	private static final String _SQL_COUNT_PERSISTEDINVOICELINE =
		"SELECT COUNT(persistedInvoiceLine) FROM PersistedInvoiceLine persistedInvoiceLine";

	private static final String _SQL_COUNT_PERSISTEDINVOICELINE_WHERE =
		"SELECT COUNT(persistedInvoiceLine) FROM PersistedInvoiceLine persistedInvoiceLine WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"persistedInvoiceLine.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PersistedInvoiceLine exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PersistedInvoiceLine exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PersistedInvoiceLinePersistenceImpl.class);

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

	private static class PersistedInvoiceLineModelArgumentsResolver
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

			PersistedInvoiceLineModelImpl persistedInvoiceLineModelImpl =
				(PersistedInvoiceLineModelImpl)baseModel;

			long columnBitmask =
				persistedInvoiceLineModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					persistedInvoiceLineModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						persistedInvoiceLineModelImpl.getColumnBitmask(
							columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(PersistedInvoiceLinePersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					persistedInvoiceLineModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PersistedInvoiceLineModelImpl persistedInvoiceLineModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						persistedInvoiceLineModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = persistedInvoiceLineModelImpl.getColumnValue(
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

			orderByColumnsBitmask |=
				PersistedInvoiceLineModelImpl.getColumnBitmask("createDate");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}