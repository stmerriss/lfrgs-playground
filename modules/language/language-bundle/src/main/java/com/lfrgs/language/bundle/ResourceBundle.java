package com.lfrgs.language.bundle;

import com.liferay.portal.kernel.language.UTF8Control;
import org.osgi.service.component.annotations.Component;

import java.util.Enumeration;

@Component(
	property = {"language.id="},
	service = java.util.ResourceBundle.class
)

public class ResourceBundle extends java.util.ResourceBundle {

	@Override
	public Enumeration<String> getKeys() {
		return _resourceBundle.getKeys();
	}

	@Override
	protected Object handleGetObject(String key) {
		return _resourceBundle.getObject(key);
	}

	private final java.util.ResourceBundle _resourceBundle = java.util.ResourceBundle.getBundle(
		"content.Language", UTF8Control.INSTANCE);

}