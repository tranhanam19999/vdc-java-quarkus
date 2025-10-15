package mz.co.vm.wordanalysis.infrastructure.inbound.rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mz.co.vm.wordanalysis.transformer.WordAnalysis.WordAnalysisRequestPayload;
import mz.co.vm.wordanalysis.transformer.WordAnalysis.WordAnalysisResponsePayload;
import static mz.co.vm.wordanalysis.util.WordAnalysis.isVowel;

@Path("/")
public class WordAnalysis {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response analyzeText(WordAnalysisRequestPayload input) {
         if (input == null || input.word == null || input.word.isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new WordAnalysisResponsePayload(
                            0, 0, 0, 0, 0, "Input text is missing"))
                    .build();
        }

        String text = input.word;

        // Word count: split on whitespace after trimming; empty -> 0
        String trimmed = text.trim();
        int wordCount = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;

        // Total characters including spaces
        int totalCharsWithSpaces = text.length();

        // Total characters excluding spaces (only remove regular space ' ')
        // If you prefer removing all whitespace (tabs/newlines), use text.replaceAll("\\s+", "")
        int totalCharsWithoutSpaces = text.replace(" ", "").length();

        // Vowel and consonant counts
        int vowelCount = 0;
        int consonantCount = 0;
        String lower = text.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (Character.isLetter(c)) {
                if (isVowel(c)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        WordAnalysisResponsePayload resp = new WordAnalysisResponsePayload(
                wordCount,
                totalCharsWithSpaces,
                totalCharsWithoutSpaces,
                vowelCount,
                consonantCount,
                "Text analyzed successfully"
        );

        return Response.ok(resp).build();
    }
}
