package hotelddd.tewar.domain.kitchen.values;

import co.com.sofka.domain.generic.Identity;

public class WorkerId extends Identity {

    private WorkerId(String uuid) {
        super(uuid);
    }

    public WorkerId() {
    }

    public static WorkerId of(String uuid){
        return new WorkerId(uuid);
    }
}
