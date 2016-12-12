package sample.models.interfaces;

/**
 * Created by alex on 06.12.16.
 */
public abstract class Alphabet {

    private final int rusLength = 33;
    private final int engLength = 26;


    protected int alphabetLength(char ch) {

        if (ch > 122) {
            // rus
            return rusLength;
        } else {
            // eng
            return  engLength;
        }
    }


    protected char getOffset(char ch) {

        if (ch > 122) {
            // rus
            return Character.isLowerCase(ch) ? 'а' : 'А';
        } else {
            // eng
            return Character.isLowerCase(ch) ? 'a' : 'A';
        }
    }

}
