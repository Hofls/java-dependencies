package hofls.com.github.nullsafe;

import hofls.com.github.nullsafe.types.Address;

import java.util.Objects;

public class NullComparison {

    public boolean comparison_GOOD(Address addressA, Address addressB) {
        return Objects.equals(addressA, addressB);
    }

    public boolean comparison_BAD(Address addressA, Address addressB) {
        return addressA.equals(addressB);
    }

}
