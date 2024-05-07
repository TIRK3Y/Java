
//Split the paragraph into different sentences and identify which sectence is lengthy one in java?
import java.text.BreakIterator;

public class Main {
    public static void main(String[] args) {
        String content = "This is a long string with some numbers 123.456,78 or 100.000 and e.g. some abbreviations in it, which shouldn't split the sentence. Sometimes there are problems, i.e. in this one. here and abbr at the end x.y.. cool.";

        BreakIterator bi = BreakIterator.getSentenceInstance();
        bi.setText(content);

        int index = 0;
        int maxLength = Integer.MIN_VALUE;
        String longestSentence = "";

        while (bi.next() != BreakIterator.DONE) {
            String sentence = content.substring(index, bi.current());
            System.out.println(sentence);
            if (sentence.length() > maxLength) {
                maxLength = sentence.length();
                longestSentence = sentence;
            }
            index = bi.current();
        }

        System.out.println("\nLongest Sentence:");
        System.out.println(longestSentence);
        System.out.println("Length: " + maxLength);
    }
}
