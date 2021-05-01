package hotelddd.tewar.domain.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.inventory.entities.Utensil;
import hotelddd.tewar.domain.inventory.values.InventoryId;

public class BroughtBrand extends DomainEvent {
    private final InventoryId inventoryId;
    private final Utensil utensil;

    public BroughtBrand(InventoryId entityId, Utensil utensil) {
        super("bring.inventory.BroughtBrand");
        inventoryId = entityId;
        this.utensil = utensil;
    }

    public InventoryId getInventoryId() {
        return inventoryId;
    }

    public Utensil getUtensil() {
        return utensil;
    }
}
