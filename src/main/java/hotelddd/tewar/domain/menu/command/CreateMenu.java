package hotelddd.tewar.domain.menu.command;

import co.com.sofka.domain.generic.Command;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.menu.entities.Plate;
import hotelddd.tewar.domain.menu.values.MenuId;

public class CreateMenu implements Command {

    private final MenuId menuId;
    private final Plate plate;
    private final Name name;

    public CreateMenu(MenuId entityId, Plate plate, Name name) {
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
