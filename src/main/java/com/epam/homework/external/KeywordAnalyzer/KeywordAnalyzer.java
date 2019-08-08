package com.epam.homework.external.KeywordAnalyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();
    protected abstract CommentsFilter.Label getLabel();

    @Override
    public CommentsFilter.Label processText(String text) {
        for (int i = 0; i < getKeywords().length; i++) {
            if (text.contains(getKeywords()[i])) {
                return getLabel();
            }
        }
        return CommentsFilter.Label.OK;
    }
}
