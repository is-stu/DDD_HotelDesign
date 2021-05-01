package hotelddd.tewar.domain.kitchen.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Phone implements ValueObject<String> {

    private final String phone;

    public Phone(String phone) {
        this.phone = Objects.requireNonNull(phone);
    }

    @Override
    public String value() {
        return phone;
    }
}
