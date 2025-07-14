public class Customer {
    private String name;
    private int customerID;
    private String email;
    private String location;

    Customer(String name, String email, String location){
        this.name = name;
        this.email = email;
        this.location = location;
        //add code for generating dynamic id
//        this.customerID = (int)Math.random();
    }
}
