package com.lfrgs.search;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Shane Merriss
 */
public abstract class SearchService implements Search{

	protected List<Document> doSearch(SearchContext searchContext, BooleanQuery searchQuery) {
		Hits hits = null;

		try {
			hits = IndexSearcherHelperUtil.search(searchContext, searchQuery);
		}
		catch (SearchException se) {
			_log.error(se);
		}

		if (Objects.isNull(hits)) {
			return new ArrayList<>();
		}

		return hits.toList();
	}

	protected long getSearchCount(SearchContext searchContext, BooleanQuery searchQuery) {
		long count = 0;

		try {
			count = IndexSearcherHelperUtil.searchCount(searchContext, searchQuery);
		}
		catch (SearchException se) {
			_log.error(se);
		}

		return count;
	}

	private Log _log = LogFactoryUtil.getLog(SearchService.class);
}
