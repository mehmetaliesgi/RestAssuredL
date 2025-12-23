package utils;

import net.datafaker.Faker;

import java.util.concurrent.TimeUnit;

public class RandomDataGenerator {

    public static Faker faker = new Faker();

    public static String getRandomDataFor(RandomDataTypeNames randomDataTypeNames) {
        return switch (randomDataTypeNames) {
            case FIRST_NAME -> faker.name().firstName();
            case LAST_NAME -> faker.name().lastName();
            case ADDITIONAL_NEEDS -> faker.food().dish();
            case CHECK_IN -> faker.timeAndDate().future(1, TimeUnit.DAYS, "yyyy-MM-dd");
            case CHECK_OUT ->  faker.timeAndDate().future(7, TimeUnit.DAYS, "yyyy-MM-dd");
            default -> "";
        };
    }

    public static int getRandomIntDataFor(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    public static boolean getRandomBooleanDataFor() {
        return faker.bool().bool();
    }
}
