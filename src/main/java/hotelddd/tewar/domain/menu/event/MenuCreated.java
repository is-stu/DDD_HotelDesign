package hotelddd.tewar.domain.menu.event;

import co.com.sofka.domain.generic.DomainEvent;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.menu.entities.Plate;

public class MenuCreated extends DomainEvent {
    private final Plate plate;
    private final Name name;

    public MenuCreated(Plate plate, Name name) {
        super("create.menu.createMenu");
        this.plate = plate;
        this.name = name;
    }

    public Plate getPlate() {
        return plate;
    }

    public Name getName() {
        return name;
    }
}
