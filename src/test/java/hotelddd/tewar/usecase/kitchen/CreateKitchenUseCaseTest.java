package hotelddd.tewar.usecase.kitchen;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.kitchen.command.CreateKitchen;
import hotelddd.tewar.domain.kitchen.entities.Chef;
import hotelddd.tewar.domain.kitchen.events.KitchenCreated;
import hotelddd.tewar.domain.kitchen.values.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateKitchenUseCaseTest {

    @Test
    public void createKitchen() {

        var kitchenId = KitchenId.of("0111");
        var dimension = new Dimension(400.0);
        var chef = new Chef(WorkerId.of("888"),
                new Name("Stewar"), new Phone("3182876825"),
                new Experience(3), new Special("Italian Food"));

        var command = new CreateKitchen(kitchenId,dimension,chef);
        var useCase = new CreateKitchenUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command)).
                orElseThrow().
                getDomainEvents();

        KitchenCreated kitchenCreated = (KitchenCreated) events.get(0);

        assertEquals(400.0, kitchenCreated.getDimension().value());
        assertEquals("Stewar", kitchenCreated.getChef().getName().value());
        assertEquals("Italian Food", kitchenCreated.getChef().getSpecial().value());
        assertEquals(3, kitchenCreated.getChef().getExperience().value());


    }

}