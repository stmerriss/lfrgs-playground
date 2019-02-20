package com.lfrgs.search.builders;

import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.filter.BooleanFilter;

/**
 * @author Shane Merriss
 */
public class SearchFilterBuilder {

	public SearchFilterBuilder() {
		_searchFilter = new BooleanFilter();
	}

	public SearchFilterBuilder addFilter(String field, String keyword, BooleanClauseOccur booleanClauseOccur) {
		_searchFilter.addTerm(field, keyword, booleanClauseOccur);

		return this;
	}

	public SearchFilterBuilder addFilter(BooleanFilter booleanFilter, BooleanClauseOccur booleanClauseOccur) {
		_searchFilter.add(booleanFilter, booleanClauseOccur);

		return this;
	}

	public SearchFilterBuilder addMultipleValues(String field, String... values) {
		BooleanFilter filter = new BooleanFilter();

		for (String value : values) {
			filter.addTerm(field, value, BooleanClauseOccur.SHOULD);
		}

		_searchFilter.add(filter, BooleanClauseOccur.MUST);

		return this;
	}

	public SearchFilterBuilder addMultipleFields(String keyword, String... fields) {
		BooleanFilter filter = new BooleanFilter();

		for (String field : fields) {
			filter.addTerm(field, keyword, BooleanClauseOccur.SHOULD);
		}

		_searchFilter.add(filter, BooleanClauseOccur.MUST);

		return this;
	}

	public SearchFilterBuilder addMultipleValues(String field, long... values) {
		BooleanFilter filter = new BooleanFilter();

		for (long value : values) {
			filter.addTerm(field, String.valueOf(value), BooleanClauseOccur.SHOULD);
		}

		_searchFilter.add(filter, BooleanClauseOccur.MUST);

		return this;
	}

	public BooleanFilter build() {
		return _searchFilter;
	}

	private BooleanFilter _searchFilter;
}
