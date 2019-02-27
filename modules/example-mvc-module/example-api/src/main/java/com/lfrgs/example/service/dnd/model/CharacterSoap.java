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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CharacterSoap implements Serializable {
	public static CharacterSoap toSoapModel(Character model) {
		CharacterSoap soapModel = new CharacterSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setCharacterId(model.getCharacterId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLevel(model.getLevel());
		soapModel.setRace(model.getRace());
		soapModel.setCharacterClass(model.getCharacterClass());
		soapModel.setCharacterName(model.getCharacterName());
		soapModel.setStrength(model.getStrength());
		soapModel.setDexterity(model.getDexterity());
		soapModel.setConstitution(model.getConstitution());
		soapModel.setIntelligence(model.getIntelligence());
		soapModel.setWisdom(model.getWisdom());
		soapModel.setCharisma(model.getCharisma());
		soapModel.setSpeed(model.getSpeed());
		soapModel.setHp(model.getHp());

		return soapModel;
	}

	public static CharacterSoap[] toSoapModels(Character[] models) {
		CharacterSoap[] soapModels = new CharacterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CharacterSoap[][] toSoapModels(Character[][] models) {
		CharacterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CharacterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CharacterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CharacterSoap[] toSoapModels(List<Character> models) {
		List<CharacterSoap> soapModels = new ArrayList<CharacterSoap>(models.size());

		for (Character model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CharacterSoap[soapModels.size()]);
	}

	public CharacterSoap() {
	}

	public long getPrimaryKey() {
		return _characterId;
	}

	public void setPrimaryKey(long pk) {
		setCharacterId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public long getCharacterId() {
		return _characterId;
	}

	public void setCharacterId(long characterId) {
		_characterId = characterId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getLevel() {
		return _level;
	}

	public void setLevel(int level) {
		_level = level;
	}

	public String getRace() {
		return _race;
	}

	public void setRace(String race) {
		_race = race;
	}

	public String getCharacterClass() {
		return _characterClass;
	}

	public void setCharacterClass(String characterClass) {
		_characterClass = characterClass;
	}

	public String getCharacterName() {
		return _characterName;
	}

	public void setCharacterName(String characterName) {
		_characterName = characterName;
	}

	public int getStrength() {
		return _strength;
	}

	public void setStrength(int strength) {
		_strength = strength;
	}

	public int getDexterity() {
		return _dexterity;
	}

	public void setDexterity(int dexterity) {
		_dexterity = dexterity;
	}

	public int getConstitution() {
		return _constitution;
	}

	public void setConstitution(int constitution) {
		_constitution = constitution;
	}

	public int getIntelligence() {
		return _intelligence;
	}

	public void setIntelligence(int intelligence) {
		_intelligence = intelligence;
	}

	public int getWisdom() {
		return _wisdom;
	}

	public void setWisdom(int wisdom) {
		_wisdom = wisdom;
	}

	public int getCharisma() {
		return _charisma;
	}

	public void setCharisma(int charisma) {
		_charisma = charisma;
	}

	public int getSpeed() {
		return _speed;
	}

	public void setSpeed(int speed) {
		_speed = speed;
	}

	public int getHp() {
		return _hp;
	}

	public void setHp(int hp) {
		_hp = hp;
	}

	private long _mvccVersion;
	private long _characterId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _level;
	private String _race;
	private String _characterClass;
	private String _characterName;
	private int _strength;
	private int _dexterity;
	private int _constitution;
	private int _intelligence;
	private int _wisdom;
	private int _charisma;
	private int _speed;
	private int _hp;
}