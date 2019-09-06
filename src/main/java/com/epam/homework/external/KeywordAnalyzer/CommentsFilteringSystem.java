package com.epam.homework.external.KeywordAnalyzer;

import com.epam.homework.external.KeywordAnalyzer.Filters.NegativeTextAnalyzer;
import com.epam.homework.external.KeywordAnalyzer.Filters.SpamAnalyzer;
import com.epam.homework.external.KeywordAnalyzer.Filters.TooLongTextAnalyzer;

class CommentsFilteringSystem {
    final TextAnalyzer[] textAnalyzers;

    CommentsFilteringSystem(TextAnalyzer[] analyzers) {
        textAnalyzers = analyzers;
    }

    Label checkLabels(TextAnalyzer[] analyzers, String text) {
        if (text == null) {
            throw new IllegalArgumentException("The analyzed comment cannot be null");
        }

        for (TextAnalyzer a : analyzers) {
            if (a.processText(text) != Label.OK) {
                return a.processText(text);
            }
        }
        return Label.OK;
    }
}
