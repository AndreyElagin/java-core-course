package com.epam.homework.external.KeywordAnalyzer.Filters;

import com.epam.homework.external.KeywordAnalyzer.Label;
import com.epam.homework.external.KeywordAnalyzer.TextAnalyzer;

public class TooLongTextAnalyzer implements TextAnalyzer {
    private final int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        if (maxLength <= 0) {
            throw new IllegalArgumentException("The maximum comment length cannot be less than or equal to zero");
        }
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength) {
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
}
