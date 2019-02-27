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

package com.lfrgs.example.service.dnd.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.lfrgs.example.service.dnd.model.Character;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the character service. This utility wraps {@link com.lfrgs.example.service.dnd.service.persistence.impl.CharacterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CharacterPersistence
 * @see com.lfrgs.example.service.dnd.service.persistence.impl.CharacterPersistenceImpl
 * @generated
 */
@ProviderType
public class CharacterUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Character character) {
		getPersistence().clearCache(character);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Character> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Character> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Character> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Character> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Character update(Character character) {
		return getPersistence().update(character);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Character update(Character character,
		ServiceContext serviceContext) {
		return getPersistence().update(character, serviceContext);
	}

	/**
	* Returns all the characters where characterName = &#63;.
	*
	* @param characterName the character name
	* @return the matching characters
	*/
	public static List<Character> findByByName(String characterName) {
		return getPersistence().findByByName(characterName);
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
	public static List<Character> findByByName(String characterName, int start,
		int end) {
		return getPersistence().findByByName(characterName, start, end);
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
	public static List<Character> findByByName(String characterName, int start,
		int end, OrderByComparator<Character> orderByComparator) {
		return getPersistence()
				   .findByByName(characterName, start, end, orderByComparator);
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
	public static List<Character> findByByName(String characterName, int start,
		int end, OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByByName(characterName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first character in the ordered set where characterName = &#63;.
	*
	* @param characterName the character name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public static Character findByByName_First(String characterName,
		OrderByComparator<Character> orderByComparator)
		throws com.lfrgs.example.service.dnd.exception.NoSuchCharacterException {
		return getPersistence()
				   .findByByName_First(characterName, orderByComparator);
	}

	/**
	* Returns the first character in the ordered set where characterName = &#63;.
	*
	* @param characterName the character name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character, or <code>null</code> if a matching character could not be found
	*/
	public static Character fetchByByName_First(String characterName,
		OrderByComparator<Character> orderByComparator) {
		return getPersistence()
				   .fetchByByName_First(characterName, orderByComparator);
	}

	/**
	* Returns the last character in the ordered set where characterName = &#63;.
	*
	* @param characterName the character name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public static Character findByByName_Last(String characterName,
		OrderByComparator<Character> orderByComparator)
		throws com.lfrgs.example.service.dnd.exception.NoSuchCharacterException {
		return getPersistence()
				   .findByByName_Last(characterName, orderByComparator);
	}

	/**
	* Returns the last character in the ordered set where characterName = &#63;.
	*
	* @param characterName the character name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character, or <code>null</code> if a matching character could not be found
	*/
	public static Character fetchByByName_Last(String characterName,
		OrderByComparator<Character> orderByComparator) {
		return getPersistence()
				   .fetchByByName_Last(characterName, orderByComparator);
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
	public static Character[] findByByName_PrevAndNext(long characterId,
		String characterName, OrderByComparator<Character> orderByComparator)
		throws com.lfrgs.example.service.dnd.exception.NoSuchCharacterException {
		return getPersistence()
				   .findByByName_PrevAndNext(characterId, characterName,
			orderByComparator);
	}

	/**
	* Removes all the characters where characterName = &#63; from the database.
	*
	* @param characterName the character name
	*/
	public static void removeByByName(String characterName) {
		getPersistence().removeByByName(characterName);
	}

	/**
	* Returns the number of characters where characterName = &#63;.
	*
	* @param characterName the character name
	* @return the number of matching characters
	*/
	public static int countByByName(String characterName) {
		return getPersistence().countByByName(characterName);
	}

	/**
	* Returns all the characters where characterClass = &#63;.
	*
	* @param characterClass the character class
	* @return the matching characters
	*/
	public static List<Character> findByByClass(String characterClass) {
		return getPersistence().findByByClass(characterClass);
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
	public static List<Character> findByByClass(String characterClass,
		int start, int end) {
		return getPersistence().findByByClass(characterClass, start, end);
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
	public static List<Character> findByByClass(String characterClass,
		int start, int end, OrderByComparator<Character> orderByComparator) {
		return getPersistence()
				   .findByByClass(characterClass, start, end, orderByComparator);
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
	public static List<Character> findByByClass(String characterClass,
		int start, int end, OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByByClass(characterClass, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first character in the ordered set where characterClass = &#63;.
	*
	* @param characterClass the character class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public static Character findByByClass_First(String characterClass,
		OrderByComparator<Character> orderByComparator)
		throws com.lfrgs.example.service.dnd.exception.NoSuchCharacterException {
		return getPersistence()
				   .findByByClass_First(characterClass, orderByComparator);
	}

	/**
	* Returns the first character in the ordered set where characterClass = &#63;.
	*
	* @param characterClass the character class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character, or <code>null</code> if a matching character could not be found
	*/
	public static Character fetchByByClass_First(String characterClass,
		OrderByComparator<Character> orderByComparator) {
		return getPersistence()
				   .fetchByByClass_First(characterClass, orderByComparator);
	}

	/**
	* Returns the last character in the ordered set where characterClass = &#63;.
	*
	* @param characterClass the character class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public static Character findByByClass_Last(String characterClass,
		OrderByComparator<Character> orderByComparator)
		throws com.lfrgs.example.service.dnd.exception.NoSuchCharacterException {
		return getPersistence()
				   .findByByClass_Last(characterClass, orderByComparator);
	}

	/**
	* Returns the last character in the ordered set where characterClass = &#63;.
	*
	* @param characterClass the character class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character, or <code>null</code> if a matching character could not be found
	*/
	public static Character fetchByByClass_Last(String characterClass,
		OrderByComparator<Character> orderByComparator) {
		return getPersistence()
				   .fetchByByClass_Last(characterClass, orderByComparator);
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
	public static Character[] findByByClass_PrevAndNext(long characterId,
		String characterClass, OrderByComparator<Character> orderByComparator)
		throws com.lfrgs.example.service.dnd.exception.NoSuchCharacterException {
		return getPersistence()
				   .findByByClass_PrevAndNext(characterId, characterClass,
			orderByComparator);
	}

	/**
	* Removes all the characters where characterClass = &#63; from the database.
	*
	* @param characterClass the character class
	*/
	public static void removeByByClass(String characterClass) {
		getPersistence().removeByByClass(characterClass);
	}

	/**
	* Returns the number of characters where characterClass = &#63;.
	*
	* @param characterClass the character class
	* @return the number of matching characters
	*/
	public static int countByByClass(String characterClass) {
		return getPersistence().countByByClass(characterClass);
	}

	/**
	* Returns all the characters where race = &#63;.
	*
	* @param race the race
	* @return the matching characters
	*/
	public static List<Character> findByByRace(String race) {
		return getPersistence().findByByRace(race);
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
	public static List<Character> findByByRace(String race, int start, int end) {
		return getPersistence().findByByRace(race, start, end);
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
	public static List<Character> findByByRace(String race, int start, int end,
		OrderByComparator<Character> orderByComparator) {
		return getPersistence().findByByRace(race, start, end, orderByComparator);
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
	public static List<Character> findByByRace(String race, int start, int end,
		OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByByRace(race, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first character in the ordered set where race = &#63;.
	*
	* @param race the race
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public static Character findByByRace_First(String race,
		OrderByComparator<Character> orderByComparator)
		throws com.lfrgs.example.service.dnd.exception.NoSuchCharacterException {
		return getPersistence().findByByRace_First(race, orderByComparator);
	}

	/**
	* Returns the first character in the ordered set where race = &#63;.
	*
	* @param race the race
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character, or <code>null</code> if a matching character could not be found
	*/
	public static Character fetchByByRace_First(String race,
		OrderByComparator<Character> orderByComparator) {
		return getPersistence().fetchByByRace_First(race, orderByComparator);
	}

	/**
	* Returns the last character in the ordered set where race = &#63;.
	*
	* @param race the race
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public static Character findByByRace_Last(String race,
		OrderByComparator<Character> orderByComparator)
		throws com.lfrgs.example.service.dnd.exception.NoSuchCharacterException {
		return getPersistence().findByByRace_Last(race, orderByComparator);
	}

	/**
	* Returns the last character in the ordered set where race = &#63;.
	*
	* @param race the race
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character, or <code>null</code> if a matching character could not be found
	*/
	public static Character fetchByByRace_Last(String race,
		OrderByComparator<Character> orderByComparator) {
		return getPersistence().fetchByByRace_Last(race, orderByComparator);
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
	public static Character[] findByByRace_PrevAndNext(long characterId,
		String race, OrderByComparator<Character> orderByComparator)
		throws com.lfrgs.example.service.dnd.exception.NoSuchCharacterException {
		return getPersistence()
				   .findByByRace_PrevAndNext(characterId, race,
			orderByComparator);
	}

	/**
	* Removes all the characters where race = &#63; from the database.
	*
	* @param race the race
	*/
	public static void removeByByRace(String race) {
		getPersistence().removeByByRace(race);
	}

	/**
	* Returns the number of characters where race = &#63;.
	*
	* @param race the race
	* @return the number of matching characters
	*/
	public static int countByByRace(String race) {
		return getPersistence().countByByRace(race);
	}

	/**
	* Caches the character in the entity cache if it is enabled.
	*
	* @param character the character
	*/
	public static void cacheResult(Character character) {
		getPersistence().cacheResult(character);
	}

	/**
	* Caches the characters in the entity cache if it is enabled.
	*
	* @param characters the characters
	*/
	public static void cacheResult(List<Character> characters) {
		getPersistence().cacheResult(characters);
	}

	/**
	* Creates a new character with the primary key. Does not add the character to the database.
	*
	* @param characterId the primary key for the new character
	* @return the new character
	*/
	public static Character create(long characterId) {
		return getPersistence().create(characterId);
	}

	/**
	* Removes the character with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param characterId the primary key of the character
	* @return the character that was removed
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public static Character remove(long characterId)
		throws com.lfrgs.example.service.dnd.exception.NoSuchCharacterException {
		return getPersistence().remove(characterId);
	}

	public static Character updateImpl(Character character) {
		return getPersistence().updateImpl(character);
	}

	/**
	* Returns the character with the primary key or throws a {@link NoSuchCharacterException} if it could not be found.
	*
	* @param characterId the primary key of the character
	* @return the character
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public static Character findByPrimaryKey(long characterId)
		throws com.lfrgs.example.service.dnd.exception.NoSuchCharacterException {
		return getPersistence().findByPrimaryKey(characterId);
	}

	/**
	* Returns the character with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param characterId the primary key of the character
	* @return the character, or <code>null</code> if a character with the primary key could not be found
	*/
	public static Character fetchByPrimaryKey(long characterId) {
		return getPersistence().fetchByPrimaryKey(characterId);
	}

	public static java.util.Map<java.io.Serializable, Character> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the characters.
	*
	* @return the characters
	*/
	public static List<Character> findAll() {
		return getPersistence().findAll();
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
	public static List<Character> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Character> findAll(int start, int end,
		OrderByComparator<Character> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Character> findAll(int start, int end,
		OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the characters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of characters.
	*
	* @return the number of characters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CharacterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CharacterPersistence, CharacterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CharacterPersistence.class);

		ServiceTracker<CharacterPersistence, CharacterPersistence> serviceTracker =
			new ServiceTracker<CharacterPersistence, CharacterPersistence>(bundle.getBundleContext(),
				CharacterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}