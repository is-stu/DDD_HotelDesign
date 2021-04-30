package hotelddd.tewar.domain.generalValues;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Stock implements ValueObject<Integer> {

    private final Integer stock;

    public Stock(Integer stock) {
        this.stock = Objects.requireNonNull(stock);
    }

    @Override
    public Integer value() {
        return stock;
    }
}
