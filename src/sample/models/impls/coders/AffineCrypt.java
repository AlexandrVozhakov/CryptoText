package sample.models.impls.coders;

import sample.models.interfaces.Alphabet;
import sample.models.interfaces.Coder;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by alex on 06.12.16.
 */
public class AffineCrypt extends Alphabet implements Coder {


    private Map<Integer, Integer> contraryMap = new TreeMap<>();
    private int contrary;


    public AffineCrypt() {

        contraryMap.put(1, 1);
        contraryMap.put(3, 9);
        contraryMap.put(5, 21);
        contraryMap.put(7, 15);
        contraryMap.put(9, 3);
        contraryMap.put(11, 19);
        contraryMap.put(15, 7);
        contraryMap.put(17, 23);
        contraryMap.put(19, 11);
        contraryMap.put(21, 5);
        contraryMap.put(23, 17);
        contraryMap.put(25, 25);
    }


    @Override
    public String encrypt(String text, List<Integer> keys) {

        char [] letters = text.toCharArray();
        StringBuilder cryptText = new StringBuilder();

        for (char c : letters) {
            cryptText.append(affineEncrypt(c, keys.get(0), keys.get(1)));
        }
        return cryptText.toString();
    }


    @Override
    public String decrypt(String text, List<Integer> keys) {

        char [] letters = text.toCharArray();
        StringBuilder cryptText = new StringBuilder();

        if (contraryMap.containsKey(keys.get(0))) {
            contrary = contraryMap.get(keys.get(0));

            for (char c : letters) {
                cryptText.append(affineDecrypt(c, keys.get(0), keys.get(1)));
            }
        }
        return cryptText.toString();
    }


    private char affineEncrypt(char ch, int a, int b) {

        if (!Character.isLetter(ch)) {
            return ch;
        }
        char offset = getOffset(ch);
        char y = (char) (ch - offset);
        y = (char) ((a * y + b) % alphabetLength(ch));
        return (char) (y + offset);
    }


    private char affineDecrypt(char ch, int a, int b) {

        if (!Character.isLetter(ch)) {
            return ch;
        }
        char offset = getOffset(ch);
        char y = (char) (ch - offset);
        y = (char) (contrary * (alphabetLength(ch) + y - b) % alphabetLength(ch));
        return (char) (y + offset);
    }
}
