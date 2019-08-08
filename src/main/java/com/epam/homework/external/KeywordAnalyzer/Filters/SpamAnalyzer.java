package com.epam.homework.external.KeywordAnalyzer.Filters;

import com.epam.homework.external.KeywordAnalyzer.CommentsFilter;
import com.epam.homework.external.KeywordAnalyzer.KeywordAnalyzer;

public class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;

    public SpamAnalyzer(String[] input) {
        this.keywords = input;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected CommentsFilter.Label getLabel() {
        return CommentsFilter.Label.SPAM;
    }
}
