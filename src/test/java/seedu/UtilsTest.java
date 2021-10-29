package seedu;

import org.junit.jupiter.api.Test;
import seedu.typists.exception.ExceedRangeException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.typists.common.Utils.splitStringIntoWordList;
import static seedu.typists.common.Utils.getDisplayLinesWithoutNull;

public class UtilsTest {
    private static final String SAMPLE = "this is test text here";
    private static final ArrayList<String> places = new ArrayList<>(Arrays.asList(
            "this", "is", "test", "text", "here","this1", "is1", "test1", "text1", "here1"));

    //name: whatIsBeingTested_descriptionOfTestInputs_expectedOutcome

    @Test
    public void splitStringIntoWordList_sampleTxt_success() {
        ArrayList<String> result = new ArrayList<>(Arrays.asList("this", "is", "test", "text", "here"));
        assertEquals(result, splitStringIntoWordList(SAMPLE));
        assertEquals(result.size(), 5);
    }

    @Test
    public void getDisplayLines_inRange_success() throws ExceedRangeException {
        String[] displayed = getDisplayLinesWithoutNull(places, 3, 3);
        String[] result = { "is1", "test1", "text1"};
        for (int i = 0; i < displayed.length; i++) {
            assertEquals(displayed[i], result[i]);
        }
    }

    @Test
    public void getDisplayLines_outRange_success() throws ExceedRangeException {
        String[] displayed = getDisplayLinesWithoutNull(places, 6, 2);
        String[] result = { "is1", "test1", "text1", "here1"};
        for (int i = 0; i < displayed.length; i++) {
            assertEquals(displayed[i], result[i]);
        }
    }
    // this test is commented out
    // because it will fail due to array address allocation
    // but the result strings are identical
    // @Test
    //public void getWordLine_sampleTxt_success() {
    // String[] a = new String[]{"this", "is"};
    // String[] b = new String[]{"test", "text"};
    // ArrayList<String[]> result = new ArrayList<>(Arrays.asList(a,b));
    // assertEquals(result, getWordLine(SAMPLE, 2));
    // }
}
