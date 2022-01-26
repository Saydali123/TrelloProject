package uz.Mongo.b3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@ToString
@Getter
@Setter

public class Address {
    private String province;
    private String region;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return province.equals(address.province) && region.equals(address.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(province, region);
    }
}
