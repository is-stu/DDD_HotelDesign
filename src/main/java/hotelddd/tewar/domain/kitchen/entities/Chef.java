package hotelddd.tewar.domain.kitchen.entities;

import co.com.sofka.domain.generic.Entity;
import hotelddd.tewar.domain.generalValues.Name;
import hotelddd.tewar.domain.kitchen.values.Experience;
import hotelddd.tewar.domain.kitchen.values.Phone;
import hotelddd.tewar.domain.kitchen.values.Special;
import hotelddd.tewar.domain.kitchen.values.WorkerId;

public class Chef extends Entity<WorkerId> {

    private final Name name;
    private Phone phone;
    private Experience experience;
    private Special special;

    public Chef(WorkerId entityId, Name name, Phone phone, Experience experience, Special special) {
        super(entityId);
        this.name = name;
        this.phone = phone;
        this.experience = experience;
        this.special = special;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Experience getExperience() {
        return experience;
    }

    public Special getSpecial() {
        return special;
    }

    public void increaseExperience(){
        this.experience = experience.increaseExperience(experience.value());
    }
}
