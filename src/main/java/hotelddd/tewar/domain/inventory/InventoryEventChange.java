package hotelddd.tewar.domain.inventory;

import co.com.sofka.domain.generic.EventChange;
import hotelddd.tewar.domain.inventory.events.InventoryCreated;

public class InventoryEventChange extends EventChange {
    public InventoryEventChange(Inventory inventory) {
        apply((InventoryCreated event)->{
            inventory.food = event.getFood();
            inventory.utensil = event.getUtensil();
        });
    }
}
