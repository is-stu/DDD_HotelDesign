package hotelddd.tewar.domain.inventory.values;

import co.com.sofka.domain.generic.Identity;

public class FoodId extends Identity {

    private FoodId(String uuid) {
        super(uuid);
    }

    public FoodId() {
    }

    public static FoodId of(String uid){
        return new FoodId(uid);
    }
}
