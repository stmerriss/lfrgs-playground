<%@ include file="init.jsp" %>

<%= themeDisplay.getLocale() %>
<br>
<%= themeDisplay.getSiteDefaultLocale() %>
<br>
<table>
	<tr>
		<th>Target Locale</th>
		<th>actual locale</th>
	</tr>
	<tr>
		<td>liferay-ui:message</td>
		<td><liferay-ui:message key="test-message" /></td>
	</tr>
	<tr>
		<td>themedisplay.getLocale()</td>
		<td><%= LanguageUtil.get(themeDisplay.getLocale(), "test-message") %></td>
	</tr>
	<tr>
		<td>themedisplay.getSiteDefaultLocale()</td>
		<td><%= LanguageUtil.get(themeDisplay.getSiteDefaultLocale(), "test-message") %></td>
	</tr>
	<tr>
		<td>en</td>
		<td><%= LanguageUtil.get(new Locale("en", ""), "test-message") %></td>
	</tr>
	<tr>
		<td>en_US</td>
		<td><%= LanguageUtil.get(new Locale("en", "US"), "test-message") %></td>
	</tr>
	<tr>
		<td>en_GB</td>
		<td><%= LanguageUtil.get(new Locale("en", "GB"), "test-message") %></td>
	</tr>
	<tr>
		<td>ru</td>
		<td><%= LanguageUtil.get(new Locale("ru", ""), "test-message") %></td>
	</tr>
	<tr>
		<td>ru_RU</td>
		<td><%= LanguageUtil.get(new Locale("ru", "RU"), "test-message") %></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<td>en-only-default</td>
		<td><%= LanguageUtil.get(themeDisplay.getLocale(), "en-only") %></td>
	</tr>
	<tr>
		<td>en-only-sitedefault</td>
		<td><%= LanguageUtil.get(themeDisplay.getSiteDefaultLocale(), "en-only") %></td>
	</tr>
	<tr>
		<td>en-only</td>
		<td><%= LanguageUtil.get(new Locale("en", ""), "en-only") %></td>
	</tr>
	<tr>
		<td>en-only-US</td>
		<td><%= LanguageUtil.get(new Locale("en", "US"), "en-only") %></td>
	</tr>
	<tr>
		<td>en-only-GB</td>
		<td><%= LanguageUtil.get(new Locale("en", "GB"), "en-only") %></td>
	</tr>
</table>




