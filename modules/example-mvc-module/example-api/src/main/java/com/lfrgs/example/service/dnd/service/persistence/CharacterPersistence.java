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

import com.lfrgs.example.service.dnd.exception.NoSuchCharacterException;
import com.lfrgs.example.service.dnd.model.Character;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the character service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.lfrgs.example.service.dnd.service.persistence.impl.CharacterPersistenceImpl
 * @see CharacterUtil
 * @generated
 */
@ProviderType
public interface CharacterPersistence extends BasePersistence<Character> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CharacterUtil} to access the character persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the characters where characterName = &#63;.
	*
	* @param characterName the character name
	* @return the matching characters
	*/
	public java.util.List<Character> findByByName(String characterName);

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
	public java.util.List<Character> findByByName(String characterName,
		int start, int end);

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
	public java.util.List<Character> findByByName(String characterName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

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
	public java.util.List<Character> findByByName(String characterName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first character in the ordered set where characterName = &#63;.
	*
	* @param characterName the character name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByByName_First(String characterName,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the first character in the ordered set where characterName = &#63;.
	*
	* @param characterName the character name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByByName_First(String characterName,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the last character in the ordered set where characterName = &#63;.
	*
	* @param characterName the character name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByByName_Last(String characterName,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the last character in the ordered set where characterName = &#63;.
	*
	* @param characterName the character name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByByName_Last(String characterName,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the characters before and after the current character in the ordered set where characterName = &#63;.
	*
	* @param characterId the primary key of the current character
	* @param characterName the character name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next character
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public Character[] findByByName_PrevAndNext(long characterId,
		String characterName,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Removes all the characters where characterName = &#63; from the database.
	*
	* @param characterName the character name
	*/
	public void removeByByName(String characterName);

	/**
	* Returns the number of characters where characterName = &#63;.
	*
	* @param characterName the character name
	* @return the number of matching characters
	*/
	public int countByByName(String characterName);

	/**
	* Returns all the characters where characterClass = &#63;.
	*
	* @param characterClass the character class
	* @return the matching characters
	*/
	public java.util.List<Character> findByByClass(String characterClass);

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
	public java.util.List<Character> findByByClass(String characterClass,
		int start, int end);

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
	public java.util.List<Character> findByByClass(String characterClass,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

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
	public java.util.List<Character> findByByClass(String characterClass,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first character in the ordered set where characterClass = &#63;.
	*
	* @param characterClass the character class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByByClass_First(String characterClass,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the first character in the ordered set where characterClass = &#63;.
	*
	* @param characterClass the character class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByByClass_First(String characterClass,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the last character in the ordered set where characterClass = &#63;.
	*
	* @param characterClass the character class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByByClass_Last(String characterClass,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the last character in the ordered set where characterClass = &#63;.
	*
	* @param characterClass the character class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByByClass_Last(String characterClass,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the characters before and after the current character in the ordered set where characterClass = &#63;.
	*
	* @param characterId the primary key of the current character
	* @param characterClass the character class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next character
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public Character[] findByByClass_PrevAndNext(long characterId,
		String characterClass,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Removes all the characters where characterClass = &#63; from the database.
	*
	* @param characterClass the character class
	*/
	public void removeByByClass(String characterClass);

	/**
	* Returns the number of characters where characterClass = &#63;.
	*
	* @param characterClass the character class
	* @return the number of matching characters
	*/
	public int countByByClass(String characterClass);

	/**
	* Returns all the characters where race = &#63;.
	*
	* @param race the race
	* @return the matching characters
	*/
	public java.util.List<Character> findByByRace(String race);

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
	public java.util.List<Character> findByByRace(String race, int start,
		int end);

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
	public java.util.List<Character> findByByRace(String race, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

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
	public java.util.List<Character> findByByRace(String race, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first character in the ordered set where race = &#63;.
	*
	* @param race the race
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByByRace_First(String race,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the first character in the ordered set where race = &#63;.
	*
	* @param race the race
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByByRace_First(String race,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the last character in the ordered set where race = &#63;.
	*
	* @param race the race
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByByRace_Last(String race,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the last character in the ordered set where race = &#63;.
	*
	* @param race the race
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByByRace_Last(String race,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the characters before and after the current character in the ordered set where race = &#63;.
	*
	* @param characterId the primary key of the current character
	* @param race the race
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next character
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public Character[] findByByRace_PrevAndNext(long characterId, String race,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Removes all the characters where race = &#63; from the database.
	*
	* @param race the race
	*/
	public void removeByByRace(String race);

	/**
	* Returns the number of characters where race = &#63;.
	*
	* @param race the race
	* @return the number of matching characters
	*/
	public int countByByRace(String race);

	/**
	* Caches the character in the entity cache if it is enabled.
	*
	* @param character the character
	*/
	public void cacheResult(Character character);

	/**
	* Caches the characters in the entity cache if it is enabled.
	*
	* @param characters the characters
	*/
	public void cacheResult(java.util.List<Character> characters);

	/**
	* Creates a new character with the primary key. Does not add the character to the database.
	*
	* @param characterId the primary key for the new character
	* @return the new character
	*/
	public Character create(long characterId);

	/**
	* Removes the character with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param characterId the primary key of the character
	* @return the character that was removed
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public Character remove(long characterId) throws NoSuchCharacterException;

	public Character updateImpl(Character character);

	/**
	* Returns the character with the primary key or throws a {@link NoSuchCharacterException} if it could not be found.
	*
	* @param characterId the primary key of the character
	* @return the character
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public Character findByPrimaryKey(long characterId)
		throws NoSuchCharacterException;

	/**
	* Returns the character with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param characterId the primary key of the character
	* @return the character, or <code>null</code> if a character with the primary key could not be found
	*/
	public Character fetchByPrimaryKey(long characterId);

	@Override
	public java.util.Map<java.io.Serializable, Character> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the characters.
	*
	* @return the characters
	*/
	public java.util.List<Character> findAll();

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
	public java.util.List<Character> findAll(int start, int end);

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
	public java.util.List<Character> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

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
	public java.util.List<Character> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the characters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of characters.
	*
	* @return the number of characters
	*/
	public int countAll();
}