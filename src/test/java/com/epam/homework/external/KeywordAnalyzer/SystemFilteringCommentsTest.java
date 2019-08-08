package com.epam.homework.external.KeywordAnalyzer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemFilteringCommentsTest {
    @Test
    @DisplayName("If the comment contains spam keywords, it should return a SPAM label")
    void spam() {
        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 40;
        String comment = "This spam";

        SystemFilteringComments test = new SystemFilteringComments(spamKeywords, commentMaxLength, comment);
        CommentsFilter.Label result = test.checkLabels(test.textAnalyzers, comment);
        assertEquals(result, CommentsFilter.Label.SPAM);
    }

    @Test
    @DisplayName("If the comment contains sad smile, it should return a NEGATIVE_TEXT label")
    void negative() {
        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 40;
        String comment = "Bad table :(";

        SystemFilteringComments test = new SystemFilteringComments(spamKeywords, commentMaxLength, comment);
        CommentsFilter.Label result = test.checkLabels(test.textAnalyzers, comment);
        assertEquals(result, CommentsFilter.Label.NEGATIVE_TEXT);
    }

    @Test
    @DisplayName("If the comment is longer than than commentMaxLength, it should return a TOO_LONG label")
    void tooLong() {
        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 40;
        String comment = "Looooooooong ccccooooommmmmmmeeeeeeeennnnnnnt";

        SystemFilteringComments test = new SystemFilteringComments(spamKeywords, commentMaxLength, comment);
        CommentsFilter.Label result = test.checkLabels(test.textAnalyzers, comment);
        assertEquals(result, CommentsFilter.Label.TOO_LONG);
    }

    @Test
    @DisplayName("If the comment does not contain spam or sad smile, and if it is no longer than commentMaxLength should return OK label")
    void good() {
        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 40;
        String testString = "Good comment";

        SystemFilteringComments test = new SystemFilteringComments(spamKeywords, commentMaxLength, testString);
        CommentsFilter.Label result = test.checkLabels(test.textAnalyzers, testString);
        assertEquals(result, CommentsFilter.Label.OK);
    }

    @Test
    @DisplayName("Should throw an IAE if first or third argument is null")
    void IAEofArgNull() {
        String[] spamKeywords = null;
        int commentMaxLength = 40;
        String testString = "Good comment";

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new SystemFilteringComments(spamKeywords, commentMaxLength, testString);;
        });
        assertEquals("The argument cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw an IAE if second argument is less than or equal to zero")
    void IAEofArgZero() {
        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 0;
        String testString = "Good comment";

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new SystemFilteringComments(spamKeywords, commentMaxLength, testString);;
        });
        assertEquals("The argument cannot be less than or equal to zero", exception.getMessage());
    }
}