package hotelddd.tewar.domain.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.inventory.entities.Food;
import hotelddd.tewar.domain.inventory.entities.Utensil;
import hotelddd.tewar.domain.inventory.values.InventoryId;

public class UpdatedInventory extends DomainEvent {
    private final InventoryId inventoryId;
    private final Food food;
    private final Utensil utensil;

    public UpdatedInventory(InventoryId entityId, Food food, Utensil utensil) {
        super("update.inventory.updateInventory");
        inventoryId = entityId;
        this.food = food;
        this.utensil = utensil;
    }

    public InventoryId getInventoryId() {
        return inventoryId;
    }

    public Food getFood() {
        return food;
    }

    public Utensil getUtensil() {
        return utensil;
    }
}
