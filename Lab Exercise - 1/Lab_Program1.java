class Consultancy_Firm {
    private String Name;
    private String Location;
    private String Email;
    private long phno;

    // Constructor Overloading
    public Consultancy_Firm(String name, String location) {
        this.Name = name;
        this.Location = location;
    }

    public Consultancy_Firm(String email, String name, String location) {
        this(name, location);
        this.Email = email;
    }

    public Consultancy_Firm(long phno, String email, String name, String location) {
        this(email, name, location);
        this.phno = phno;
    }

    // Method Overloading
    public long Display() {
        return this.phno;
    }

    public void Display(String name, String location) {
        System.out.println(
                "\nFirm Name:" + name + "\nLocation:" + location);
    }

    public void Display(String email) {
        System.out.println("Email: " + email);
    }

    public static void main(String[] args) {
        long phone1, phone2;
        System.out.println("\nConsultancy Firm 1:");
        Consultancy_Firm cf1 = new Consultancy_Firm(1234567891, "apex@gmail.org", "Apex Consultancy Group",
                "Bengaluru");
        cf1.Display(cf1.Name, cf1.Location);
        cf1.Display(cf1.Email);
        phone1 = cf1.Display();
        System.out.println("Phone:" + phone1);
        System.out.println("\n");

        System.out.println("\nConsultancy Firm 2:");
        Consultancy_Firm cf2 = new Consultancy_Firm(1153647589, "rockstar@yahoo.org", "Rockstar Consultancy Group",
                "Hyderabad");
        cf2.Display(cf2.Name, cf2.Location);
        cf2.Display(cf2.Email);
        phone2 = cf2.Display();
        System.out.println("Phone:" + phone2);
        System.out.println("\n");
    }

}