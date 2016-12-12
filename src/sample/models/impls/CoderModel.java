package sample.models.impls;

import sample.models.impls.coders.CaesarCrypt;
import sample.models.objects.CoderFactory;
import sample.models.interfaces.Coder;

import java.util.List;

/**
 * Created by alex on 16.11.16.
 */
public class CoderModel implements Coder {


    private static Coder instance = new CoderModel();
    private Coder coder;
    private CoderFactory factory;


    private CoderModel() {
        factory = new CoderFactory();
    }


    public static Coder getInstance() { return instance; }


    public void changeTypeCrypt(String type) {
        coder = factory.getCoder(type);
    }


    @Override
    public String encrypt(String text, List<Integer> keys) {
        return coder.encrypt(text, keys);
    }


    @Override
    public String decrypt(String text, List<Integer> keys) {
        return coder.decrypt(text, keys);
    }
}
