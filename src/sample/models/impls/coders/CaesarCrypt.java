package sample.models.impls.coders;

import sample.models.interfaces.Alphabet;
import sample.models.interfaces.Coder;

import java.util.List;

/**
 * Created by alex on 06.12.16.
 */
public class CaesarCrypt extends Alphabet implements Coder {


    @Override
    public String encrypt(String text, List<Integer> keys) {

        char [] letters = text.toCharArray();
        StringBuilder cryptText = new StringBuilder();

        for (char c : letters) {
            cryptText.append(caesarEncrypt(c, keys.get(0)));
        }
        return cryptText.toString();
    }


    @Override
    public String decrypt(String text, List<Integer> keys) {

        char [] letters = text.toCharArray();
        StringBuilder cryptText = new StringBuilder();

        for (char c : letters) {
            cryptText.append(caesarDecrypt(c, keys.get(0)));
        }
        return cryptText.toString();
    }


    private char caesarEncrypt(char ch, int key) {

        if (!Character.isLetter(ch)) {
            return ch;
        }
        if (key > alphabetLength(ch)) {
            key %=  alphabetLength(ch);
        }
        char offset = getOffset(ch);
        return (char)((((ch + key) - offset) % alphabetLength(ch)) + offset);
    }


    private char caesarDecrypt(char ch, int key) {

        if (!Character.isLetter(ch)) {
            return ch;
        }
        if (key > alphabetLength(ch)) {
            key %=  alphabetLength(ch);
        }
        char offset = getOffset(ch);
        int len = alphabetLength(ch);
        return (char)((((len + ch - key) - offset) % len) + offset);
    }
}
