package sample.models.impls.coders;

import sample.models.interfaces.Alphabet;
import sample.models.interfaces.Coder;

import java.util.List;

/**
 * Created by alex on 10.12.16.
 */
public class GammaCrypt extends Alphabet implements Coder {


    @Override
    public String encrypt(String text, List<Integer> keys) {
        System.out.println(1);
        return null;
    }

    @Override
    public String decrypt(String text, List<Integer> keys) {
        System.out.println(2);
        return null;
    }
}
