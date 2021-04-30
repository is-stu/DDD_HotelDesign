package hotelddd.tewar.domain.kitchen.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Dimension implements ValueObject<Double>{

    private final Double dimension;

    public Dimension(Double dimension) {
        this.dimension = Objects.requireNonNull(dimension);
    }

    @Override
    public Double value() {
        return dimension;
    }
}
