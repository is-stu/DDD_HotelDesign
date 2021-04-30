package hotelddd.tewar.domain.inventory.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Brand implements ValueObject<String> {

    private final String brand;

    public Brand(String brand) {
        this.brand = Objects.requireNonNull(brand);
        if(brand.isBlank()){
            throw new IllegalArgumentException("La marca del producto no puede estar vacía");
        }
    }

    @Override
    public String value() {
        return brand;
    }
}
