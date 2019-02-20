package com.lfrgs.language.bundle;

import com.liferay.portal.kernel.language.UTF8Control;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {"language.id=en_US"},
	service = ResourceBundle.class
)

public class EnglishUSResourceBundle extends ResourceBundle {

	@Override
	public Enumeration<String> getKeys() {
		return _resourceBundle.getKeys();
	}

	@Override
	protected Object handleGetObject(String key) {
		return _resourceBundle.getObject(key);
	}

	private final ResourceBundle _resourceBundle = ResourceBundle.getBundle(
		"content.Language_en_US", UTF8Control.INSTANCE);

}