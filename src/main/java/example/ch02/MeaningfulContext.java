package example.ch02;

public class MeaningfulContext {
    private static String number;
    private static String verb;
    private static String pluralModifier;

    private static void printGuessStatisticsWrongCase(char candidate, int count) {
        if (count==0) {
            number="no";
            verb="are";
            pluralModifier="s";
        } else if (count==1) {
            number="1";
            verb="is";
            pluralModifier="";
        } else {
            number=Integer.toString(count);
            verb="are";
            pluralModifier="s";
        }
        String guessMessage=String.format(
          "There %s %s %s%s", verb, number, candidate, pluralModifier
        );
        System.out.println(guessMessage);
    }

    private static String printGuessStatisticsRightCase(char candidate, int count) {
        createPluralDependentMessageParts(count);
        return String.format(
                "There %s %s %s%s",
                verb, number, candidate, pluralModifier
        );
    }

    private static void createPluralDependentMessageParts(int count) {
        if (count==0) {
            thereAreNoLetters();
        } else if (count==1) {
            thereIsOneLetter();
        } else {
            thereAreManyLetters(count);
        }
    }

    private static void thereAreManyLetters(int count) {
        number=Integer.toString(count);
        verb="are";
        pluralModifier="s";
    }

    private static void thereIsOneLetter() {
        number="1";
        verb="is";
        pluralModifier="";
    }

    private static void thereAreNoLetters() {
        number="no";
        verb="are";
        pluralModifier="s";
    }

    public static void main(String[] args) {
        printGuessStatisticsWrongCase('A', 3);
        System.out.println(printGuessStatisticsRightCase('B', 0));
    }
}
