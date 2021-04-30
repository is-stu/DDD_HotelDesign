package hotelddd.tewar.domain.menu.values;

import co.com.sofka.domain.generic.Identity;

public class MenuId extends Identity {

    private MenuId(String uuid) {
        super(uuid);
    }

    public MenuId() {
    }

    public static MenuId of(String uid){
        return new MenuId(uid);
    }
}
