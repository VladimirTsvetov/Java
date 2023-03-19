package personbuilder;

public class Main {
    public static void main(String[] args) {
        /*
           Создать builder для класса Person со следующими полями:
           String firstName,
           String lastName,
           String middleName,
           String country,
           String address,
           String phone,
           int age,
           String gender.
       */
        Person person = new Person
                .Builder()
                .withFirstName("Василий")
                .withLastName("Чапаев")
                .withMiddleName("Иванович")
                .withAddress("река Урал")
                .withAge(32)
                .withCountry("Россия")
                .withGender("брутальный мужик")
                .build();

        System.out.println(person);


    }
}