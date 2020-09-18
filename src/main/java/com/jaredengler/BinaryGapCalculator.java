package com.jaredengler;

public class BinaryGapCalculator {

    Integer calculate(Integer integer) {
        return maximizeGapStringLength(integer);
    }

    Integer maximizeGapStringLength(Integer integer) {

        String binaryString = Integer.toBinaryString(integer);
        int positionOfLastOne = binaryString.indexOf("1");
        int currentMaxGapLength = 0;

        for (int i = 0; i < binaryString.length(); i++) {

            int positionOfNextOnefromLastOne = findPositionOfNextOneFrom(binaryString, positionOfLastOne);
            int newGapLength = positionOfNextOnefromLastOne - positionOfLastOne;
            positionOfLastOne = positionOfNextOnefromLastOne;

            if (newGapLength > currentMaxGapLength) {
                currentMaxGapLength = newGapLength;
            }

        }

        return currentMaxGapLength;
    }

    int findPositionOfNextOneFrom(String binaryString, int positionOfLastOne) {

        int newPos = binaryString.indexOf("1", positionOfLastOne + 1) - 1;

        // defines behavior for dangling gaps ie ^(1|0)*100000$
        return newPos < 1 ? positionOfLastOne : newPos;

    }

}
