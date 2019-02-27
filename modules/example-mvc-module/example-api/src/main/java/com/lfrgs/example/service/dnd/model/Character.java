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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Character service. Represents a row in the &quot;DND_Character&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CharacterModel
 * @see com.lfrgs.example.service.dnd.model.impl.CharacterImpl
 * @see com.lfrgs.example.service.dnd.model.impl.CharacterModelImpl
 * @generated
 */
@ImplementationClassName("com.lfrgs.example.service.dnd.model.impl.CharacterImpl")
@ProviderType
public interface Character extends CharacterModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.lfrgs.example.service.dnd.model.impl.CharacterImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Character, Long> CHARACTER_ID_ACCESSOR = new Accessor<Character, Long>() {
			@Override
			public Long get(Character character) {
				return character.getCharacterId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Character> getTypeClass() {
				return Character.class;
			}
		};
}