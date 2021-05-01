package hotelddd.tewar.usecase.menu;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.menu.command.CreateMenu;
import hotelddd.tewar.domain.menu.entities.Plate;
import hotelddd.tewar.domain.menu.event.MenuCreated;
import hotelddd.tewar.domain.menu.values.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateMenuUseCaseTest {

    @Test
    public void createMenu() {

        var menuId = MenuId.of("2525");
        var plate = new Plate(PlateId.of("2211"),
                new Price(12000.0),
                new Name("Hambur Travel"),
                new Description("Food"),
                KindFood.COMUN);

        var command = new CreateMenu(menuId,plate,new Name("Astral Journey"));

        var useCase = new CreateMenuUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command)).
                orElseThrow().
                getDomainEvents();

        MenuCreated menuCreated = (MenuCreated) events.get(0);

        assertEquals("Hambur Travel", menuCreated.getPlate().getName().value());
        assertEquals("Food", menuCreated.getPlate().getDescription().value());
        assertEquals(KindFood.COMUN, menuCreated.getPlate().getKindFood());
        assertEquals("Astral Journey", menuCreated.getName().value());



    }

}