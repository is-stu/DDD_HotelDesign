package hotelddd.tewar.domain.kitchen.events;

import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.kitchen.values.Dimension;
import hotelddd.tewar.domain.kitchen.values.KitchenId;

public class UpdatedKitchen extends DomainEvent {
    private final KitchenId kitchenId;
    private final Dimension dimension;

    public UpdatedKitchen(KitchenId entityId, Dimension dimension) {
        super("update.kitchen.updateKitchen");
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
