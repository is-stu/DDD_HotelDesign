package hotelddd.tewar.domain.kitchen.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Experience implements ValueObject<Integer> {

    private final Integer experience;

    public Experience(Integer experience) {
        this.experience = Objects.requireNonNull(experience);
    }

    public Experience increaseExperience(Integer value){
        return new Experience(experience + value);
    }

    @Override
    public Integer value() {
        return experience;
    }
}
