package com.epam.homework.external.KeywordAnalyzer.Filters;

import com.epam.homework.external.KeywordAnalyzer.CommentsFilter;
import com.epam.homework.external.KeywordAnalyzer.KeywordAnalyzer;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keywords = {":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected CommentsFilter.Label getLabel() {
        return CommentsFilter.Label.NEGATIVE_TEXT;
    }
}
