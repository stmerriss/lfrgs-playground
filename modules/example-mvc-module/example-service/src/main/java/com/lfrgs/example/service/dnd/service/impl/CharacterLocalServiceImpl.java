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

package com.lfrgs.example.service.dnd.service.impl;

import com.lfrgs.example.service.dnd.builder.CharacterBuilder;
import com.lfrgs.example.service.dnd.model.Character;
import com.lfrgs.example.service.dnd.service.base.CharacterLocalServiceBaseImpl;

/**
 * The implementation of the character local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lfrgs.example.service.dnd.service.CharacterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CharacterLocalServiceBaseImpl
 * @see com.lfrgs.example.service.dnd.service.CharacterLocalServiceUtil
 */
public class CharacterLocalServiceImpl extends CharacterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.lfrgs.example.service.dnd.service.CharacterLocalServiceUtil} to access the character local service.
	 */

	public Character addCharacter(CharacterBuilder builder) {
		long characterId = counterLocalService.increment();

		Character character = createCharacter(characterId);

		character.setCompanyId(builder.getCompanyId());
		character.setGroupId(builder.getGroupId());
		character.setUserId(builder.getUserId());

		character.setCharacterClass(builder.getCharacterClass());
		character.setLevel(builder.getLevel());
		character.setRace(builder.getRace());
		character.setCharacterName(builder.getCharacterName());
		character.setStrength(builder.getStrength());
		character.setDexterity(builder.getDexterity());
		character.setConstitution(builder.getConstitution());
		character.setIntelligence(builder.getIntelligence());
		character.setWisdom(builder.getWisdom());
		character.setCharisma(builder.getCharisma());
		character.setSpeed(builder.getSpeed());
		character.setHp(builder.getHP());

		return addCharacter(character);
	}
}