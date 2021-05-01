package hotelddd.tewar.domain.kitchen.command;

import co.com.sofka.domain.generic.Command;
import hotelddd.tewar.domain.kitchen.values.Dimension;
import hotelddd.tewar.domain.kitchen.values.KitchenId;

public class UpdateKitchen implements Command {

    private final KitchenId kitchenId;
    private final Dimension dimension;

    public UpdateKitchen(KitchenId entityId, Dimension dimension) {
        kitchenId = entityId;
        this.dimension = dimension;
    }

    public KitchenId getKitchenId() {
        return kitchenId;
    }

    public Dimension getDimension() {
        return dimension;
    }
}
