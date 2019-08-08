package com.epam.homework.external.KeywordAnalyzer;

import com.epam.homework.external.KeywordAnalyzer.Filters.NegativeTextAnalyzer;
import com.epam.homework.external.KeywordAnalyzer.Filters.SpamAnalyzer;
import com.epam.homework.external.KeywordAnalyzer.Filters.TooLongTextAnalyzer;

public class SystemFilteringComments {
    TextAnalyzer[] textAnalyzers;
    private String[] spamKeywords;
    private int commentMaxLength;
    private String comment;

    public SystemFilteringComments(String[] spamKeywords, int commentMaxLength, String comment) {
        if (spamKeywords == null || comment == null) {
            throw new IllegalArgumentException("The argument cannot be null");
        }
        if (commentMaxLength <= 0) {
            throw new IllegalArgumentException("The argument cannot be less than or equal to zero");
        }
        this.spamKeywords = spamKeywords.clone();
        this.commentMaxLength = commentMaxLength;
        this.comment = comment;

        this.textAnalyzers = new TextAnalyzer[]{
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
    }

    public CommentsFilter.Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer a : analyzers) {
            if (a.processText(text) != CommentsFilter.Label.OK) {
                return a.processText(text);
            }
        }
        return CommentsFilter.Label.OK;
    }
}















