package pe.edu.upc.bean;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Ronny on 04/12/2015.
 */
@ParseClassName("User")
public class User extends ParseObject {

    public String getFirstName() {
        return getString("FirstName");
    }

    public void setFirstName(String firstName) {
        put("FirstName", firstName);
    }

    public String getLastName() {
        return getString("LastName");
    }

    public void setLastName(String lastName) {
        put("LastName", lastName);
    }

    public String getPhone() {
        return getString("Phone");
    }

    public void setPhone(String phone) {
        put("Phone", phone);
    }

    public String getEmail() {
        return getString("Email");
    }

    public void setEmail(String email) {
        put("Email", email);
    }

    public String getPassword() {
        return getString("Password");
    }

    public void setPassword(String password) {
        put("Password", password);
    }

    public String getAddress() {
        return getString("Address");
    }

    public void setAddress(String address) {
        put("Address", address);
    }

    public String getDocumentNumber() {
        return getString("DocumentNumber");
    }

    public void setDocumentNumber(String documentNumber) {
        put("DocumentNumber", documentNumber);
    }

    public Role getIdRole() {
        return (Role)getParseObject("IdRole");
    }

    public void setIdRole(Role role) {
        put("IdRole", role);
    }

}
