package hotelddd.tewar.domain.kitchen.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Phone implements ValueObject<Integer> {

    private final Integer phone;

    public Phone(Integer phone) {
        this.phone = Objects.requireNonNull(phone);
    }

    @Override
    public Integer value() {
        return phone;
    }
}
