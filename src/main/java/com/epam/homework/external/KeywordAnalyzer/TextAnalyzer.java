package com.epam.homework.external.KeywordAnalyzer;

public interface TextAnalyzer {
    CommentsFilter.Label processText(String text);
}
