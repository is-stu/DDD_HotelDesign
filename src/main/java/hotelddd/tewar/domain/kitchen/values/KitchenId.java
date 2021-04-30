package hotelddd.tewar.domain.kitchen.values;

import co.com.sofka.domain.generic.Identity;

public class KitchenId extends Identity {

    private KitchenId(String uuid) {
        super(uuid);
    }

    public KitchenId() {
    }

    public static KitchenId of(String uid){
        return new KitchenId(uid);
    }
}
