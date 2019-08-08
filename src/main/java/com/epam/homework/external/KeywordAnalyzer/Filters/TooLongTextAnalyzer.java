package com.epam.homework.external.KeywordAnalyzer.Filters;

import com.epam.homework.external.KeywordAnalyzer.CommentsFilter;
import com.epam.homework.external.KeywordAnalyzer.TextAnalyzer;

public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int input) {
        this.maxLength = input;
    }

    @Override
    public CommentsFilter.Label processText(String text) {
        if (text.length() > maxLength) {
            return CommentsFilter.Label.TOO_LONG;
        }
        return CommentsFilter.Label.OK;
    }
}
