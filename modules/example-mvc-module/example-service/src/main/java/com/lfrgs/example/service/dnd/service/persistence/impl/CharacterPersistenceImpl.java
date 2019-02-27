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

package com.lfrgs.example.service.dnd.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.lfrgs.example.service.dnd.exception.NoSuchCharacterException;
import com.lfrgs.example.service.dnd.model.Character;
import com.lfrgs.example.service.dnd.model.impl.CharacterImpl;
import com.lfrgs.example.service.dnd.model.impl.CharacterModelImpl;
import com.lfrgs.example.service.dnd.service.persistence.CharacterPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the character service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CharacterPersistence
 * @see com.lfrgs.example.service.dnd.service.persistence.CharacterUtil
 * @generated
 */
@ProviderType
public class CharacterPersistenceImpl extends BasePersistenceImpl<Character>
	implements CharacterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CharacterUtil} to access the character persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CharacterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterModelImpl.FINDER_CACHE_ENABLED, CharacterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterModelImpl.FINDER_CACHE_ENABLED, CharacterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYNAME = new FinderPath(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterModelImpl.FINDER_CACHE_ENABLED, CharacterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNAME =
		new FinderPath(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterModelImpl.FINDER_CACHE_ENABLED, CharacterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByName",
			new String[] { String.class.getName() },
			CharacterModelImpl.CHARACTERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYNAME = new FinderPath(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the characters where characterName = &#63;.
	 *
	 * @param characterName the character name
	 * @return the matching characters
	 */
	@Override
	public List<Character> findByByName(String characterName) {
		return findByByName(characterName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the characters where characterName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param characterName the character name
	 * @param start the lower bound of the range of characters
	 * @param end the upper bound of the range of characters (not inclusive)
	 * @return the range of matching characters
	 */
	@Override
	public List<Character> findByByName(String characterName, int start, int end) {
		return findByByName(characterName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the characters where characterName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param characterName the character name
	 * @param start the lower bound of the range of characters
	 * @param end the upper bound of the range of characters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching characters
	 */
	@Override
	public List<Character> findByByName(String characterName, int start,
		int end, OrderByComparator<Character> orderByComparator) {
		return findByByName(characterName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the characters where characterName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param characterName the character name
	 * @param start the lower bound of the range of characters
	 * @param end the upper bound of the range of characters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching characters
	 */
	@Override
	public List<Character> findByByName(String characterName, int start,
		int end, OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNAME;
			finderArgs = new Object[] { characterName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYNAME;
			finderArgs = new Object[] {
					characterName,
					
					start, end, orderByComparator
				};
		}

		List<Character> list = null;

		if (retrieveFromCache) {
			list = (List<Character>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Character character : list) {
					if (!Objects.equals(characterName,
								character.getCharacterName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CHARACTER_WHERE);

			boolean bindCharacterName = false;

			if (characterName == null) {
				query.append(_FINDER_COLUMN_BYNAME_CHARACTERNAME_1);
			}
			else if (characterName.equals("")) {
				query.append(_FINDER_COLUMN_BYNAME_CHARACTERNAME_3);
			}
			else {
				bindCharacterName = true;

				query.append(_FINDER_COLUMN_BYNAME_CHARACTERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CharacterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCharacterName) {
					qPos.add(characterName);
				}

				if (!pagination) {
					list = (List<Character>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Character>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first character in the ordered set where characterName = &#63;.
	 *
	 * @param characterName the character name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching character
	 * @throws NoSuchCharacterException if a matching character could not be found
	 */
	@Override
	public Character findByByName_First(String characterName,
		OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException {
		Character character = fetchByByName_First(characterName,
				orderByComparator);

		if (character != null) {
			return character;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("characterName=");
		msg.append(characterName);

		msg.append("}");

		throw new NoSuchCharacterException(msg.toString());
	}

	/**
	 * Returns the first character in the ordered set where characterName = &#63;.
	 *
	 * @param characterName the character name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching character, or <code>null</code> if a matching character could not be found
	 */
	@Override
	public Character fetchByByName_First(String characterName,
		OrderByComparator<Character> orderByComparator) {
		List<Character> list = findByByName(characterName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last character in the ordered set where characterName = &#63;.
	 *
	 * @param characterName the character name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching character
	 * @throws NoSuchCharacterException if a matching character could not be found
	 */
	@Override
	public Character findByByName_Last(String characterName,
		OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException {
		Character character = fetchByByName_Last(characterName,
				orderByComparator);

		if (character != null) {
			return character;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("characterName=");
		msg.append(characterName);

		msg.append("}");

		throw new NoSuchCharacterException(msg.toString());
	}

	/**
	 * Returns the last character in the ordered set where characterName = &#63;.
	 *
	 * @param characterName the character name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching character, or <code>null</code> if a matching character could not be found
	 */
	@Override
	public Character fetchByByName_Last(String characterName,
		OrderByComparator<Character> orderByComparator) {
		int count = countByByName(characterName);

		if (count == 0) {
			return null;
		}

		List<Character> list = findByByName(characterName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the characters before and after the current character in the ordered set where characterName = &#63;.
	 *
	 * @param characterId the primary key of the current character
	 * @param characterName the character name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next character
	 * @throws NoSuchCharacterException if a character with the primary key could not be found
	 */
	@Override
	public Character[] findByByName_PrevAndNext(long characterId,
		String characterName, OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException {
		Character character = findByPrimaryKey(characterId);

		Session session = null;

		try {
			session = openSession();

			Character[] array = new CharacterImpl[3];

			array[0] = getByByName_PrevAndNext(session, character,
					characterName, orderByComparator, true);

			array[1] = character;

			array[2] = getByByName_PrevAndNext(session, character,
					characterName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Character getByByName_PrevAndNext(Session session,
		Character character, String characterName,
		OrderByComparator<Character> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHARACTER_WHERE);

		boolean bindCharacterName = false;

		if (characterName == null) {
			query.append(_FINDER_COLUMN_BYNAME_CHARACTERNAME_1);
		}
		else if (characterName.equals("")) {
			query.append(_FINDER_COLUMN_BYNAME_CHARACTERNAME_3);
		}
		else {
			bindCharacterName = true;

			query.append(_FINDER_COLUMN_BYNAME_CHARACTERNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CharacterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCharacterName) {
			qPos.add(characterName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(character);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Character> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the characters where characterName = &#63; from the database.
	 *
	 * @param characterName the character name
	 */
	@Override
	public void removeByByName(String characterName) {
		for (Character character : findByByName(characterName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(character);
		}
	}

	/**
	 * Returns the number of characters where characterName = &#63;.
	 *
	 * @param characterName the character name
	 * @return the number of matching characters
	 */
	@Override
	public int countByByName(String characterName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYNAME;

		Object[] finderArgs = new Object[] { characterName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHARACTER_WHERE);

			boolean bindCharacterName = false;

			if (characterName == null) {
				query.append(_FINDER_COLUMN_BYNAME_CHARACTERNAME_1);
			}
			else if (characterName.equals("")) {
				query.append(_FINDER_COLUMN_BYNAME_CHARACTERNAME_3);
			}
			else {
				bindCharacterName = true;

				query.append(_FINDER_COLUMN_BYNAME_CHARACTERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCharacterName) {
					qPos.add(characterName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYNAME_CHARACTERNAME_1 = "character.characterName IS NULL";
	private static final String _FINDER_COLUMN_BYNAME_CHARACTERNAME_2 = "character.characterName = ?";
	private static final String _FINDER_COLUMN_BYNAME_CHARACTERNAME_3 = "(character.characterName IS NULL OR character.characterName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYCLASS = new FinderPath(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterModelImpl.FINDER_CACHE_ENABLED, CharacterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByClass",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCLASS =
		new FinderPath(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterModelImpl.FINDER_CACHE_ENABLED, CharacterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByClass",
			new String[] { String.class.getName() },
			CharacterModelImpl.CHARACTERCLASS_COLUMN_BITMASK |
			CharacterModelImpl.CHARACTERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYCLASS = new FinderPath(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByClass",
			new String[] { String.class.getName() });

	/**
	 * Returns all the characters where characterClass = &#63;.
	 *
	 * @param characterClass the character class
	 * @return the matching characters
	 */
	@Override
	public List<Character> findByByClass(String characterClass) {
		return findByByClass(characterClass, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the characters where characterClass = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param characterClass the character class
	 * @param start the lower bound of the range of characters
	 * @param end the upper bound of the range of characters (not inclusive)
	 * @return the range of matching characters
	 */
	@Override
	public List<Character> findByByClass(String characterClass, int start,
		int end) {
		return findByByClass(characterClass, start, end, null);
	}

	/**
	 * Returns an ordered range of all the characters where characterClass = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param characterClass the character class
	 * @param start the lower bound of the range of characters
	 * @param end the upper bound of the range of characters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching characters
	 */
	@Override
	public List<Character> findByByClass(String characterClass, int start,
		int end, OrderByComparator<Character> orderByComparator) {
		return findByByClass(characterClass, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the characters where characterClass = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param characterClass the character class
	 * @param start the lower bound of the range of characters
	 * @param end the upper bound of the range of characters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching characters
	 */
	@Override
	public List<Character> findByByClass(String characterClass, int start,
		int end, OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCLASS;
			finderArgs = new Object[] { characterClass };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYCLASS;
			finderArgs = new Object[] {
					characterClass,
					
					start, end, orderByComparator
				};
		}

		List<Character> list = null;

		if (retrieveFromCache) {
			list = (List<Character>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Character character : list) {
					if (!Objects.equals(characterClass,
								character.getCharacterClass())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CHARACTER_WHERE);

			boolean bindCharacterClass = false;

			if (characterClass == null) {
				query.append(_FINDER_COLUMN_BYCLASS_CHARACTERCLASS_1);
			}
			else if (characterClass.equals("")) {
				query.append(_FINDER_COLUMN_BYCLASS_CHARACTERCLASS_3);
			}
			else {
				bindCharacterClass = true;

				query.append(_FINDER_COLUMN_BYCLASS_CHARACTERCLASS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CharacterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCharacterClass) {
					qPos.add(characterClass);
				}

				if (!pagination) {
					list = (List<Character>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Character>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first character in the ordered set where characterClass = &#63;.
	 *
	 * @param characterClass the character class
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching character
	 * @throws NoSuchCharacterException if a matching character could not be found
	 */
	@Override
	public Character findByByClass_First(String characterClass,
		OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException {
		Character character = fetchByByClass_First(characterClass,
				orderByComparator);

		if (character != null) {
			return character;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("characterClass=");
		msg.append(characterClass);

		msg.append("}");

		throw new NoSuchCharacterException(msg.toString());
	}

	/**
	 * Returns the first character in the ordered set where characterClass = &#63;.
	 *
	 * @param characterClass the character class
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching character, or <code>null</code> if a matching character could not be found
	 */
	@Override
	public Character fetchByByClass_First(String characterClass,
		OrderByComparator<Character> orderByComparator) {
		List<Character> list = findByByClass(characterClass, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last character in the ordered set where characterClass = &#63;.
	 *
	 * @param characterClass the character class
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching character
	 * @throws NoSuchCharacterException if a matching character could not be found
	 */
	@Override
	public Character findByByClass_Last(String characterClass,
		OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException {
		Character character = fetchByByClass_Last(characterClass,
				orderByComparator);

		if (character != null) {
			return character;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("characterClass=");
		msg.append(characterClass);

		msg.append("}");

		throw new NoSuchCharacterException(msg.toString());
	}

	/**
	 * Returns the last character in the ordered set where characterClass = &#63;.
	 *
	 * @param characterClass the character class
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching character, or <code>null</code> if a matching character could not be found
	 */
	@Override
	public Character fetchByByClass_Last(String characterClass,
		OrderByComparator<Character> orderByComparator) {
		int count = countByByClass(characterClass);

		if (count == 0) {
			return null;
		}

		List<Character> list = findByByClass(characterClass, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the characters before and after the current character in the ordered set where characterClass = &#63;.
	 *
	 * @param characterId the primary key of the current character
	 * @param characterClass the character class
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next character
	 * @throws NoSuchCharacterException if a character with the primary key could not be found
	 */
	@Override
	public Character[] findByByClass_PrevAndNext(long characterId,
		String characterClass, OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException {
		Character character = findByPrimaryKey(characterId);

		Session session = null;

		try {
			session = openSession();

			Character[] array = new CharacterImpl[3];

			array[0] = getByByClass_PrevAndNext(session, character,
					characterClass, orderByComparator, true);

			array[1] = character;

			array[2] = getByByClass_PrevAndNext(session, character,
					characterClass, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Character getByByClass_PrevAndNext(Session session,
		Character character, String characterClass,
		OrderByComparator<Character> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHARACTER_WHERE);

		boolean bindCharacterClass = false;

		if (characterClass == null) {
			query.append(_FINDER_COLUMN_BYCLASS_CHARACTERCLASS_1);
		}
		else if (characterClass.equals("")) {
			query.append(_FINDER_COLUMN_BYCLASS_CHARACTERCLASS_3);
		}
		else {
			bindCharacterClass = true;

			query.append(_FINDER_COLUMN_BYCLASS_CHARACTERCLASS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CharacterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCharacterClass) {
			qPos.add(characterClass);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(character);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Character> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the characters where characterClass = &#63; from the database.
	 *
	 * @param characterClass the character class
	 */
	@Override
	public void removeByByClass(String characterClass) {
		for (Character character : findByByClass(characterClass,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(character);
		}
	}

	/**
	 * Returns the number of characters where characterClass = &#63;.
	 *
	 * @param characterClass the character class
	 * @return the number of matching characters
	 */
	@Override
	public int countByByClass(String characterClass) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYCLASS;

		Object[] finderArgs = new Object[] { characterClass };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHARACTER_WHERE);

			boolean bindCharacterClass = false;

			if (characterClass == null) {
				query.append(_FINDER_COLUMN_BYCLASS_CHARACTERCLASS_1);
			}
			else if (characterClass.equals("")) {
				query.append(_FINDER_COLUMN_BYCLASS_CHARACTERCLASS_3);
			}
			else {
				bindCharacterClass = true;

				query.append(_FINDER_COLUMN_BYCLASS_CHARACTERCLASS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCharacterClass) {
					qPos.add(characterClass);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYCLASS_CHARACTERCLASS_1 = "character.characterClass IS NULL";
	private static final String _FINDER_COLUMN_BYCLASS_CHARACTERCLASS_2 = "character.characterClass = ?";
	private static final String _FINDER_COLUMN_BYCLASS_CHARACTERCLASS_3 = "(character.characterClass IS NULL OR character.characterClass = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYRACE = new FinderPath(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterModelImpl.FINDER_CACHE_ENABLED, CharacterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByRace",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYRACE =
		new FinderPath(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterModelImpl.FINDER_CACHE_ENABLED, CharacterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByRace",
			new String[] { String.class.getName() },
			CharacterModelImpl.RACE_COLUMN_BITMASK |
			CharacterModelImpl.CHARACTERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYRACE = new FinderPath(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByRace",
			new String[] { String.class.getName() });

	/**
	 * Returns all the characters where race = &#63;.
	 *
	 * @param race the race
	 * @return the matching characters
	 */
	@Override
	public List<Character> findByByRace(String race) {
		return findByByRace(race, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the characters where race = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param race the race
	 * @param start the lower bound of the range of characters
	 * @param end the upper bound of the range of characters (not inclusive)
	 * @return the range of matching characters
	 */
	@Override
	public List<Character> findByByRace(String race, int start, int end) {
		return findByByRace(race, start, end, null);
	}

	/**
	 * Returns an ordered range of all the characters where race = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param race the race
	 * @param start the lower bound of the range of characters
	 * @param end the upper bound of the range of characters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching characters
	 */
	@Override
	public List<Character> findByByRace(String race, int start, int end,
		OrderByComparator<Character> orderByComparator) {
		return findByByRace(race, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the characters where race = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param race the race
	 * @param start the lower bound of the range of characters
	 * @param end the upper bound of the range of characters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching characters
	 */
	@Override
	public List<Character> findByByRace(String race, int start, int end,
		OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYRACE;
			finderArgs = new Object[] { race };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYRACE;
			finderArgs = new Object[] { race, start, end, orderByComparator };
		}

		List<Character> list = null;

		if (retrieveFromCache) {
			list = (List<Character>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Character character : list) {
					if (!Objects.equals(race, character.getRace())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CHARACTER_WHERE);

			boolean bindRace = false;

			if (race == null) {
				query.append(_FINDER_COLUMN_BYRACE_RACE_1);
			}
			else if (race.equals("")) {
				query.append(_FINDER_COLUMN_BYRACE_RACE_3);
			}
			else {
				bindRace = true;

				query.append(_FINDER_COLUMN_BYRACE_RACE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CharacterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRace) {
					qPos.add(race);
				}

				if (!pagination) {
					list = (List<Character>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Character>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first character in the ordered set where race = &#63;.
	 *
	 * @param race the race
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching character
	 * @throws NoSuchCharacterException if a matching character could not be found
	 */
	@Override
	public Character findByByRace_First(String race,
		OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException {
		Character character = fetchByByRace_First(race, orderByComparator);

		if (character != null) {
			return character;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("race=");
		msg.append(race);

		msg.append("}");

		throw new NoSuchCharacterException(msg.toString());
	}

	/**
	 * Returns the first character in the ordered set where race = &#63;.
	 *
	 * @param race the race
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching character, or <code>null</code> if a matching character could not be found
	 */
	@Override
	public Character fetchByByRace_First(String race,
		OrderByComparator<Character> orderByComparator) {
		List<Character> list = findByByRace(race, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last character in the ordered set where race = &#63;.
	 *
	 * @param race the race
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching character
	 * @throws NoSuchCharacterException if a matching character could not be found
	 */
	@Override
	public Character findByByRace_Last(String race,
		OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException {
		Character character = fetchByByRace_Last(race, orderByComparator);

		if (character != null) {
			return character;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("race=");
		msg.append(race);

		msg.append("}");

		throw new NoSuchCharacterException(msg.toString());
	}

	/**
	 * Returns the last character in the ordered set where race = &#63;.
	 *
	 * @param race the race
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching character, or <code>null</code> if a matching character could not be found
	 */
	@Override
	public Character fetchByByRace_Last(String race,
		OrderByComparator<Character> orderByComparator) {
		int count = countByByRace(race);

		if (count == 0) {
			return null;
		}

		List<Character> list = findByByRace(race, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the characters before and after the current character in the ordered set where race = &#63;.
	 *
	 * @param characterId the primary key of the current character
	 * @param race the race
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next character
	 * @throws NoSuchCharacterException if a character with the primary key could not be found
	 */
	@Override
	public Character[] findByByRace_PrevAndNext(long characterId, String race,
		OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException {
		Character character = findByPrimaryKey(characterId);

		Session session = null;

		try {
			session = openSession();

			Character[] array = new CharacterImpl[3];

			array[0] = getByByRace_PrevAndNext(session, character, race,
					orderByComparator, true);

			array[1] = character;

			array[2] = getByByRace_PrevAndNext(session, character, race,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Character getByByRace_PrevAndNext(Session session,
		Character character, String race,
		OrderByComparator<Character> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHARACTER_WHERE);

		boolean bindRace = false;

		if (race == null) {
			query.append(_FINDER_COLUMN_BYRACE_RACE_1);
		}
		else if (race.equals("")) {
			query.append(_FINDER_COLUMN_BYRACE_RACE_3);
		}
		else {
			bindRace = true;

			query.append(_FINDER_COLUMN_BYRACE_RACE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CharacterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRace) {
			qPos.add(race);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(character);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Character> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the characters where race = &#63; from the database.
	 *
	 * @param race the race
	 */
	@Override
	public void removeByByRace(String race) {
		for (Character character : findByByRace(race, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(character);
		}
	}

	/**
	 * Returns the number of characters where race = &#63;.
	 *
	 * @param race the race
	 * @return the number of matching characters
	 */
	@Override
	public int countByByRace(String race) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYRACE;

		Object[] finderArgs = new Object[] { race };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHARACTER_WHERE);

			boolean bindRace = false;

			if (race == null) {
				query.append(_FINDER_COLUMN_BYRACE_RACE_1);
			}
			else if (race.equals("")) {
				query.append(_FINDER_COLUMN_BYRACE_RACE_3);
			}
			else {
				bindRace = true;

				query.append(_FINDER_COLUMN_BYRACE_RACE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRace) {
					qPos.add(race);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYRACE_RACE_1 = "character.race IS NULL";
	private static final String _FINDER_COLUMN_BYRACE_RACE_2 = "character.race = ?";
	private static final String _FINDER_COLUMN_BYRACE_RACE_3 = "(character.race IS NULL OR character.race = '')";

	public CharacterPersistenceImpl() {
		setModelClass(Character.class);
	}

	/**
	 * Caches the character in the entity cache if it is enabled.
	 *
	 * @param character the character
	 */
	@Override
	public void cacheResult(Character character) {
		entityCache.putResult(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterImpl.class, character.getPrimaryKey(), character);

		character.resetOriginalValues();
	}

	/**
	 * Caches the characters in the entity cache if it is enabled.
	 *
	 * @param characters the characters
	 */
	@Override
	public void cacheResult(List<Character> characters) {
		for (Character character : characters) {
			if (entityCache.getResult(CharacterModelImpl.ENTITY_CACHE_ENABLED,
						CharacterImpl.class, character.getPrimaryKey()) == null) {
				cacheResult(character);
			}
			else {
				character.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all characters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CharacterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the character.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Character character) {
		entityCache.removeResult(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterImpl.class, character.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Character> characters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Character character : characters) {
			entityCache.removeResult(CharacterModelImpl.ENTITY_CACHE_ENABLED,
				CharacterImpl.class, character.getPrimaryKey());
		}
	}

	/**
	 * Creates a new character with the primary key. Does not add the character to the database.
	 *
	 * @param characterId the primary key for the new character
	 * @return the new character
	 */
	@Override
	public Character create(long characterId) {
		Character character = new CharacterImpl();

		character.setNew(true);
		character.setPrimaryKey(characterId);

		character.setCompanyId(companyProvider.getCompanyId());

		return character;
	}

	/**
	 * Removes the character with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param characterId the primary key of the character
	 * @return the character that was removed
	 * @throws NoSuchCharacterException if a character with the primary key could not be found
	 */
	@Override
	public Character remove(long characterId) throws NoSuchCharacterException {
		return remove((Serializable)characterId);
	}

	/**
	 * Removes the character with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the character
	 * @return the character that was removed
	 * @throws NoSuchCharacterException if a character with the primary key could not be found
	 */
	@Override
	public Character remove(Serializable primaryKey)
		throws NoSuchCharacterException {
		Session session = null;

		try {
			session = openSession();

			Character character = (Character)session.get(CharacterImpl.class,
					primaryKey);

			if (character == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCharacterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(character);
		}
		catch (NoSuchCharacterException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Character removeImpl(Character character) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(character)) {
				character = (Character)session.get(CharacterImpl.class,
						character.getPrimaryKeyObj());
			}

			if (character != null) {
				session.delete(character);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (character != null) {
			clearCache(character);
		}

		return character;
	}

	@Override
	public Character updateImpl(Character character) {
		boolean isNew = character.isNew();

		if (!(character instanceof CharacterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(character.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(character);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in character proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Character implementation " +
				character.getClass());
		}

		CharacterModelImpl characterModelImpl = (CharacterModelImpl)character;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (character.getCreateDate() == null)) {
			if (serviceContext == null) {
				character.setCreateDate(now);
			}
			else {
				character.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!characterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				character.setModifiedDate(now);
			}
			else {
				character.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (character.isNew()) {
				session.save(character);

				character.setNew(false);
			}
			else {
				character = (Character)session.merge(character);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CharacterModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { characterModelImpl.getCharacterName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BYNAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNAME,
				args);

			args = new Object[] { characterModelImpl.getCharacterClass() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BYCLASS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCLASS,
				args);

			args = new Object[] { characterModelImpl.getRace() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BYRACE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYRACE,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((characterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						characterModelImpl.getOriginalCharacterName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BYNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNAME,
					args);

				args = new Object[] { characterModelImpl.getCharacterName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BYNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYNAME,
					args);
			}

			if ((characterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCLASS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						characterModelImpl.getOriginalCharacterClass()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BYCLASS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCLASS,
					args);

				args = new Object[] { characterModelImpl.getCharacterClass() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BYCLASS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCLASS,
					args);
			}

			if ((characterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYRACE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						characterModelImpl.getOriginalRace()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BYRACE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYRACE,
					args);

				args = new Object[] { characterModelImpl.getRace() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BYRACE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYRACE,
					args);
			}
		}

		entityCache.putResult(CharacterModelImpl.ENTITY_CACHE_ENABLED,
			CharacterImpl.class, character.getPrimaryKey(), character, false);

		character.resetOriginalValues();

		return character;
	}

	/**
	 * Returns the character with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the character
	 * @return the character
	 * @throws NoSuchCharacterException if a character with the primary key could not be found
	 */
	@Override
	public Character findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCharacterException {
		Character character = fetchByPrimaryKey(primaryKey);

		if (character == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCharacterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return character;
	}

	/**
	 * Returns the character with the primary key or throws a {@link NoSuchCharacterException} if it could not be found.
	 *
	 * @param characterId the primary key of the character
	 * @return the character
	 * @throws NoSuchCharacterException if a character with the primary key could not be found
	 */
	@Override
	public Character findByPrimaryKey(long characterId)
		throws NoSuchCharacterException {
		return findByPrimaryKey((Serializable)characterId);
	}

	/**
	 * Returns the character with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the character
	 * @return the character, or <code>null</code> if a character with the primary key could not be found
	 */
	@Override
	public Character fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CharacterModelImpl.ENTITY_CACHE_ENABLED,
				CharacterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Character character = (Character)serializable;

		if (character == null) {
			Session session = null;

			try {
				session = openSession();

				character = (Character)session.get(CharacterImpl.class,
						primaryKey);

				if (character != null) {
					cacheResult(character);
				}
				else {
					entityCache.putResult(CharacterModelImpl.ENTITY_CACHE_ENABLED,
						CharacterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CharacterModelImpl.ENTITY_CACHE_ENABLED,
					CharacterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return character;
	}

	/**
	 * Returns the character with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param characterId the primary key of the character
	 * @return the character, or <code>null</code> if a character with the primary key could not be found
	 */
	@Override
	public Character fetchByPrimaryKey(long characterId) {
		return fetchByPrimaryKey((Serializable)characterId);
	}

	@Override
	public Map<Serializable, Character> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Character> map = new HashMap<Serializable, Character>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Character character = fetchByPrimaryKey(primaryKey);

			if (character != null) {
				map.put(primaryKey, character);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CharacterModelImpl.ENTITY_CACHE_ENABLED,
					CharacterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Character)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CHARACTER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Character character : (List<Character>)q.list()) {
				map.put(character.getPrimaryKeyObj(), character);

				cacheResult(character);

				uncachedPrimaryKeys.remove(character.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CharacterModelImpl.ENTITY_CACHE_ENABLED,
					CharacterImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the characters.
	 *
	 * @return the characters
	 */
	@Override
	public List<Character> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the characters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of characters
	 * @param end the upper bound of the range of characters (not inclusive)
	 * @return the range of characters
	 */
	@Override
	public List<Character> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the characters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of characters
	 * @param end the upper bound of the range of characters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of characters
	 */
	@Override
	public List<Character> findAll(int start, int end,
		OrderByComparator<Character> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the characters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of characters
	 * @param end the upper bound of the range of characters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of characters
	 */
	@Override
	public List<Character> findAll(int start, int end,
		OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Character> list = null;

		if (retrieveFromCache) {
			list = (List<Character>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CHARACTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHARACTER;

				if (pagination) {
					sql = sql.concat(CharacterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Character>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Character>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the characters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Character character : findAll()) {
			remove(character);
		}
	}

	/**
	 * Returns the number of characters.
	 *
	 * @return the number of characters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CHARACTER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CharacterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the character persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CharacterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CHARACTER = "SELECT character FROM Character character";
	private static final String _SQL_SELECT_CHARACTER_WHERE_PKS_IN = "SELECT character FROM Character character WHERE characterId IN (";
	private static final String _SQL_SELECT_CHARACTER_WHERE = "SELECT character FROM Character character WHERE ";
	private static final String _SQL_COUNT_CHARACTER = "SELECT COUNT(character) FROM Character character";
	private static final String _SQL_COUNT_CHARACTER_WHERE = "SELECT COUNT(character) FROM Character character WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "character.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Character exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Character exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CharacterPersistenceImpl.class);
}