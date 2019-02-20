package com.lfrgs.search.context;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.search.query.FieldQueryFactoryUtil;

import java.util.Objects;

public class SearchQueryBuilder {

	public SearchQueryBuilder(String className) {
		_searchQuery = new BooleanQueryImpl();

		BooleanFilter typeFilter = new BooleanFilter();

		typeFilter.addRequiredTerm(Field.ENTRY_CLASS_NAME, className);

		_searchQuery.setPreBooleanFilter(typeFilter);
	}

	public void addMultipleFields(String keywords, String... fields) {
		BooleanQuery keywordsQuery = new BooleanQueryImpl();

		for (String field : fields) {
			Query query = FieldQueryFactoryUtil.createQuery(field, keywords, false, false);

			try {
				keywordsQuery.add(query, BooleanClauseOccur.SHOULD);
			}
			catch (ParseException pe) {
				_log.error("Cannot add query to keywordsQuery: " + query);
			}
		}

		addQuery(keywordsQuery, BooleanClauseOccur.SHOULD);
	}

	public void addMultipleFilterValues(String field, String... values) {
		BooleanFilter filter = new BooleanFilter();

		for (String value : values) {
			filter.addTerm(field, value, BooleanClauseOccur.SHOULD);
		}

		addPostFilter(filter);
	}

	public void addPostFilter(String field, String value, BooleanClauseOccur booleanClauseOccur) {
		BooleanFilter filter = new BooleanFilter();

		Filter postFilter = _searchQuery.getPostFilter();

		if (!Objects.isNull(postFilter)) {
			filter.add(postFilter, BooleanClauseOccur.MUST);
		}

		filter.addTerm(field, value, booleanClauseOccur);

		setPostFilter(filter);
	}

	public void addPostFilter(BooleanFilter booleanFilter) {
		BooleanFilter filter = new BooleanFilter();
		Filter postFilter = _searchQuery.getPostFilter();

		if (!Objects.isNull(postFilter)) {
			filter.add(postFilter, BooleanClauseOccur.MUST);
		}

		filter.add(booleanFilter, BooleanClauseOccur.MUST);

		setPostFilter(filter);
	}

	public void addQuery(Query query, BooleanClauseOccur booleanClauseOccur) {
		try {
			_searchQuery.add(query, booleanClauseOccur);
		}
		catch (ParseException pe) {
			_log.error("Unable to add query: " + query);
		}
	}

	public void setPostFilter(BooleanFilter filter) {
		_searchQuery.setPostFilter(filter);
	}

	public void addTerm(
		String field, String value, boolean like, boolean parseKeywords, BooleanClauseOccur booleanClauseOccur) {

		Query query = FieldQueryFactoryUtil.createQuery(field, value, like, parseKeywords);

		addQuery(query, booleanClauseOccur);
	}

	protected void setSearchQuery(BooleanQuery searchQuery) {
		_searchQuery = searchQuery;
	}

	public BooleanQuery getSearchQuery() {
		return _searchQuery;
	}

	public void addMultipleValues(String field, BooleanClauseOccur booleanClauseOccur, String... values) {
		BooleanQuery booleanQuery = new BooleanQueryImpl();

		for (String value : values) {
			Query query = FieldQueryFactoryUtil.createQuery(field, value, false, false);

			try {
				booleanQuery.add(query, booleanClauseOccur);
			}
			catch (ParseException e) {
				_log.error("Unable to add query: " + query);
			}
		}

		addQuery(booleanQuery, BooleanClauseOccur.MUST);
	}

	protected BooleanQuery _searchQuery;

	private Log _log = LogFactoryUtil.getLog(SearchQueryBuilder.class);
}