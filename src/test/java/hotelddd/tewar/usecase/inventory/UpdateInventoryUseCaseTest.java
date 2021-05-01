package hotelddd.tewar.usecase.inventory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.generalValues.Stock;
import hotelddd.tewar.domain.inventory.command.UpdateInventory;
import hotelddd.tewar.domain.inventory.entities.Food;
import hotelddd.tewar.domain.inventory.entities.Utensil;
import hotelddd.tewar.domain.inventory.events.InventoryCreated;
import hotelddd.tewar.domain.inventory.events.UpdatedInventory;
import hotelddd.tewar.domain.inventory.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateInventoryUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    public void updateResource() {
        var inventoryId = InventoryId.of("1515");
        var food = new Food(FoodId.of("312"), new Name("Banana party"), new Stock(50), Category.PERECEDERO);
        var utensil = new Utensil(UtensilId.of("777"), new Name("Platos Roche"), new Brand("Roche"), new Stock(20));

        var command = new UpdateInventory(inventoryId, food, utensil);
        var useCase = new UpdateInventoryUseCase();
        useCase.addRepository(repository);

        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(events());

        List<DomainEvent> events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command)).
                orElseThrow().
                getDomainEvents();

        Mockito.verify(repository).getEventsBy(Mockito.any());

        UpdatedInventory updatedInventory = (UpdatedInventory) events.get(0);

        assertEquals("Banana party", updatedInventory.getFood().getName().value());
        assertEquals(50, updatedInventory.getFood().getStock().value());
        assertEquals("Platos Roche", updatedInventory.getUtensil().getName().value());
        assertEquals("Roche", updatedInventory.getUtensil().getBrand().value());
        assertEquals(20, updatedInventory.getUtensil().getStock().value());



    }

    private List<DomainEvent> events() {
        return List.of(new InventoryCreated(new Food(FoodId.of("1516"),
                new Name("Hamburguesa"),
                new Stock(4),
                Category.PERECEDERO),
                new Utensil(UtensilId.of("123"),
                        new Name("Platos Rock"),
                        new Brand("Rock"),
                        new Stock(50))));
    }


}