package hotelddd.tewar.domain.kitchen.events;

import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.kitchen.entities.Chef;
import hotelddd.tewar.domain.kitchen.values.KitchenId;

public class IncreasedChefExperience extends DomainEvent {
    private final KitchenId kitchenId;
    private final Chef chef;

    public IncreasedChefExperience(KitchenId entityId, Chef chef) {
        super("increase.chef.increaseChefExperience");
        kitchenId = entityId;
        this.chef = chef;
    }

    public KitchenId getKitchenId() {
        return kitchenId;
    }

    public Chef getChef() {
        return chef;
    }

    public void levelUp(){
        chef.increaseExperience();
    }
}
