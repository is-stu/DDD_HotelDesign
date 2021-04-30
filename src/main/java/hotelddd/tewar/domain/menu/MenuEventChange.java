package hotelddd.tewar.domain.menu;

import co.com.sofka.domain.generic.EventChange;
import hotelddd.tewar.domain.menu.event.MenuCreated;

public class MenuEventChange extends EventChange {
    public MenuEventChange(Menu menu) {
        apply((MenuCreated event)->{
            menu.name = event.getName();
            menu.plate = event.getPlate();
        });
    }
}
