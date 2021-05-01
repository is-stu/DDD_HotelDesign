package hotelddd.tewar.usecase.kitchen;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import hotelddd.tewar.domain.kitchen.Kitchen;
import hotelddd.tewar.domain.kitchen.events.IncreasedChefExperience;
import hotelddd.tewar.domain.kitchen.values.KitchenId;

public class GetExperienceUseCase extends UseCase<TriggeredEvent<IncreasedChefExperience>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<IncreasedChefExperience> increasedChefExperienceTriggeredEvent) {
        var event = increasedChefExperienceTriggeredEvent.getDomainEvent();
        var kitchen = Kitchen.from(KitchenId.of(event.getKitchenId().value()),retrieveEvents());

        kitchen.increaseChefExperience();

        emit().onResponse(new ResponseEvents(kitchen.getUncommittedChanges()));

    }
}
