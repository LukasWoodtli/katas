package roman;

public class RomanNumeral {
    private String romanNumeral;
    public RomanNumeral(String numeral)
    {
        romanNumeral = numeral;
    }

    public int toInt() {
        int sum = 0;
        int sectionSum = 0;
        for (int i = 0; i < romanNumeral.length(); ++i) {
            if (isChangeToBiggerDigit(i)) {
                sum -= sectionSum;
                sectionSum = 0;
            }
            sectionSum += getValueOfRomanDigit(i);
        }

        return sum + sectionSum;
    }

    private boolean isChangeToBiggerDigit(int i) {
        if (i <= 0) return false;
        else return getValueOfRomanDigit(i-1) < getValueOfRomanDigit(i);
    }

    private int getValueOfRomanDigit(int i) {
        char num = romanNumeral.charAt(i);

        switch (num) {
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
        }
        return -1;
    }
}
