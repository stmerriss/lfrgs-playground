package testlangportlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import testlangportlet.constants.TestLangPortletKeys;


import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.test",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.display-name=TestLang",
		"javax.portlet.name=" + TestLangPortletKeys.TestLang,
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TestLangPortlet extends MVCPortlet {
}