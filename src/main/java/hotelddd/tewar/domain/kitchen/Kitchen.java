package hotelddd.tewar.domain.kitchen;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.kitchen.entities.Chef;
import hotelddd.tewar.domain.kitchen.events.KitchenCreated;
import hotelddd.tewar.domain.kitchen.values.Dimension;
import hotelddd.tewar.domain.kitchen.values.KitchenId;

import java.util.List;

public class Kitchen extends AggregateEvent<KitchenId> {
    protected Dimension dimension;
    protected Chef chef;

    public Kitchen(KitchenId entityId, Dimension dimension, Chef chef) {
        super(entityId);
        appendChange(new KitchenCreated(dimension,chef)).apply();
    }

    private Kitchen(KitchenId entityId) {
        super(entityId);
        subscribe(new KitchenEventChange(this));
    }

    public static Kitchen from(KitchenId entityId, List<DomainEvent> events){
        var kitchen = new Kitchen(entityId);
        events.forEach(kitchen::applyEvent);
        return kitchen;
    }
}
