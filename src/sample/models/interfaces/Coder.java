package sample.models.interfaces;

import java.util.List;

/**
 * Created by alex on 16.11.16.
 */
public interface Coder {

    String encrypt(String text, List<Integer> keys);
    String decrypt(String text, List<Integer> keys);
}
