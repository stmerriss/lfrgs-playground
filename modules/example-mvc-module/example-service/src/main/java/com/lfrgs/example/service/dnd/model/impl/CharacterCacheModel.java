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

package com.lfrgs.example.service.dnd.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.lfrgs.example.service.dnd.model.Character;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Character in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Character
 * @generated
 */
@ProviderType
public class CharacterCacheModel implements CacheModel<Character>,
	Externalizable, MVCCModel {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CharacterCacheModel)) {
			return false;
		}

		CharacterCacheModel characterCacheModel = (CharacterCacheModel)obj;

		if ((characterId == characterCacheModel.characterId) &&
				(mvccVersion == characterCacheModel.mvccVersion)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, characterId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", characterId=");
		sb.append(characterId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", level=");
		sb.append(level);
		sb.append(", race=");
		sb.append(race);
		sb.append(", characterClass=");
		sb.append(characterClass);
		sb.append(", characterName=");
		sb.append(characterName);
		sb.append(", strength=");
		sb.append(strength);
		sb.append(", dexterity=");
		sb.append(dexterity);
		sb.append(", constitution=");
		sb.append(constitution);
		sb.append(", intelligence=");
		sb.append(intelligence);
		sb.append(", wisdom=");
		sb.append(wisdom);
		sb.append(", charisma=");
		sb.append(charisma);
		sb.append(", speed=");
		sb.append(speed);
		sb.append(", hp=");
		sb.append(hp);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Character toEntityModel() {
		CharacterImpl characterImpl = new CharacterImpl();

		characterImpl.setMvccVersion(mvccVersion);
		characterImpl.setCharacterId(characterId);
		characterImpl.setGroupId(groupId);
		characterImpl.setCompanyId(companyId);
		characterImpl.setUserId(userId);

		if (userName == null) {
			characterImpl.setUserName("");
		}
		else {
			characterImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			characterImpl.setCreateDate(null);
		}
		else {
			characterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			characterImpl.setModifiedDate(null);
		}
		else {
			characterImpl.setModifiedDate(new Date(modifiedDate));
		}

		characterImpl.setLevel(level);

		if (race == null) {
			characterImpl.setRace("");
		}
		else {
			characterImpl.setRace(race);
		}

		if (characterClass == null) {
			characterImpl.setCharacterClass("");
		}
		else {
			characterImpl.setCharacterClass(characterClass);
		}

		if (characterName == null) {
			characterImpl.setCharacterName("");
		}
		else {
			characterImpl.setCharacterName(characterName);
		}

		characterImpl.setStrength(strength);
		characterImpl.setDexterity(dexterity);
		characterImpl.setConstitution(constitution);
		characterImpl.setIntelligence(intelligence);
		characterImpl.setWisdom(wisdom);
		characterImpl.setCharisma(charisma);
		characterImpl.setSpeed(speed);
		characterImpl.setHp(hp);

		characterImpl.resetOriginalValues();

		return characterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		characterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		level = objectInput.readInt();
		race = objectInput.readUTF();
		characterClass = objectInput.readUTF();
		characterName = objectInput.readUTF();

		strength = objectInput.readInt();

		dexterity = objectInput.readInt();

		constitution = objectInput.readInt();

		intelligence = objectInput.readInt();

		wisdom = objectInput.readInt();

		charisma = objectInput.readInt();

		speed = objectInput.readInt();

		hp = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(characterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(level);

		if (race == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(race);
		}

		if (characterClass == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(characterClass);
		}

		if (characterName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(characterName);
		}

		objectOutput.writeInt(strength);

		objectOutput.writeInt(dexterity);

		objectOutput.writeInt(constitution);

		objectOutput.writeInt(intelligence);

		objectOutput.writeInt(wisdom);

		objectOutput.writeInt(charisma);

		objectOutput.writeInt(speed);

		objectOutput.writeInt(hp);
	}

	public long mvccVersion;
	public long characterId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int level;
	public String race;
	public String characterClass;
	public String characterName;
	public int strength;
	public int dexterity;
	public int constitution;
	public int intelligence;
	public int wisdom;
	public int charisma;
	public int speed;
	public int hp;
}