import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Main Class Tests")
class MainClassTest {

    private MainClass ourClass;

    @BeforeEach
    void setMainClassObject() {
        ourClass = new MainClass();
    }

    @Nested
    @DisplayName("adding values > 10")
    static
    class NestedAddition {

        @RepeatedTest(5)
        @Tag("SecondRoundTests")
        @DisplayName("When adding numbers repeatedly")
        void testRepeatedly(RepetitionInfo repetitionInfo) {
            if (repetitionInfo.getCurrentRepetition() == 3) {
//                (fail"then the minimum iteration should be 4");
            }
        }
    }

    @Nested
    @DisplayName("Frequency of chars")
    class FrequencyOfChars {

        @Test
        @DisplayName("when testing a string with the same chars")
        void testStringWithSameChars() {
            assertAll(
                    () -> {
                        assertEquals(5, ourClass.getFrequency("aa", 5),
                                () -> "then frequency of char should be equal to size of string to consider");
                    }
            );
        }

        @Test
        @DisplayName("when testing a string with different chars")
        void testStringWithDifferentChars() {
            assertAll(
                    () -> {
                        assertTrue(10 > ourClass.getFrequency("aba", 10),
                                () -> "then the frequency of the char should be less than the size of the string being considered");
                    },
                    () -> {
                        assertTrue(7 == ourClass.getFrequency("aba", 10));
                    }
            );
        }

    }

    @Nested
    @DisplayName("Rotating the elements in an Array")
    class ArrayRotation {

        @Test
        @DisplayName("when number of rotation is < the number of elements in the array")
        void lessRotations() {
            assertAll(
                    () -> assertArrayEquals(new int[]{3, 1, 2}, ourClass.rotateArray(new int[]{1, 2, 3}, 2),
                            () -> "then array output should be different from original array")
            );
        }

        @Test
        @DisplayName("when the number of rotations == the number of elements in the array")
        void equalRotations() {
            assertArrayEquals(new int[]{1, 2, 3}, ourClass.rotateArray(new int[]{1, 2, 3}, 3),
                    () -> "then the array output should be the same as original array");
        }

        @Test
        @DisplayName("when the number of rotations > the number of elements in the array")
        void moreRotations() {
            assertArrayEquals(new int[]{2, 3, 1}, ourClass.rotateArray(new int[]{1, 2, 3}, 4),
                    () -> "then the output array should be different from the original");
        }

    }

    @Nested
    @DisplayName("Calculating the minimum bribe")
    class minimumBribeTest {

        @Test
        @DisplayName("when a queue member pays or switches more than 2 spaces")
        void switchMoreThanTwoSpaces() {
            assertEquals(-5, ourClass.minimumBribes(new int[]{1, 5, 2, 3, 4}), () -> "then the queue is too chaotic");
        }

        @Test
        @DisplayName("when a queue member pays or switches 2 spaces")
        void switchTwoSpaces() {
            assertEquals(2, ourClass.minimumBribes(new int[]{1, 2, 5, 3, 4}), () -> "then the minimum bribes paid is 2");
        }

        @Test
        @DisplayName("when a queue member pays or switches 1 space")
        void switchOneSpace() {
            assertEquals(1, ourClass.minimumBribes(new int[]{1, 2, 3, 5, 4}), () -> "then the minimum bribes paid is 1");
        }

        @Test
        @DisplayName("when a queue member pays or switches 4 spaces")
        void switch4Space() {
            //assertEquals( 1, ourClass.minimumBribes(new int[]{1,3,2}), () -> "then the minimum bribes paid is 1");
            assertEquals(7, ourClass.minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4}), () -> "then the minimum bribes paid is 7");
        }

        @Test
        @DisplayName("when a queue member pays or switches 7 spaces")
        void switch5Space() {
            assertAll(
                    () -> {
                        assertEquals(3, ourClass.minimumBribes(new int[]{2, 1, 5, 3, 4}), () -> "then the minimum bribes paid is 3");
                    },
                    () -> {
                        assertEquals(-5, ourClass.minimumBribes(new int[]{2, 5, 1, 3, 4}), () -> "then the minimum bribes paid is -5");
                    },
                    () -> {
                        assertEquals(-5, ourClass.minimumBribes(new int[]{5, 1, 2, 3, 7, 8, 6, 4}), () -> "then the minimum bribes paid is -5");
                    },
                    () -> {
                        assertEquals(7, ourClass.minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4}), () -> "then the minimum bribes paid is 7");
                    }
            );
        }


    }

    @Nested
    @DisplayName("Minimum Swaps")
    class minimumSwap {

        @Test
        @DisplayName("when all elements in the array are not in their right positions")
        void allElementsInWrongPositions() {
            assertEquals(3, ourClass.minimumSwaps(new int[]{4, 3, 1, 2}), () -> "then the minimum number of swaps required is 3");
            assertEquals(3, ourClass.minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}), () -> "then the minimum number of swaps required is 3");
        }
    }

    @Nested
    @DisplayName("Manipulating arrays")
    class arrayManipulations {

        @Test
        @DisplayName("when adding values to parts of an array")
        void manipulatingArrays() {
            assertEquals(31, ourClass.arrayManipulation(10, new int[][]{{10, 4}, {2, 6, 8}, {3, 5, 7}, {1, 8, 1}, {5, 9, 15}}));
            assertEquals(200, ourClass.arrayManipulation(5, new int[][]{{5, 3}, {1, 2, 100}, {2, 5, 100}, {3, 4, 100}}));
        }
    }

    @Nested
    @DisplayName("Calculating the values in an hour glass")
    class hourGlassTest {

        @Test
        @DisplayName("when calculating the max value of an hour glass in an array")
        void getMaxValueOfHourGlass() {
            assertEquals(28, ourClass.hourglassSum(new int[][]{{-9, -9, -9, 1, 1, 1}, {0, -9, 0, 4, 3, 2}, {-9, -9, -9, 1, 2, 3}, {0, 0, 8, 6, 6, 0}, {0, 0, 0, -2, 0, 0}, {0, 0, 1, 2, 4, 0}}));
        }
    }

    @Nested
    @DisplayName("Testing Sherlock Anagrams")
    class sherLockAnagramsTest {
        @Test
        @DisplayName("When testing a string with 2 anagrams")
        void sherlockAndAnagrams() {
            assertEquals(4, ourClass.sherlockAndAnagrams("abba"), () -> "then the expected number of anagrams should be 2");
            assertEquals(10, ourClass.sherlockAndAnagrams("kkkk"), () -> "then the expected number of anagrams should be 10");
            assertEquals(3, ourClass.sherlockAndAnagrams("ifailuhkqq"), () -> "then the expected number of anagrams should be 3");
        }

    }


    @Nested
    @DisplayName("When calculating the biggest rectangle in a histogram")
    class rectangleInHistogram {
        @Test
        @DisplayName("When calculating for the biggest rectangle...")
        void calculateBiggestRectangleTest() {
            assertEquals(5, ourClass.rectangleInHistogram(new int[]{1, 3, 2, 1, 2}), () -> "then the results should be 5");
        }
    }
}
