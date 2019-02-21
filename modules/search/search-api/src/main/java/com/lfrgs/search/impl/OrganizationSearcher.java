package com.lfrgs.search.impl;

import com.lfrgs.search.builders.SearchContextBuilder;
import com.lfrgs.search.builders.SearchFilterBuilder;
import com.lfrgs.search.builders.SearchQueryBuilder;
import com.lfrgs.search.SearchService;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Shane Merriss
 */
@Component(
	immediate = true,
	service = OrganizationSearcher.class
)
public class OrganizationSearcher extends SearchService {

	public OrganizationSearcher(SearchContext searchContext, BooleanQuery searchQuery) {
		_searchContext = searchContext;
		_searchQuery = searchQuery;
	}

	@Override
	public List<Document> search() {
		return doSearch(_searchContext, _searchQuery);
	}

	@Override
	public long searchCount() {
		return getSearchCount(_searchContext, _searchQuery);
	}

	public class Builder {

		public Builder() {
		}

		public Builder addCompanyId(long companyId) {
			_companyId = companyId;

			return this;
		}

		public Builder addKeywords(String keywords) {
			_keywords = keywords;

			return this;
		}

		public Builder addName(String name) {
			_name = name;

			return this;
		}

		public Builder addUserIds(long... organizationIds) {
			_organizationIds = organizationIds;

			return this;
		}

		public Builder addParentOrganizationIds(long... parentOrganizationIds) {
			_parentOrganizationId = parentOrganizationIds;

			return this;
		}

		public Builder addStart(int start) {
			_start = start;

			return this;
		}

		public Builder addEnd(int end) {
			_end = end;

			return this;
		}

		public OrganizationSearcher build() {
			SearchContext searchContext = new SearchContextBuilder()
				.setCompanyId(_companyId)
				.setStart(_start)
				.setEnd(_end)
				.build();

			BooleanFilter searchFilter = new SearchFilterBuilder()
				.addFilter(Field.NAME, _name, BooleanClauseOccur.SHOULD)
				.addMultipleValues(Field.ORGANIZATION_ID, _organizationIds)
				.addMultipleValues("parentOrganizationId", _parentOrganizationId)
				.addMultipleFields(_keywords, Field.NAME, Field.TYPE, Field.COMMENTS, Field.USER_NAME)
				.build();

			BooleanQuery searchQuery = new SearchQueryBuilder(Organization.class)
				.addFilter(searchFilter)
				.build();

			return new OrganizationSearcher(searchContext, searchQuery);
		}

		private long _companyId;
		private String _keywords;
		private String _name;
		private long[] _organizationIds;
		private long[] _parentOrganizationId;
		private int _start;
		private int _end;
	}

	private SearchContext _searchContext;
	private BooleanQuery _searchQuery;
}
