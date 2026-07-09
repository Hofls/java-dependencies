package com.github.hofls.nullsafe;

import com.github.hofls.nullsafe.types.Address;
import com.github.hofls.nullsafe.types.Area;
import com.github.hofls.nullsafe.types.CustomType;

import java.util.Optional;

import static com.github.hofls.nullsafe.NullUtils.safe;

public class NullCheckDemo {

    public static String getAreaName_BEST_EXAMPLE(Address address) {
        return safe(() -> address.getCustomType().getArea().getName());
    }

    public static String getAreaName_MEDIOCRE_EXAMPLE(Address address) {
        return Optional.ofNullable(address)
                .map(Address::getCustomType)
                .map(CustomType::getArea)
                .map(Area::getName)
                .orElse(null);
    }

    public static String getAreaName_BAD_EXAMPLE(Address address) {
        if (address != null
                && address.getCustomType() != null
                && address.getCustomType().getArea() != null
                && address.getCustomType().getArea().getName() != null) {
            return address.getCustomType().getArea().getName();
        } else {
            return null;
        }
    }



}
