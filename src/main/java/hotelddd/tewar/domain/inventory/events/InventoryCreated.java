package hotelddd.tewar.domain.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.inventory.entities.Food;
import hotelddd.tewar.domain.inventory.entities.Utensil;

public class InventoryCreated extends DomainEvent {
    private final Food food;
    private final Utensil utensil;

    public InventoryCreated(Food food, Utensil utensil) {
        super("create.inventory.CreateInventory");
        this.food = food;
        this.utensil = utensil;
    }

    public Food getFood() {
        return food;
    }

    public Utensil getUtensil() {
        return utensil;
    }
}
