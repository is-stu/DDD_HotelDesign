package hotelddd.tewar.domain.menu.entities;

import co.com.sofka.domain.generic.Entity;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.menu.values.Description;
import hotelddd.tewar.domain.menu.values.KindFood;
import hotelddd.tewar.domain.menu.values.PlateId;
import hotelddd.tewar.domain.menu.values.Price;

public class Plate extends Entity<PlateId> {

    private Price price;
    private Name name;
    private Description description;
    private KindFood kindFood;

    public Plate(PlateId entityId, Price price, Name name, Description description, KindFood kindFood) {
        super(entityId);
        this.price = price;
        this.name = name;
        this.description = description;
        this.kindFood = kindFood;
    }


    public Price getPrice() {
        return price;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public KindFood getKindFood() {
        return kindFood;
    }
}
