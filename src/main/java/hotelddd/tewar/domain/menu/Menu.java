package hotelddd.tewar.domain.menu;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.menu.entities.Plate;
import hotelddd.tewar.domain.menu.event.MenuCreated;
import hotelddd.tewar.domain.menu.event.UpdatedMenu;
import hotelddd.tewar.domain.menu.values.MenuId;

import java.util.List;

public class Menu extends AggregateEvent<MenuId> {
    protected Plate plate;
    protected Name name;

    public Menu(MenuId entityId, Plate plate, Name name) {
        super(entityId);
        appendChange(new MenuCreated(plate,name)).apply();
    }

    private Menu(MenuId entityId) {
        super(entityId);
        subscribe(new MenuEventChange(this));
    }

    public static Menu from(MenuId entityId, List<DomainEvent> events){
        var menu = new Menu(entityId);
        events.forEach(menu::applyEvent);
        return menu;
    }

    public void updateMenu(MenuId entityId, Plate plate, Name name){
        appendChange(new UpdatedMenu(entityId,plate,name)).apply();
    }
}
