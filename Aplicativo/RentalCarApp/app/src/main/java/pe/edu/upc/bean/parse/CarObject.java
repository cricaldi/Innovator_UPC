package pe.edu.upc.bean.parse;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Ronny on 04/12/2015.
 */
@ParseClassName("Car")
public class CarObject extends ParseObject{

    public Double getPrice() {
        return getDouble("Price");
    }

    public void setPrice(double price) {
        put("Price", price);
    }

    public String getDescription() {
        return getString("Description");
    }

    public void setDescription(String description) {
        put("Description", description);
    }

    public BrandObject getIdBrand() {
        BrandObject b = null;
        try {
            b = (BrandObject)getParseObject("IdBrand").fetchIfNeeded();
        }catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }

    public void setIdBrand(BrandObject brand) {
        put("IdBrand", brand);
    }

    public ModelObject getIdModel() {
        ModelObject m = null;
        try {
            m = (ModelObject)getParseObject("IdModel").fetchIfNeeded();
        }catch (Exception e){
            e.printStackTrace();
        }
        return m;
    }

    public void setIdModel(ModelObject model) {
        put("IdModel", model);
    }
}
