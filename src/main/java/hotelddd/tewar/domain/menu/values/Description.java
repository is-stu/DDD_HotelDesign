package hotelddd.tewar.domain.menu.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Description implements ValueObject<String> {

    private final String description;

    public Description(String description) {
        this.description = Objects.requireNonNull(description);
        if(description.isBlank()){
            throw new IllegalArgumentException("La descripcion no puede estar vacía");
        }
    }

    @Override
    public String value() {
        return description;
    }
}
