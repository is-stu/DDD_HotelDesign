package hotelddd.tewar.domain.kitchen;

import co.com.sofka.domain.generic.EventChange;
import hotelddd.tewar.domain.kitchen.events.KitchenCreated;

public class KitchenEventChange extends EventChange {
    public KitchenEventChange(Kitchen kitchen) {
        apply((KitchenCreated event)->{
            kitchen.chef = event.getChef();
            kitchen.dimension = event.getDimension();
        });
    }
}
