package com.utility;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

import java.util.Locale;

public class FakeAddressUtility {

    public static AddressPOJO getFakeAddress()
    {
        Faker faker = new Faker(Locale.US);
        return new AddressPOJO(faker.company().name(), faker.address().buildingNumber(), faker.address().streetAddress(), faker.address().cityName(),
                faker.numerify("#####"), faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(),
                "Other Info", "Office Address", faker.address().state());
    }

}
