package hotelddd.tewar.domain.inventory.entities;

import co.com.sofka.domain.generic.Entity;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.generalValues.Stock;
import hotelddd.tewar.domain.inventory.values.Brand;
import hotelddd.tewar.domain.inventory.values.UtensilId;

public class Utensil extends Entity<UtensilId> {

    private Name name;
    private Brand brand;
    private Stock stock;

    public Utensil(UtensilId entityId, Name name, Brand brand, Stock stock) {
        super(entityId);
        this.name = name;
        this.brand = brand;
        this.stock = stock;
    }

    public Name getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public Stock getStock() {
        return stock;
    }
}
