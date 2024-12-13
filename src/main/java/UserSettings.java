public class UserSettings {

    private User user; // UserSetting "has-a" relationship
    private static String businessName = "not provided yet";
    private static String contactPerson = "not provided yet";
    private static String email = "not provided yet";
    private static String address = "not provided yet";
    private static int postalCode = 0;
    private static String city = "not provided yet";
    private static String country = "not provided yet";
    private static int CVRnr = 0;

    public UserSettings() {
        this.user = user;
    }

    public static String getBusinessName(){
        return businessName;
    }

    public User getAccount() {
        return user;
    }

    public static void setBusinessName(String business){
        businessName = business;
    }

    public static String getContactPerson(){
        return contactPerson;
    }

    public static void setContactPerson(String contactPerson){
        contactPerson = contactPerson;
    }

    public static String getEmail(){
        return email;
    }

    public static void setEmail(String email){
        email = email;
    }

    public static String getAddress(){
        return address;
    }

    public static void setAddress(String address){
        address = address;
    }

    public static int getPostalCode(){
        return postalCode;
    }

    public static void setPostalCode(int postalCode){
        postalCode = postalCode;
    }

    public static String getCity(){
        return city;
    }

    public static void setCity(String city){
        city = city;
    }

    public static String getCountry(){
        return country;
    }

    public static void setCountry(String country){
        country = country;
    }

    public static int getCVRnr(){
        return CVRnr;
    }

    public static void setCVRnr(int CVRnr){
        CVRnr = CVRnr;
    }

    public String toString(){
        //Provides a readable string/int
        return String.format(" Username: %s\n Business:%s\n Contact Person: %s\n Email: %s\n Address: %s\n Postal Code: %d\n City: %s\n Country: %s\n CVR Number: %d");
    }
}
