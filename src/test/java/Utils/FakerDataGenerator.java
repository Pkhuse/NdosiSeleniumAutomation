package Utils;
import com.github.javafaker.Faker;

public class FakerDataGenerator {

    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().emailAddress();
    public static String password = faker.internet().password(8,16);
    // public static String address = faker.address().cityName();


    public String firstName() {
        return firstName;
    }
    public String lastName() {
        return lastName;
    }
    public String email()
    {
        return email;
    }
    public String password()
    {
        return password;
    }
}


