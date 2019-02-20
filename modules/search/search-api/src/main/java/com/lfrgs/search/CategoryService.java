package com.lfrgs.search;

import com.lfrgs.search.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

/**
 * @author Shane Merriss
 */
public interface CategoryService {

	public List<CategoryDTO> getCategoriesTree(long categoryId);

	public List<CategoryDTO> getVocabulariesTree(long groupId, String vocabularyName);
}
