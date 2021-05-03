package hotelddd.tewar.usecase.kitchen;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.kitchen.command.UpdateKitchen;
import hotelddd.tewar.domain.kitchen.entities.Chef;
import hotelddd.tewar.domain.kitchen.events.KitchenCreated;
import hotelddd.tewar.domain.kitchen.events.UpdatedKitchen;
import hotelddd.tewar.domain.kitchen.values.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class UpdateKitchenUseCaseTestAsync extends UseCaseHandleBaseTest {

    @Test
    public void updateKitchen() throws InterruptedException {

        var kitchenId = KitchenId.of("123");
        var dimension = new Dimension(600.0);

        var command = new UpdateKitchen(kitchenId, dimension);
        var useCase = new UpdateKitchenUseCase();
        useCase.addRepository(repository);

        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(List.of(
                new KitchenCreated(dimension,new Chef(
                        WorkerId.of("123"),new Name("Stewar"), new Phone("3123123123"),
                        new Experience(5), new Special("italian")
                ))
        ));

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .asyncExecutor(useCase, new RequestCommand<>(command))
                .subscribe(subscriber);
        Thread.sleep(800);
        verify(subscriber).onNext(eventCaptor.capture());
        var updatedKitchen = (UpdatedKitchen) eventCaptor.getValue();


        assertEquals(600.0, updatedKitchen.getDimension().value());

    }
}