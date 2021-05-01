package hotelddd.tewar.domain.kitchen.command;

import co.com.sofka.domain.generic.Command;
import hotelddd.tewar.domain.kitchen.entities.Chef;
import hotelddd.tewar.domain.kitchen.values.Dimension;
import hotelddd.tewar.domain.kitchen.values.KitchenId;

public class CreateKitchen implements Command {

    private final KitchenId kitchenId;
    private final Dimension dimension;
    private final Chef chef;

    public CreateKitchen(KitchenId entityId, Dimension dimension, Chef chef) {
        kitchenId = entityId;
        this.dimension = dimension;
        this.chef = chef;
    }

    public KitchenId getKitchenId() {
        return kitchenId;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Chef getChef() {
        return chef;
    }
}
