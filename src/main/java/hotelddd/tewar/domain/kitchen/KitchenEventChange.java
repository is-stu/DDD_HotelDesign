package hotelddd.tewar.domain.kitchen;

import co.com.sofka.domain.generic.EventChange;
import hotelddd.tewar.domain.kitchen.events.CreatedKitchen;

public class KitchenEventChange extends EventChange {
    public KitchenEventChange(Kitchen kitchen) {
        apply((CreatedKitchen event)->{
            kitchen.chef = event.getChef();
            kitchen.dimension = event.getDimension();
        });
    }
}
