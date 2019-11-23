import java.util.*;

public class MainClass {

    public static void main(String[] args) {
//        System.out.print(-2 % 5);
        permutation("", "abba");
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
//            return prefix.chars().reduce(cha - 'a' );
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
        }
//        return -1;
    }

    public long getFrequency(String s, long n) {
        long totalFrequency;
        long frequencyOfLetterInOriginalString = s.chars().filter(character -> character == 'a').count();
        if (n % s.length() > 0) {
            totalFrequency = ((n / s.length()) * frequencyOfLetterInOriginalString) +
                    (s.substring(0, (int) (n % s.length())).chars().filter(character2 -> character2 == 'a').count());
        } else {
            totalFrequency = ((n / s.length()) * frequencyOfLetterInOriginalString);
        }
        return totalFrequency;
    }

    public int[] rotateArray(int[] a, int d) {
        int significantNumberOfRotations = d % a.length;
        if (significantNumberOfRotations == 0) {
            return a;
        }
        int[] finalArray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int newPosition = (i + (a.length - significantNumberOfRotations)) % a.length;
            finalArray[newPosition] = a[i];
        }
        return finalArray;
    }

    public int minimumBribes(int[] q) {
        int bribesPaid;
        int bribesReceived = 0;
        int arrayLength = q.length;
        for (int i = 0; i < arrayLength; i++) {
            int onePositionInFrontOfOriginalPosition = 0;
            int currentValue = q[i];
            int originalValue = i + 1;
            bribesPaid = currentValue - originalValue;
            if (bribesPaid > 2) {
                return -5;
            }
            if (currentValue - 2 > 0) {
                onePositionInFrontOfOriginalPosition = currentValue - 2; // -2 because index positions start from 0 and the corresponding value is always + 1
            }
            while (onePositionInFrontOfOriginalPosition <= i) {
                if (q[onePositionInFrontOfOriginalPosition] > currentValue) {
                    bribesReceived++;
                }
                onePositionInFrontOfOriginalPosition++;
            }
        }
        return bribesReceived;
    }

    public int minimumSwaps(int[] arr) {
        int minimumValue = 1;
        int numberOfSwaps = 0;
        boolean needSwapping = true;
        while (needSwapping) {
            needSwapping = false;
            for (int i = 0; i < arr.length; i++) {
                int currentValue = arr[i];
                int originalValueAtCurrentPosition = i + 1;
                if (currentValue == originalValueAtCurrentPosition) {
                    continue;
                } else {
                    int originalPositionOfCurrentValue = currentValue - minimumValue;
                    int temp = arr[originalPositionOfCurrentValue];
                    arr[originalPositionOfCurrentValue] = currentValue;
                    arr[i] = temp;
                    numberOfSwaps++;
                    needSwapping = true;
                }
            }
        }
        return numberOfSwaps;
    }

    public long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n + 2];
        for (int[] query : queries) {
            int beginIndex = query[0];
            int endIndex = query[1];
            int valueToBeAdded = query.length - 1 > 1 ? query[2] : 0;
            array[beginIndex] += valueToBeAdded;
            array[endIndex + 1] -= valueToBeAdded;
        }

        long sum = 0;
        long maxValue = Long.MIN_VALUE;
        for (long l : array) {
            sum += l;
            maxValue = Math.max(maxValue, sum);
        }
        return maxValue;
    }

    public int hourglassSum(int[][] arr) {
        int maxValue = -63;
        for (int row = 0; row < arr.length - 2; row++) {
            for (int column = 0; column < arr[row].length - 2; column++) {
                maxValue = Math.max(maxValue, (
                                arr[row][column] +
                                arr[row][column + 1] +
                                arr[row][column + 2] +
                                arr[row + 1][column + 1] +
                                arr[row + 2][column] +
                                arr[row + 2][column + 1] +
                                arr[row + 2][column + 2]
                ));
            }
        }
        return maxValue;
    }

    public int checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> wordAndFrequency = new HashMap<>();
        for (String wordInMagazine : magazine) {
            if (wordAndFrequency.containsKey(wordInMagazine)) {
                wordAndFrequency.put(wordInMagazine, wordAndFrequency.get(wordInMagazine) + 1);
            } else {
                wordAndFrequency.put(wordInMagazine, 1);
            }
        }

        for (String wordInNote : note) {
            if (wordAndFrequency.containsKey(wordInNote) && wordAndFrequency.get(wordInNote) > 0) {
                wordAndFrequency.put(wordInNote, wordAndFrequency.get(wordInNote) - 1);
            } else {
                return -1;
            }
        }
        return 1;
    }

    public int sherlockAndAnagrams(String s) {
        Map<Integer, List<int[]>> mapOfSubStringLengthAndIntReps = new HashMap<>();
        int lengthOfOriginalString = s.length();
        for (int maxLengthOfSubstring = 1; maxLengthOfSubstring < lengthOfOriginalString; maxLengthOfSubstring++) {
            for (int j = 0; j <= lengthOfOriginalString - maxLengthOfSubstring; j++) {
                String subString = s.substring(j, j + maxLengthOfSubstring);
                int[] integerArrayRepresentationOfCharactersInSubstring = new int[26];
                for (char characterInSubstring : subString.toCharArray()) {
                    integerArrayRepresentationOfCharactersInSubstring[characterInSubstring - 'a'] += 1;
                }
                int length = subString.length();
                if (mapOfSubStringLengthAndIntReps.containsKey(length)) {
                    List<int[]> subStringReps = mapOfSubStringLengthAndIntReps.get(length);
                    subStringReps.add(integerArrayRepresentationOfCharactersInSubstring);
                    mapOfSubStringLengthAndIntReps.put(length, subStringReps);
                } else {
                    List<int[]> subStringReps = new ArrayList<>();
                    subStringReps.add(integerArrayRepresentationOfCharactersInSubstring);
                    mapOfSubStringLengthAndIntReps.put(length, subStringReps);
                }
            }
        }
        int anagrams = 0;
        for (Map.Entry<Integer, List<int[]>> entry : mapOfSubStringLengthAndIntReps.entrySet()) {
            List<int[]> listOfIntRepsForLength = entry.getValue();
            if (listOfIntRepsForLength.size() <= 1) {
                continue;
            }
            for (int i = 0, size = listOfIntRepsForLength.size(); i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (Arrays.equals(listOfIntRepsForLength.get(i), listOfIntRepsForLength.get(j))) {
                        anagrams++;
                    }
                }
            }

        }
        return anagrams;
    }

    public int largestRectangleInAHistogram(int[] arrayOfHistogramHeights) {
        Stack<Integer> startingPositionOfThisRectangle = new Stack<>();
        Stack<Integer> stackOfHighestHistogramSoFar = new Stack<>();
        int areaOfBiggestRectangleInHistogram = 0;
        int positionOfBeginningOfTheNextRectangle = 0;
        for (int i = 0; i < arrayOfHistogramHeights.length; i++) {
            int heightOfCurrentHistogram = arrayOfHistogramHeights[i];
            Integer peekOfTopValueOfStack = !stackOfHighestHistogramSoFar.isEmpty() ? stackOfHighestHistogramSoFar.peek() : 0;
            if (stackOfHighestHistogramSoFar.isEmpty() || peekOfTopValueOfStack <= heightOfCurrentHistogram) {
                stackOfHighestHistogramSoFar.push(heightOfCurrentHistogram);
                startingPositionOfThisRectangle.push(i);
            } else {
                positionOfBeginningOfTheNextRectangle = startingPositionOfThisRectangle.pop();
                int areaOfCurrentRectangle = stackOfHighestHistogramSoFar.pop() * (i - (!startingPositionOfThisRectangle.isEmpty() ? startingPositionOfThisRectangle.peek() : 1));
                areaOfBiggestRectangleInHistogram = Math.max(areaOfBiggestRectangleInHistogram, areaOfCurrentRectangle);

//                stackOfHighestHistogramSoFar.push(heightOfCurrentHistogram);
//                startingPositionOfThisRectangle.push(positionOfBeginningOfTheNextRectangle);
            }
            while (!stackOfHighestHistogramSoFar.isEmpty() && i == arrayOfHistogramHeights.length - 1) {
                int areaOfCurrentRectangle = stackOfHighestHistogramSoFar.pop() * (i - startingPositionOfThisRectangle.pop());
                areaOfBiggestRectangleInHistogram = Math.max(areaOfBiggestRectangleInHistogram, areaOfCurrentRectangle);
            }
        }
        return areaOfBiggestRectangleInHistogram;
    }

    public int rectangleInHistogram(int[] histograms) {
        Stack<Integer> stackOfIndicesOfIncreasingHistograms = new Stack<>();
        int maxRectangleInHistogram = 0;
        int i = 0;
        for (; i < histograms.length;) {
            int currentHistogram = histograms[i];
            if (stackOfIndicesOfIncreasingHistograms.isEmpty() || histograms[stackOfIndicesOfIncreasingHistograms.peek()] <= currentHistogram) {
                stackOfIndicesOfIncreasingHistograms.push(i++);
            } else {
                maxRectangleInHistogram = getMaxRectangleInHistogram(histograms, stackOfIndicesOfIncreasingHistograms, maxRectangleInHistogram, i);
            }
        }
        while (!stackOfIndicesOfIncreasingHistograms.isEmpty()) {
            maxRectangleInHistogram = getMaxRectangleInHistogram(histograms, stackOfIndicesOfIncreasingHistograms, maxRectangleInHistogram, i);
        }
        return maxRectangleInHistogram;
    }

    private int getMaxRectangleInHistogram(int[] histograms, Stack<Integer> stackOfIndicesOfIncreasingHistograms, int maxRectangleInHistogram, int i) {
        int histogramInStack = histograms[stackOfIndicesOfIncreasingHistograms.pop()];
        if (stackOfIndicesOfIncreasingHistograms.isEmpty()) {
            int area = histogramInStack * i;
            maxRectangleInHistogram = Math.max(maxRectangleInHistogram, area);
        } else {
            int area = histogramInStack * (i - 1 - stackOfIndicesOfIncreasingHistograms.peek());
            maxRectangleInHistogram = Math.max(maxRectangleInHistogram, area);
        }
        return maxRectangleInHistogram;
    }
}
