package hotelddd.tewar.usecase.inventory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.generalValues.Stock;
import hotelddd.tewar.domain.inventory.command.CreateInventory;
import hotelddd.tewar.domain.inventory.entities.Food;
import hotelddd.tewar.domain.inventory.entities.Utensil;
import hotelddd.tewar.domain.inventory.events.InventoryCreated;
import hotelddd.tewar.domain.inventory.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateInventoryUseCaseTest {

    @Test
    public void createInventory() {
        var invetoryId = InventoryId.of("123");
        var food = new Food(FoodId.of("1"), new Name("Hamburguesa"), new Stock(5), Category.NO_PERECEDERO);
        var utensil = new Utensil(UtensilId.of("0201"), new Name("Platos Royele"), new Brand("Royele"), new Stock(25));

        var command = new CreateInventory(invetoryId, food, utensil);
        var useCase = new CreateInventoryUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command)).
                orElseThrow().
                getDomainEvents();

        InventoryCreated inventoryCreated = (InventoryCreated) events.get(0);


        assertEquals("Hamburguesa",inventoryCreated.getFood().getName().value());
        assertEquals(5,inventoryCreated.getFood().getStock().value());
        assertEquals("Platos Royele",inventoryCreated.getUtensil().getName().value());
        assertEquals("Royele",inventoryCreated.getUtensil().getBrand().value());
        assertEquals(25,inventoryCreated.getUtensil().getStock().value());


    }

}