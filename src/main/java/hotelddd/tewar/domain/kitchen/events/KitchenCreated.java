package hotelddd.tewar.domain.kitchen.events;

import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.kitchen.entities.Chef;
import hotelddd.tewar.domain.kitchen.values.Dimension;

public class KitchenCreated extends DomainEvent {
    private final Dimension dimension;
    private final Chef chef;

    public KitchenCreated(Dimension dimension, Chef chef) {
        super("create.kitchen.createKitchen");
        this.dimension = dimension;
        this.chef = chef;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Chef getChef() {
        return chef;
    }
}
