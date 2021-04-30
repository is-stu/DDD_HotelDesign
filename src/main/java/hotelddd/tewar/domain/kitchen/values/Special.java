package hotelddd.tewar.domain.kitchen.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Special implements ValueObject<String> {

    private final String special;

    public Special(String special) {
        this.special = Objects.requireNonNull(special);
    }

    @Override
    public String value() {
        return special;
    }
}
