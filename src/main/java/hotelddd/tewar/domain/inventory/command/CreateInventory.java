package hotelddd.tewar.domain.inventory.command;

import co.com.sofka.domain.generic.Command;
import hotelddd.tewar.domain.inventory.entities.Food;
import hotelddd.tewar.domain.inventory.entities.Utensil;
import hotelddd.tewar.domain.inventory.values.InventoryId;

public class CreateInventory implements Command {

    private final InventoryId inventoryId;
    private final Food food;
    private final Utensil utensil;

    public CreateInventory(InventoryId entityId, Food food, Utensil utensil) {
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
