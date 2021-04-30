package hotelddd.tewar.domain.menu.values;

import co.com.sofka.domain.generic.ValueObject;

public class Price implements ValueObject<Double> {

    private final Double price;

    public Price(Double price) {
        this.price = price;
    }

    @Override
    public Double value() {
        return price;
    }

}
