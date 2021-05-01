package hotelddd.tewar.domain.menu.event;

import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.menu.entities.Plate;
import hotelddd.tewar.domain.menu.values.MenuId;

public class UpdatedMenu extends DomainEvent {
    private final MenuId menuId;
    private final Plate plate;
    private final Name name;

    public UpdatedMenu(MenuId entityId, Plate plate, Name name) {
        super("update.menu.updateMenu");
        menuId = entityId;
        this.plate = plate;
        this.name = name;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public Plate getPlate() {
        return plate;
    }

    public Name getName() {
        return name;
    }
}
