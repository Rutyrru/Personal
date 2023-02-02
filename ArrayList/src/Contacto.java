public class Contacto {
    String  Name;
    String PhoneNumber;

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public Contacto(String name, String phoneNumber) {
        Name = name;
        PhoneNumber = phoneNumber;
    }
    public static Contacto createContact(String Name,String PhoneNumber){

        return new Contacto(Name,PhoneNumber);
    }

}
