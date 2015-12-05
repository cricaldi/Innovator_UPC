package pe.edu.upc.bean;

import java.util.Date;

import pe.edu.upc.bean.parse.UserObject;

/**
 * Created by Ronny on 05/12/2015.
 */
public class Rental {
    private String objectIdUSer;
    private String objectIdAdmRental;
    private String objectIdAdmDevol;
    private String objectIdCar;
    private Date initDate;
    private int days;
    private Date dateDevolution;
    private double total;
    private double penalty;
    private int status;

    public String getObjectIdUSer() {
        return objectIdUSer;
    }

    public void setObjectIdUSer(String objectIdUSer) {
        this.objectIdUSer = objectIdUSer;
    }

    public String getObjectIdAdmRental() {
        return objectIdAdmRental;
    }

    public void setObjectIdAdmRental(String objectIdAdmRental) {
        this.objectIdAdmRental = objectIdAdmRental;
    }

    public String getObjectIdAdmDevol() {
        return objectIdAdmDevol;
    }

    public void setObjectIdAdmDevol(String objectIdAdmDevol) {
        this.objectIdAdmDevol = objectIdAdmDevol;
    }

    public String getObjectIdCar() {
        return objectIdCar;
    }

    public void setObjectIdCar(String objectIdCar) {
        this.objectIdCar = objectIdCar;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Date getDateDevolution() {
        return dateDevolution;
    }

    public void setDateDevolution(Date dateDevolution) {
        this.dateDevolution = dateDevolution;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
