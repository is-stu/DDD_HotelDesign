package hotelddd.tewar.domain.menu.values;

import co.com.sofka.domain.generic.Identity;

public class PlateId extends Identity {

    private PlateId(String uuid) {
        super(uuid);
    }

    private PlateId() {
    }

    public static PlateId of(String uid){
        return new PlateId(uid);
    }

}
