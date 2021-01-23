import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class NumberRangeSummarizerSolution implements NumberRangeSummarizer {

    /*
     * This collect method implementation uses a TreeSet for storing
     * the valid numbers from the specified input string.
     * 
     * The tree set is primiarily selected for two reasons:
     * - maintains sorting order between integers
     * - avoids unnecessary duplicate integers
     * 
     * Time complexity: ~O(n log n), where n refers to the number
     * of integers in the specified input string.
     * 
     * Space complexity: ~O(n), where n refers to the number of
     * integers in the specified input string.
     */
    @Override
    public Collection<Integer> collect(String input) {

        // Split into multiple number strings delimited by comma
        String[] splitNumberStrings = input.split(",");

        SortedSet<Integer> sortedNumbers = new TreeSet<Integer>();

        // Iterate through all of the split number strings
        for (String numberString : splitNumberStrings)
        {
            Integer parsedNumber = tryParseNumberString(numberString);

            // Add valid parse numbers to the result collection
            if (parsedNumber != null)
                sortedNumbers.add(parsedNumber);
            // If any invalid parse numbers found, then return an empty collection
            else
                return new PriorityQueue<Integer>();
        }
            
        return sortedNumbers;
    }

    /*
     * Helper method that attempts to parse a string into an integer.
     * This helper method is used to avoid cases involving
     * invalid number strings.
     */
    private Integer tryParseNumberString(String numberString)
    {
        try {
            return Integer.parseInt(numberString);
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * This method implementation assumes that the specified
     * integer collection is sorted.
     * 
     * Time complexity: ~O(n), where n refers to the number of integers
     * in the specified input collection.
     * 
     * Space complexity: O(1).
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        
        // Base cases
        if (input.size() == 0)
            return "";
        if (input.size() == 1)
            return input.iterator().next() + "";

        Iterator<Integer> numberIterator = input.iterator();
        int prevNum = numberIterator.next();
        String result = prevNum + "";

        // Flag to check whether the previous number comes from a range
        boolean isPrevNumFromRange = false;

        // Iterate through all numbers in the iterator
        while (numberIterator.hasNext())
        {
            int nextNum = numberIterator.next();

            // Is the next number sequential to the previous number?
            if (nextNum - prevNum == 1)
            {
                prevNum = nextNum;
                isPrevNumFromRange = true;
            }
            else
            {
                // Have we previously dealt with a number range?
                if (isPrevNumFromRange)
                {
                    result += "-" + prevNum;
                    isPrevNumFromRange = false;
                }
                
                // Add comma separator + consecutive number
                result += ", " + nextNum;
                prevNum = nextNum;
            }
        }

        return result;
    }
}
