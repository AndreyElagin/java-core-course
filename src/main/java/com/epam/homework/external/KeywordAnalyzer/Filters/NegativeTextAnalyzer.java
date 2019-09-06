package com.epam.homework.external.KeywordAnalyzer.Filters;

import com.epam.homework.external.KeywordAnalyzer.Label;
import com.epam.homework.external.KeywordAnalyzer.KeywordAnalyzer;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private static final String[] keywords = {":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
