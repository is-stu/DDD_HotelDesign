package hotelddd.tewar.domain.inventory.entities;

import co.com.sofka.domain.generic.Entity;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.generalValues.Stock;
import hotelddd.tewar.domain.inventory.values.Category;
import hotelddd.tewar.domain.inventory.values.FoodId;

public class Food extends Entity<FoodId> {

    private Name name;
    private Stock stock;
    private Category category;

    public Food(FoodId entityId, Name name, Stock stock, Category category) {
        super(entityId);
        this.name = name;
        this.stock = stock;
        this.category = category;
    }

    public Name getName() {
        return name;
    }

    public Stock getStock() {
        return stock;
    }

    public Category getCategory() {
        return category;
    }
}
