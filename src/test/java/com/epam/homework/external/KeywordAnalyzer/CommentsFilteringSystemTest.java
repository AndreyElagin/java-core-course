package com.epam.homework.external.KeywordAnalyzer;

import com.epam.homework.external.KeywordAnalyzer.Filters.NegativeTextAnalyzer;
import com.epam.homework.external.KeywordAnalyzer.Filters.SpamAnalyzer;
import com.epam.homework.external.KeywordAnalyzer.Filters.TooLongTextAnalyzer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class CommentsFilteringSystemTest {
    private CommentsFilteringSystem initFilteringSystem(String[] spamKeywords, int commentMaxLength) {
        if (spamKeywords == null) {
            throw new IllegalArgumentException("An array of spam words cannot be null");
        }
        if (commentMaxLength <= 0) {
            throw new IllegalArgumentException("The maximum comment length cannot be less than or equal to zero");
        }

        return new CommentsFilteringSystem(
                new TextAnalyzer[]{
                        new SpamAnalyzer(spamKeywords),
                        new NegativeTextAnalyzer(),
                        new TooLongTextAnalyzer(commentMaxLength)
                }
        );
    }

    @Test
    @DisplayName("If the comment contains spam keywords, then the program should return a SPAM label")
    void spam() {
        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 40;
        String comment = "This spam";

        CommentsFilteringSystem test = initFilteringSystem(spamKeywords, commentMaxLength);
        Label result = test.checkLabels(test.textAnalyzers, comment);
        assertEquals(result, Label.SPAM);
    }

    @Test
    @DisplayName("If the comment contains sad smile, then the program should return a NEGATIVE_TEXT label")
    void negative() {
        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 40;
        String comment = "Bad table :(";

        CommentsFilteringSystem test = initFilteringSystem(spamKeywords, commentMaxLength);
        Label result = test.checkLabels(test.textAnalyzers, comment);
        assertEquals(result, Label.NEGATIVE_TEXT);
    }

    @Test
    @DisplayName("If the comment is longer than commentMaxLength, then the program should return a TOO_LONG label")
    void tooLong() {
        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 40;
        String comment = "Looooooooong ccccooooommmmmmmeeeeeeeennnnnnnt";

        CommentsFilteringSystem test = initFilteringSystem(spamKeywords, commentMaxLength);
        Label result = test.checkLabels(test.textAnalyzers, comment);
        assertEquals(result, Label.TOO_LONG);
    }

    @Test
    @DisplayName("If the comment does not contain spam or sad smile, and if it is no longer than commentMaxLength, " +
            "then the program should return OK label")
    void good() {
        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 40;
        String comment = "Good comment";

        CommentsFilteringSystem test = initFilteringSystem(spamKeywords, commentMaxLength);
        Label result = test.checkLabels(test.textAnalyzers, comment);
        assertEquals(result, Label.OK);
    }

    @Test
    @DisplayName("Should throw an IllegalArgumentException if spamKeywords is null")
    void IAEofSpamKeywordsNull() {
        String[] spamKeywords = null;
        int commentMaxLength = 40;

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            initFilteringSystem(spamKeywords, commentMaxLength);
            ;
        });
        assertEquals("An array of spam words cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw an IllegalArgumentException if commentMaxLength is less than or equal to zero")
    void IAEofCommentMaxLengthZero() {
        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 0;

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            initFilteringSystem(spamKeywords, commentMaxLength);
        });
        assertEquals("The maximum comment length cannot be less than or equal to zero", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw an exception IllegalArgumentException, if analyzed comment is null")
    void IAEofCommentZero() {
        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 40;
        String comment = null;

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            CommentsFilteringSystem test = initFilteringSystem(spamKeywords, commentMaxLength);
            Label result = test.checkLabels(test.textAnalyzers, comment);
        });
        assertEquals("The analyzed comment cannot be null", exception.getMessage());
    }
}
