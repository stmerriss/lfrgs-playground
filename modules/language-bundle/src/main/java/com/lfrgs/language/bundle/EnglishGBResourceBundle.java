package com.lfrgs.language.bundle;

import com.liferay.portal.kernel.language.UTF8Control;
import org.osgi.service.component.annotations.Component;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

@Component(
	property = {"language.id=en_GB"},
	service = ResourceBundle.class
)

public class EnglishGBResourceBundle extends ResourceBundle {

	@Override
	public Enumeration<String> getKeys() {
		return _resourceBundle.getKeys();
	}

	@Override
	protected Object handleGetObject(String key) {
		return _resourceBundle.getObject(key);
	}

	private final ResourceBundle _resourceBundle = ResourceBundle.getBundle(
		"content.Language_en_GB", UTF8Control.INSTANCE);

}