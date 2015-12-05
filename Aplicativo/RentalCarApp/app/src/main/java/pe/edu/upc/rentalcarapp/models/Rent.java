package pe.edu.upc.rentalcarapp.models;

/**
 * Created by Aldo Pizarro on 04/12/2015.
 */
public class Rent {

    private String trademarkCar;
    private String modelCar;
    private String yearCar;
    private String colorCar;
    private String descriptionCar;
    private String pictureUrlCar;
    private String stateRent;

    public Rent(String trademarkCar) {

    }

    public Rent(String trademarkCar, String modelCar, String yearCar, String colorCar, String descriptionCar, String pictureUrlCar, String stateRent) {
        this.trademarkCar = trademarkCar;
        this.modelCar = modelCar;
        this.yearCar = yearCar;
        this.colorCar = colorCar;
        this.descriptionCar = descriptionCar;
        this.pictureUrlCar = pictureUrlCar;
        this.stateRent = stateRent;
    }

    public String getTrademarkCar() {
        return trademarkCar;
    }

    public void setTrademarkCar(String trademarkCar) {
        this.trademarkCar = trademarkCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getYearCar() {
        return yearCar;
    }

    public void setYearCar(String yearCar) {
        this.yearCar = yearCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public String getDescriptionCar() {
        return descriptionCar;
    }

    public void setDescriptionCar(String descriptionCar) {
        this.descriptionCar = descriptionCar;
    }

    public String getPictureUrlCar() {
        return pictureUrlCar;
    }

    public void setPictureUrlCar(String pictureUrlCar) {
        this.pictureUrlCar = pictureUrlCar;
    }

    public String getStateRent() {
        return stateRent;
    }

    public void setStateRent(String stateRent) {
        this.stateRent = stateRent;
    }
}
