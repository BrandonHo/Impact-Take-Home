import static org.junit.Assert.assertEquals;

import org.junit.*;

public class NumberRangeSummarizerSolutionTests {
    
    private final NumberRangeSummarizerSolution numberRangeSummarizer = new NumberRangeSummarizerSolution();

    @Test
    public void shouldReturnEmptyResult_whenEmptyNumberStringCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(""));
        assertEquals("", result);
    }

    @Test
    public void shouldReturnSingleNumberResult_whenSingleNumberStringCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect("1"));
        assertEquals("1", result);
    }

    @Test
    public void shouldReturnResult_whenNegativeSortedGeneralCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect("-5,-4,-3,1,4"));
        assertEquals("-5--3, 1, 4", result);
    }

    @Test
    public void shouldReturnResult_whenSortedGeneralCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect("1,2,3,5,8"));
        assertEquals("1-3, 5, 8", result);
    }

    @Test
    public void shouldReturnResult_whenLongSortedGeneralCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31"));
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }

    @Test
    public void shouldReturnResult_whenSortedDuplicateCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect("1,1,2,3,5,8"));
        assertEquals("1-3, 5, 8", result);
    }

    @Test
    public void shouldReturnResult_whenUnsortedGeneralCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect("8,5,1,3,2"));
        assertEquals("1-3, 5, 8", result);
    }

    @Test
    public void shouldReturnResult_whenUnsortedDuplicateGeneralCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect("8,5,1,3,2,1"));
        assertEquals("1-3, 5, 8", result);
    }

    @Test
    public void shouldReturnEmptyResult_whenInvalidInputCharsCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect("1A,2B,3#,5!,8X"));
        assertEquals("", result);
    }

    @Test
    public void shouldReturnEmptyResult_whenInvalidInputDelimiterCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect("1!2!3!5!8"));
        assertEquals("", result);
    }

    @Test
    public void shouldReturnEmptyResult_whenInvalidInputSpacesCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(" , , , , "));
        assertEquals("", result);
    }

    @Test
    public void shouldReturnResult_whenInvalidInputSpacesAndGeneralCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect("1, 2, 3, 5, 8"));
        assertEquals("", result);
    }

    @Test
    public void shouldReturnEmptyResult_whenInvalidInputIntegerOverflowCase()
    {
        String result = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect("5948579837592837,-235983985792837"));
        assertEquals("", result);
    }
}
