package com.lfrgs.example.service.dnd.builder;

import com.lfrgs.example.service.dnd.model.Character;
import com.lfrgs.example.service.dnd.service.CharacterLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * @author Shane Merriss
 */
public class CharacterBuilder {

	public CharacterBuilder(ServiceContext serviceContext) {

		_companyId = serviceContext.getCompanyId();
		_userId = serviceContext.getUserId();
		_groupId = serviceContext.getScopeGroupId();

		_characterClass = "";
		_characterName = "";
		_race = "";
		_level = 1;
		_strength = 10;
		_dexterity = 10;
		_constitution = 10;
		_intelligence = 10;
		_wisdom = 10;
		_charisma = 10;
		_speed = 30;
		_hp = 1;
	}

	public Character build() {
		return CharacterLocalServiceUtil.addCharacter(this);
	}

	public int getLevel() {
		return _level;
	}

	public CharacterBuilder setLevel(int level) {
		_level = level;

		return this;
	}

	public String getRace() {
		return _race;
	}

	public CharacterBuilder setRace(String race) {
		_race = race;

		return this;
	}

	public int getCharisma() {
		return _charisma;
	}

	public CharacterBuilder setCharisma(int charisma) {
		_charisma = charisma;

		return this;
	}

	public int getWisdom() {
		return _wisdom;
	}

	public CharacterBuilder setWisdom(int wisdom) {
		_wisdom = wisdom;

		return this;
	}

	public int getIntelligence() {
		return _intelligence;
	}

	public CharacterBuilder setIntelligence(int intelligence) {
		_intelligence = intelligence;

		return this;
	}

	public int getConstitution() {
		return _constitution;
	}

	public CharacterBuilder setConstitution(int constitution) {
		_constitution = constitution;

		return this;
	}

	public int getDexterity() {
		return _dexterity;
	}

	public CharacterBuilder setDexterity(int dexterity) {
		_dexterity = dexterity;

		return this;
	}

	public int getStrength() {
		return _strength;
	}

	public CharacterBuilder setStrength(int strength) {
		_strength = strength;

		return this;
	}

	public String getCharacterName() {
		return _characterName;
	}

	public CharacterBuilder setCharacterName(String characterName) {
		_characterName = characterName;

		return this;
	}

	public String getCharacterClass() {
		return _characterClass;
	}

	public CharacterBuilder setCharacterClass(String characterClass) {
		_characterClass = characterClass;

		return this;
	}

	public int getSpeed() {
		return _speed;
	}

	public CharacterBuilder setSpeed(int speed) {
		_speed = speed;

		return this;
	}

	public int getHP() {
		return _hp;
	}

	public CharacterBuilder setHP(int hp) {
		_hp = hp;

		return this;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public CharacterBuilder getThis() {
		return this;
	}

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

	private long _groupId;
	private long _companyId;
	private long _userId;
}
