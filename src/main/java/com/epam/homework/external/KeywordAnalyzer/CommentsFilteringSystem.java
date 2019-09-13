package com.epam.homework.external.KeywordAnalyzer;

class CommentsFilteringSystem {
    final TextAnalyzer[] textAnalyzers;

    CommentsFilteringSystem(TextAnalyzer[] analyzers) {
        textAnalyzers = analyzers;
    }

    public Label checkLabels(String text) {
        if (text == null) {
            throw new IllegalArgumentException("The analyzed comment cannot be null");
        }

        for (TextAnalyzer a : textAnalyzers) {
            if (a.processText(text) != Label.OK) {
                return a.processText(text);
            }
        }
        return Label.OK;
    }
}
