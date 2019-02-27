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

package com.lfrgs.example.service.dnd.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Character}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Character
 * @generated
 */
@ProviderType
public class CharacterWrapper implements Character, ModelWrapper<Character> {
	public CharacterWrapper(Character character) {
		_character = character;
	}

	@Override
	public Class<?> getModelClass() {
		return Character.class;
	}

	@Override
	public String getModelClassName() {
		return Character.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("characterId", getCharacterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("level", getLevel());
		attributes.put("race", getRace());
		attributes.put("characterClass", getCharacterClass());
		attributes.put("characterName", getCharacterName());
		attributes.put("strength", getStrength());
		attributes.put("dexterity", getDexterity());
		attributes.put("constitution", getConstitution());
		attributes.put("intelligence", getIntelligence());
		attributes.put("wisdom", getWisdom());
		attributes.put("charisma", getCharisma());
		attributes.put("speed", getSpeed());
		attributes.put("hp", getHp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long characterId = (Long)attributes.get("characterId");

		if (characterId != null) {
			setCharacterId(characterId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		String race = (String)attributes.get("race");

		if (race != null) {
			setRace(race);
		}

		String characterClass = (String)attributes.get("characterClass");

		if (characterClass != null) {
			setCharacterClass(characterClass);
		}

		String characterName = (String)attributes.get("characterName");

		if (characterName != null) {
			setCharacterName(characterName);
		}

		Integer strength = (Integer)attributes.get("strength");

		if (strength != null) {
			setStrength(strength);
		}

		Integer dexterity = (Integer)attributes.get("dexterity");

		if (dexterity != null) {
			setDexterity(dexterity);
		}

		Integer constitution = (Integer)attributes.get("constitution");

		if (constitution != null) {
			setConstitution(constitution);
		}

		Integer intelligence = (Integer)attributes.get("intelligence");

		if (intelligence != null) {
			setIntelligence(intelligence);
		}

		Integer wisdom = (Integer)attributes.get("wisdom");

		if (wisdom != null) {
			setWisdom(wisdom);
		}

		Integer charisma = (Integer)attributes.get("charisma");

		if (charisma != null) {
			setCharisma(charisma);
		}

		Integer speed = (Integer)attributes.get("speed");

		if (speed != null) {
			setSpeed(speed);
		}

		Integer hp = (Integer)attributes.get("hp");

		if (hp != null) {
			setHp(hp);
		}
	}

	@Override
	public Object clone() {
		return new CharacterWrapper((Character)_character.clone());
	}

	@Override
	public int compareTo(Character character) {
		return _character.compareTo(character);
	}

	/**
	* Returns the character class of this character.
	*
	* @return the character class of this character
	*/
	@Override
	public String getCharacterClass() {
		return _character.getCharacterClass();
	}

	/**
	* Returns the character ID of this character.
	*
	* @return the character ID of this character
	*/
	@Override
	public long getCharacterId() {
		return _character.getCharacterId();
	}

	/**
	* Returns the character name of this character.
	*
	* @return the character name of this character
	*/
	@Override
	public String getCharacterName() {
		return _character.getCharacterName();
	}

	/**
	* Returns the charisma of this character.
	*
	* @return the charisma of this character
	*/
	@Override
	public int getCharisma() {
		return _character.getCharisma();
	}

	/**
	* Returns the company ID of this character.
	*
	* @return the company ID of this character
	*/
	@Override
	public long getCompanyId() {
		return _character.getCompanyId();
	}

	/**
	* Returns the constitution of this character.
	*
	* @return the constitution of this character
	*/
	@Override
	public int getConstitution() {
		return _character.getConstitution();
	}

	/**
	* Returns the create date of this character.
	*
	* @return the create date of this character
	*/
	@Override
	public Date getCreateDate() {
		return _character.getCreateDate();
	}

	/**
	* Returns the dexterity of this character.
	*
	* @return the dexterity of this character
	*/
	@Override
	public int getDexterity() {
		return _character.getDexterity();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _character.getExpandoBridge();
	}

	/**
	* Returns the group ID of this character.
	*
	* @return the group ID of this character
	*/
	@Override
	public long getGroupId() {
		return _character.getGroupId();
	}

	/**
	* Returns the hp of this character.
	*
	* @return the hp of this character
	*/
	@Override
	public int getHp() {
		return _character.getHp();
	}

	/**
	* Returns the intelligence of this character.
	*
	* @return the intelligence of this character
	*/
	@Override
	public int getIntelligence() {
		return _character.getIntelligence();
	}

	/**
	* Returns the level of this character.
	*
	* @return the level of this character
	*/
	@Override
	public int getLevel() {
		return _character.getLevel();
	}

	/**
	* Returns the modified date of this character.
	*
	* @return the modified date of this character
	*/
	@Override
	public Date getModifiedDate() {
		return _character.getModifiedDate();
	}

	/**
	* Returns the mvcc version of this character.
	*
	* @return the mvcc version of this character
	*/
	@Override
	public long getMvccVersion() {
		return _character.getMvccVersion();
	}

	/**
	* Returns the primary key of this character.
	*
	* @return the primary key of this character
	*/
	@Override
	public long getPrimaryKey() {
		return _character.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _character.getPrimaryKeyObj();
	}

	/**
	* Returns the race of this character.
	*
	* @return the race of this character
	*/
	@Override
	public String getRace() {
		return _character.getRace();
	}

	/**
	* Returns the speed of this character.
	*
	* @return the speed of this character
	*/
	@Override
	public int getSpeed() {
		return _character.getSpeed();
	}

	/**
	* Returns the strength of this character.
	*
	* @return the strength of this character
	*/
	@Override
	public int getStrength() {
		return _character.getStrength();
	}

	/**
	* Returns the user ID of this character.
	*
	* @return the user ID of this character
	*/
	@Override
	public long getUserId() {
		return _character.getUserId();
	}

	/**
	* Returns the user name of this character.
	*
	* @return the user name of this character
	*/
	@Override
	public String getUserName() {
		return _character.getUserName();
	}

	/**
	* Returns the user uuid of this character.
	*
	* @return the user uuid of this character
	*/
	@Override
	public String getUserUuid() {
		return _character.getUserUuid();
	}

	/**
	* Returns the wisdom of this character.
	*
	* @return the wisdom of this character
	*/
	@Override
	public int getWisdom() {
		return _character.getWisdom();
	}

	@Override
	public int hashCode() {
		return _character.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _character.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _character.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _character.isNew();
	}

	@Override
	public void persist() {
		_character.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_character.setCachedModel(cachedModel);
	}

	/**
	* Sets the character class of this character.
	*
	* @param characterClass the character class of this character
	*/
	@Override
	public void setCharacterClass(String characterClass) {
		_character.setCharacterClass(characterClass);
	}

	/**
	* Sets the character ID of this character.
	*
	* @param characterId the character ID of this character
	*/
	@Override
	public void setCharacterId(long characterId) {
		_character.setCharacterId(characterId);
	}

	/**
	* Sets the character name of this character.
	*
	* @param characterName the character name of this character
	*/
	@Override
	public void setCharacterName(String characterName) {
		_character.setCharacterName(characterName);
	}

	/**
	* Sets the charisma of this character.
	*
	* @param charisma the charisma of this character
	*/
	@Override
	public void setCharisma(int charisma) {
		_character.setCharisma(charisma);
	}

	/**
	* Sets the company ID of this character.
	*
	* @param companyId the company ID of this character
	*/
	@Override
	public void setCompanyId(long companyId) {
		_character.setCompanyId(companyId);
	}

	/**
	* Sets the constitution of this character.
	*
	* @param constitution the constitution of this character
	*/
	@Override
	public void setConstitution(int constitution) {
		_character.setConstitution(constitution);
	}

	/**
	* Sets the create date of this character.
	*
	* @param createDate the create date of this character
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_character.setCreateDate(createDate);
	}

	/**
	* Sets the dexterity of this character.
	*
	* @param dexterity the dexterity of this character
	*/
	@Override
	public void setDexterity(int dexterity) {
		_character.setDexterity(dexterity);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_character.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_character.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_character.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this character.
	*
	* @param groupId the group ID of this character
	*/
	@Override
	public void setGroupId(long groupId) {
		_character.setGroupId(groupId);
	}

	/**
	* Sets the hp of this character.
	*
	* @param hp the hp of this character
	*/
	@Override
	public void setHp(int hp) {
		_character.setHp(hp);
	}

	/**
	* Sets the intelligence of this character.
	*
	* @param intelligence the intelligence of this character
	*/
	@Override
	public void setIntelligence(int intelligence) {
		_character.setIntelligence(intelligence);
	}

	/**
	* Sets the level of this character.
	*
	* @param level the level of this character
	*/
	@Override
	public void setLevel(int level) {
		_character.setLevel(level);
	}

	/**
	* Sets the modified date of this character.
	*
	* @param modifiedDate the modified date of this character
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_character.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the mvcc version of this character.
	*
	* @param mvccVersion the mvcc version of this character
	*/
	@Override
	public void setMvccVersion(long mvccVersion) {
		_character.setMvccVersion(mvccVersion);
	}

	@Override
	public void setNew(boolean n) {
		_character.setNew(n);
	}

	/**
	* Sets the primary key of this character.
	*
	* @param primaryKey the primary key of this character
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_character.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_character.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the race of this character.
	*
	* @param race the race of this character
	*/
	@Override
	public void setRace(String race) {
		_character.setRace(race);
	}

	/**
	* Sets the speed of this character.
	*
	* @param speed the speed of this character
	*/
	@Override
	public void setSpeed(int speed) {
		_character.setSpeed(speed);
	}

	/**
	* Sets the strength of this character.
	*
	* @param strength the strength of this character
	*/
	@Override
	public void setStrength(int strength) {
		_character.setStrength(strength);
	}

	/**
	* Sets the user ID of this character.
	*
	* @param userId the user ID of this character
	*/
	@Override
	public void setUserId(long userId) {
		_character.setUserId(userId);
	}

	/**
	* Sets the user name of this character.
	*
	* @param userName the user name of this character
	*/
	@Override
	public void setUserName(String userName) {
		_character.setUserName(userName);
	}

	/**
	* Sets the user uuid of this character.
	*
	* @param userUuid the user uuid of this character
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_character.setUserUuid(userUuid);
	}

	/**
	* Sets the wisdom of this character.
	*
	* @param wisdom the wisdom of this character
	*/
	@Override
	public void setWisdom(int wisdom) {
		_character.setWisdom(wisdom);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Character> toCacheModel() {
		return _character.toCacheModel();
	}

	@Override
	public Character toEscapedModel() {
		return new CharacterWrapper(_character.toEscapedModel());
	}

	@Override
	public String toString() {
		return _character.toString();
	}

	@Override
	public Character toUnescapedModel() {
		return new CharacterWrapper(_character.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _character.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CharacterWrapper)) {
			return false;
		}

		CharacterWrapper characterWrapper = (CharacterWrapper)obj;

		if (Objects.equals(_character, characterWrapper._character)) {
			return true;
		}

		return false;
	}

	@Override
	public Character getWrappedModel() {
		return _character;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _character.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _character.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_character.resetOriginalValues();
	}

	private final Character _character;
}