package roman;

public class RomanNumerals {


    private String romanNumeral;
    private int asInt;
    private int digitSectionToRemember;

    public RomanNumerals(String numeral) {
        romanNumeral = numeral;
    }

    public int fromRoman() {
        digitSectionToRemember = 0;
        asInt = 0;
        for (int i = 0; i<romanNumeral.length(); ++i) {
            int val = valueAt(i);
            if (isChangeToBiggerDigit(i)) {
                asInt += val;
                asInt -= digitSectionToRemember;
            }
            else if (isChangeToSmallerDigit(i)) {
                asInt += digitSectionToRemember;
            }

            if (!isDigitSameAsPrevious(i))
                digitSectionToRemember = 0;

            if (isChangeToSmallerDigit(i) || isDigitSameAsPrevious(i)) {
                digitSectionToRemember += val;
            }

        }
        asInt += digitSectionToRemember;
        return asInt;
    }

    private boolean isChangeToSmallerDigit(int indexOfDigit) {
        int previousDigit = valueAt(indexOfDigit - 1);
        int currentDigit = valueAt(indexOfDigit);
        return previousDigit > currentDigit;
    }

    private boolean isChangeToBiggerDigit(int indexOfDigit) {
        int oldVal = valueAt(indexOfDigit - 1);
        int val = valueAt(indexOfDigit);
        return oldVal < val;
    }

    private boolean isDigitSameAsPrevious(int indexOfDigit) {
        int oldVal = valueAt(indexOfDigit - 1);
        int val = valueAt(indexOfDigit);
        return oldVal == val;
    }

    private int valueAt(int i) {
        if (i < 0) return 9999999;
        char c = romanNumeral.charAt(i);
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
