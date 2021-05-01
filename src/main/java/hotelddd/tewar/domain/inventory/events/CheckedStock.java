package hotelddd.tewar.domain.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.generalValues.Stock;
import hotelddd.tewar.domain.inventory.entities.Food;
import hotelddd.tewar.domain.inventory.entities.Utensil;
import hotelddd.tewar.domain.inventory.values.InventoryId;

public class CheckedStock extends DomainEvent {
    private final InventoryId inventoryId;
    private final Food food;
    private final Utensil utensil;

    public CheckedStock(InventoryId entityId, Food food, Utensil utensil) {
        super("check.inventory.checkInventory");

        inventoryId = entityId;
        this.food = food;
        this.utensil = utensil;
    }

    public Stock getStockFood(){
        return food.getStock();
    }

    public Stock getStockUtensil(){
        return utensil.getStock();
    }

    //Aqui pude notar, obviamente, que hubiera sido mas eficiente la interfaz, como lo hablabamos hoy
}
