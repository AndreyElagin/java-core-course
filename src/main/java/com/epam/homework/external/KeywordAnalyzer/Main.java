package com.epam.homework.external.KeywordAnalyzer;

public class Main {
    public static void main(String[] args) {

        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 40;
        String s = "This spam";

        TextAnalyzer[] textAnalyzers = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        System.out.println(checkLabels(textAnalyzers, s));
    }


    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK;
    }

    interface TextAnalyzer {
        Label processText(String text);
    }

    abstract class KeywordAnalyzer implements TextAnalyzer {
        protected abstract String[] getKeywords();

        protected abstract Label getLabel();

        @Override
        public Label processText(String text) {
            for (int i = 0; i < getKeywords().length; i++) {
                if (text.contains(getKeywords()[i])) {
                    return getLabel();
                }
            }
            return Label.OK;
        }
    }

    static class SpamAnalyzer extends KeywordAnalyzer {
        private String[] keywords;

        public SpamAnalyzer(String[] input) {
            this.keywords = input;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }

    static class NegativeTextAnalyzer extends KeywordAnalyzer {
        private String[] keywords = {":(", "=(", ":|"};

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    static class TooLongTextAnalyzer implements TextAnalyzer {
        private int maxLength;

        public TooLongTextAnalyzer(int input) {
            this.maxLength = input;
        }

        @Override
        public Label processText(String text) {
            if (text.length() > maxLength) {
                return Label.TOO_LONG;
            }
            return Label.OK;
        }

    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            analyzer.processText(text);
        }
        return Label.OK;
    }

}
