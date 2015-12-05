package pe.edu.upc.bean.parse;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by Ronny on 04/12/2015.
 */
@ParseClassName("Rental")
public class RentalObject extends ParseObject {
    public CarObject getIdUSerCar() {
        CarObject c = null;
        try {
            c = (CarObject)getParseObject("IdCar").fetchIfNeeded();
        }catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }

    public void setIdCar(CarObject idCar) {
        put("IdCar", idCar);
    }


    public UserObject getIdUSer() {
        UserObject u = null;
        try {
            u = (UserObject)getParseObject("IdUSer").fetchIfNeeded();
        }catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }

    public void setIdUSer(UserObject idUSer) {
        put("IdUSer", idUSer);
    }

    public UserObject getIdAdmRental() {
        UserObject u = null;
        try {
            u = (UserObject)getParseObject("IdAdmRental").fetchIfNeeded();
        }catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }

    public void setIdAdmRental(UserObject idAdmRental) {
        put("IdAdmRental", idAdmRental);
    }

    public UserObject getIdAdmDevol() {
        UserObject u = null;
        try {
            u = (UserObject)getParseObject("IdAdmDevol").fetchIfNeeded();
        }catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }

    public void setIdAdmDevol(UserObject idAdmDevol) {
        put("IdAdmDevol", idAdmDevol);
    }

    public Date getInitDate() {
        return getDate("InitDate");
    }

    public void setInitDate(Date initDate) {
        put("InitDate", initDate);
    }

    public int getDays() {
        return getInt("Days");
    }

    public void setDays(int days) {
        put("Days", days);
    }

    public Date getDateDevolution() {
        return getDate("DateDevolution");
    }

    public void setDateDevolution(Date dateDevolution) {
        put("DateDevolution", dateDevolution);
    }

    public double getTotal() {
        return getDouble("Total");
    }

    public void setTotal(double total) {
        put("Total", total);
    }

    public double getPenalty() {
        return getDouble("Penalty");
    }

    public void setPenalty(double penalty) {
        put("Penalty", penalty);
    }

    public int getStatus() {
        return getInt("Status");
    }

    public void setStatus(int status) {
        put("Status", status);
    }
}
