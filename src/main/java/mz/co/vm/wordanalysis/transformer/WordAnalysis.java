package mz.co.vm.wordanalysis.transformer;

public class WordAnalysis {
    // Define a DTO for your input
    public static class WordAnalysisRequestPayload {
        public String word;
    }

    // Define a DTO for your output
    public static class WordAnalysisResponsePayload {
        public int wordCount;
        public int totalCharsWithSpaces;
        public int totalCharsWithoutSpaces;
        public int vowelCount;
        public int consonantCount;
        public String message;

        public WordAnalysisResponsePayload(int wordCount, int totalCharsWithSpaces, int totalCharsWithoutSpaces,
                int vowelCount, int consonantCount, String message) {
            this.wordCount = wordCount;
            this.totalCharsWithSpaces = totalCharsWithSpaces;
            this.totalCharsWithoutSpaces = totalCharsWithoutSpaces;
            this.vowelCount = vowelCount;
            this.consonantCount = consonantCount;
            this.message = message;
        }
    }
}
