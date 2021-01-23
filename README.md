# Take Home Assessment for Impact

## Task

Implement code which has the ability to produce a comma delimited list of numbers, grouping the numbers into a range when they are sequential. An interface is provided, which you should implement as a solution to the exercise.

Example:

Input - "1,3,6,7,8,12,13,14,15,21,22,23,24,31"

Output - "1, 3, 6-8, 12-15, 21-24, 31"

- - -

## Repository Contents

* The src folder includes two .java classes, namely the provided base interface and the solution, which implements the provided base interface.
* The tests folder includes a single .java class that consists of 13 unit tests.
* The lib folder includes two .jar files required to execute the unit tests.

- - -

## Solution Robustness
The solution supports the following scenarios:
* Empty number string;
* Duplicate numbers in the specified number string;
* Negative numbers in the specified number string;
* Both sorted and unsorted numbers in the specified number string; and
* Invalid number strings (see task assumptions).

- - -

## Task Assumptions
1. As per instructions, the solution implementation is expected to solely use the summarizeCollection() and collect() methods in conjunction with each other.
2. Input number strings are invalid for summarizing number ranges when:
    * An alternative delimiter is used to define the number string;
    * Non-digit characters are included in the number string (spaces, letters, etc.); and
    * Integer values exceed the 32-bit integer values (integer overflow/underflow);

- - -

## Instructions

1. Clone repository
2. Open in VSCode
3. Install Java Test Runner Extension
4. Run the unit tests via the test tab
