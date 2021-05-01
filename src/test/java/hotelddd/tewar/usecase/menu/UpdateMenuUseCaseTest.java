package hotelddd.tewar.usecase.menu;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.kitchen.events.UpdatedKitchen;
import hotelddd.tewar.domain.menu.command.UpdateMenu;
import hotelddd.tewar.domain.menu.entities.Plate;
import hotelddd.tewar.domain.menu.event.MenuCreated;
import hotelddd.tewar.domain.menu.event.UpdatedMenu;
import hotelddd.tewar.domain.menu.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateMenuUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    public void updateMenu() {
        var menuId = MenuId.of("111");
        var plate = new Plate(PlateId.of("312"),
                new Price(3500.0),
                new Name("Patacon"),
                new Description("Rico patacon"),
                KindFood.COMUN);
        var name = new Name("Pata Happy");


        var command = new UpdateMenu(menuId, plate, name);
        var useCase = new UpdateMenuUseCase();

        useCase.addRepository(repository);

        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(events());

        List<DomainEvent> events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command)).
                orElseThrow().
                getDomainEvents();

        Mockito.verify(repository).getEventsBy(Mockito.any());

        UpdatedMenu updatedMenu = (UpdatedMenu) events.get(0);

        assertEquals(3500.0, updatedMenu.getPlate().getPrice().value());
        assertEquals("Patacon", updatedMenu.getPlate().getName().value());
        assertEquals("Rico patacon", updatedMenu.getPlate().getDescription().value());
        assertEquals(KindFood.COMUN, updatedMenu.getPlate().getKindFood());

    }

    private List<DomainEvent> events() {
        return List.of(
                new MenuCreated(
                        new Plate(PlateId.of("01"),
                                new Price(1000.0),
                                new Name("Yuca"),
                                new Description("Yuca buena"),
                                KindFood.COMUN),
                        new Name("Journey Yuca")
                        )
        );
    }

}