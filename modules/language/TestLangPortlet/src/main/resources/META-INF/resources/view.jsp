<%@ include file="init.jsp" %>
<table>
	<tr>
		<td>themeDisplay.getLocale</td>
		<td><%= themeDisplay.getLocale() %></td>
	</tr>
	<tr>
		<td>themeDisplay.getSiteDefaultLocale</td>
		<td><%= themeDisplay.getSiteDefaultLocale() %></td>
	</tr>
	<tr>
		<td>Locale.getDefault</td>
		<td><%= Locale.getDefault() %></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<th>Target Locale</th>
		<th>result</th>
	</tr>
	<tr>
		<td>liferay-ui:message</td>
		<td><liferay-ui:message key="test-message" /></td>
	</tr>
	<tr>
		<td>default</td>
		<td><%= LanguageUtil.get(new Locale("", ""), "test-message") %></td>
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
	<tr>
		<td>lv</td>
		<td><%= LanguageUtil.get(new Locale("lv"), "test-message") %></td>
	</tr>
	<tr>
		<td>lv_LV</td>
		<td><%= LanguageUtil.get(new Locale("lv", "LV"), "test-message") %></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<th>lv-only</th>
		<th></th>
	</tr>
	<tr>
		<td>liferay-ui:message</td>
		<td><liferay-ui:message key="lv-only" /></td>
	</tr>
	<tr>
		<td>lv</td>
		<td><%= LanguageUtil.get(new Locale("lv", ""), "lv-only")%></td>
	</tr>
	<tr>
		<td>ru</td>
		<td><%= LanguageUtil.get(new Locale("ru", ""), "lv-only")%></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<th>ru-only</th>
		<th></th>
	</tr>
	<tr>
		<td>liferay-ui:message</td>
		<td><liferay-ui:message key="ru-only" /></td>
	</tr>
	<tr>
		<td>ru</td>
		<td><%= LanguageUtil.get(new Locale("lv", ""), "ru-only")%></td>
	</tr>
	<tr>
		<td>lv</td>
		<td><%= LanguageUtil.get(new Locale("ru"), "ru-only")%></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<th>lv-ru-only</th>
		<th></th>
	</tr>
	<tr>
		<td>liferay-ui:message</td>
		<td><liferay-ui:message key="lv-ru-only" /></td>
	</tr>
	<tr>
		<td>ru</td>
		<td><%= LanguageUtil.get(new Locale("ru"), "lv-ru-only")%></td>
	</tr>
	<tr>
		<td>lv</td>
		<td><%= LanguageUtil.get(new Locale("lv", ""), "lv-ru-only")%></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<th>us-only</th>
		<th></th>
	</tr>
	<tr>
		<td>liferay-ui:message</td>
		<td><liferay-ui:message key="us-only" /></td>
	</tr>
	<tr>
		<td>en</td>
		<td><%= LanguageUtil.get(new Locale("en", ""), "us-only") %></td>
	</tr>
	<tr>
		<td>en_US</td>
		<td><%= LanguageUtil.get(new Locale("en", "US"), "us-only") %></td>
	</tr>
	<tr>
		<td>en_GB</td>
		<td><%= LanguageUtil.get(new Locale("en", "GB"), "us-only") %></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<th>gb-only</th>
		<th></th>
	</tr>
	<tr>
		<td>liferay-ui:message</td>
		<td><liferay-ui:message key="gb-only" /></td>
	</tr>
	<tr>
		<td>en</td>
		<td><%= LanguageUtil.get(new Locale("en", ""), "gb-only") %></td>
	</tr>
	<tr>
		<td>en_US</td>
		<td><%= LanguageUtil.get(new Locale("en", "US"), "gb-only") %></td>
	</tr>
	<tr>
		<td>en_GB</td>
		<td><%= LanguageUtil.get(new Locale("en", "GB"), "gb-only") %></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<th>us-gb-only</th>
		<th></th>
	</tr>
	<tr>
		<td>liferay-ui:message</td>
		<td><liferay-ui:message key="us-gb-only" /></td>
	</tr>
	<tr>
		<td>en</td>
		<td><%= LanguageUtil.get(new Locale("en", ""), "us-gb-only") %></td>
	</tr>
	<tr>
		<td>en_US</td>
		<td><%= LanguageUtil.get(new Locale("en", "US"), "us-gb-only") %></td>
	</tr>
	<tr>
		<td>en_GB</td>
		<td><%= LanguageUtil.get(new Locale("en", "GB"), "us-gb-only") %></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<th>en-only</th>
		<th></th>
	</tr>
	<tr>
		<td>liferay-ui:message</td>
		<td><liferay-ui:message key="en-only" /></td>
	</tr>
	<tr>
		<td>en</td>
		<td><%= LanguageUtil.get(new Locale("en", ""), "en-only") %></td>
	</tr>
	<tr>
		<td>en_US</td>
		<td><%= LanguageUtil.get(new Locale("en", "US"), "en-only") %></td>
	</tr>
	<tr>
		<td>en_GB</td>
		<td><%= LanguageUtil.get(new Locale("en", "GB"), "en-only") %></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<th>us-en-only</th>
		<th></th>
	</tr>
	<tr>
		<td>liferay-ui:message</td>
		<td><liferay-ui:message key="us-en-only" /></td>
	</tr>
	<tr>
		<td>en</td>
		<td><%= LanguageUtil.get(new Locale("en", ""), "us-en-only") %></td>
	</tr>
	<tr>
		<td>en_US</td>
		<td><%= LanguageUtil.get(new Locale("en", "US"), "us-en-only") %></td>
	</tr>
	<tr>
		<td>en_GB</td>
		<td><%= LanguageUtil.get(new Locale("en", "GB"), "us-en-only") %></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<th>gb-en-only</th>
		<th></th>
	</tr>
	<tr>
		<td>liferay-ui:message</td>
		<td><liferay-ui:message key="gb-en-only" /></td>
	</tr>
	<tr>
		<td>en</td>
		<td><%= LanguageUtil.get(new Locale("en", ""), "gb-en-only") %></td>
	</tr>
	<tr>
		<td>en_US</td>
		<td><%= LanguageUtil.get(new Locale("en", "US"), "gb-en-only") %></td>
	</tr>
	<tr>
		<td>en_GB</td>
		<td><%= LanguageUtil.get(new Locale("en", "GB"), "gb-en-only") %></td>
	</tr>
</table>