package hotelddd.tewar.domain.inventory.values;

import co.com.sofka.domain.generic.Identity;

public class UtensilId extends Identity {

    private UtensilId(String uuid) {
        super(uuid);
    }

    public UtensilId() {
    }

    public static UtensilId of(String uid){
        return new UtensilId(uid);
    }
}
