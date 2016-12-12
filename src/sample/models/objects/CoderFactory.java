package sample.models.objects;

import sample.models.impls.coders.AffineCrypt;
import sample.models.impls.coders.CaesarCrypt;
import sample.models.impls.coders.GammaCrypt;
import sample.models.interfaces.Coder;

/**
 * Created by alex on 07.12.16.
 */
public class CoderFactory {

    public Coder getCoder(String type) {
        switch (type) {

            case "Caesar":
                return new CaesarCrypt();
            case "Affine":
                return new AffineCrypt();
            case "Gamma":
                return new GammaCrypt();
            default:
                return null;
        }
    }
}
