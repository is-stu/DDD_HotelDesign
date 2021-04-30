package hotelddd.tewar.domain.inventory.values;

import co.com.sofka.domain.generic.Identity;

public class InventoryId extends Identity {


    private InventoryId(String uuid) {
        super(uuid);
    }

    public InventoryId() {
    }

    public static InventoryId of(String uid){
        return new InventoryId(uid);
    }
}
