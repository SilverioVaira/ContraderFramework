package main.model;

public class User {

    private int idUser;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String fiscalCode;
    private String dateOfBirth;
    private String businessName;
    private String vat;
    private String town;
    private String postCode;
    private String city;
    private String address;
    private String telephone;
    private String role;

    public User(int idUser, String username, String password, String firstName, String lastName, String fiscalCode, String dateOfBirth, String businessName, String vat, String town, String postCode, String city, String address, String telephone, String role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fiscalCode = fiscalCode;
        this.dateOfBirth = dateOfBirth;
        this.businessName = businessName;
        this.vat = vat;
        this.town = town;
        this.postCode = postCode;
        this.city = city;
        this.address = address;
        this.telephone = telephone;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (fiscalCode != null ? !fiscalCode.equals(user.fiscalCode) : user.fiscalCode != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(user.dateOfBirth) : user.dateOfBirth != null) return false;
        if (businessName != null ? !businessName.equals(user.businessName) : user.businessName != null) return false;
        if (vat != null ? !vat.equals(user.vat) : user.vat != null) return false;
        if (town != null ? !town.equals(user.town) : user.town != null) return false;
        if (postCode != null ? !postCode.equals(user.postCode) : user.postCode != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (telephone != null ? !telephone.equals(user.telephone) : user.telephone != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (fiscalCode != null ? fiscalCode.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (businessName != null ? businessName.hashCode() : 0);
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "IdUser: " + idUser + "\n" +
                "Username: " + username + "\n" +
                "Password: " + password + "\n" +
                "FirstName: " + firstName + "\n" +
                "LastName: " + lastName + "\n" +
                "FiscalCode: " + fiscalCode + "\n" +
                "DateOfBirth: " + dateOfBirth + "\n" +
                "BusinessName: " + businessName + "\n" +
                "Fat: " + vat + "\n" +
                "Town: " + town + "\n" +
                "PostCode: " + postCode + "\n" +
                "City: " + city + "\n" +
                "Address: " + address + "\n" +
                "Telephone: " + telephone + "\n" +
                "Role: " + role + "\n"
                ;
    }
}
