package hotelddd.tewar.usecase.kitchen;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.kitchen.command.UpdateKitchen;
import hotelddd.tewar.domain.kitchen.entities.Chef;
import hotelddd.tewar.domain.kitchen.events.KitchenCreated;
import hotelddd.tewar.domain.kitchen.events.UpdatedKitchen;
import hotelddd.tewar.domain.kitchen.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateKitchenUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    public void updateKitchen() {

        var kitchenId = KitchenId.of("123");
        var dimension = new Dimension(600.0);

        var command = new UpdateKitchen(kitchenId, dimension);
        var useCase = new UpdateKitchenUseCase();
        useCase.addRepository(repository);

        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(events());

        List<DomainEvent> events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command)).
                orElseThrow().
                getDomainEvents();

        Mockito.verify(repository).getEventsBy(Mockito.any());

        UpdatedKitchen updatedKitchen = (UpdatedKitchen)events.get(0);

        assertEquals(600.0, updatedKitchen.getDimension().value());


    }

    private List<DomainEvent> events() {
        return List.of(
                new KitchenCreated(
                        new Dimension(200.0), new Chef(
                        WorkerId.of("111"),
                        new Name("Stewar"),
                        new Phone("3182876825"),
                        new Experience(5),
                        new Special("Italian Food")))
        );
    }
}