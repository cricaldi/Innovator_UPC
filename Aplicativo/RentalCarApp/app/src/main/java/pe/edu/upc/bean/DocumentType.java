package pe.edu.upc.bean;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Ronny on 04/12/2015.
 */
@ParseClassName("DocumentType")
public class DocumentType extends ParseObject {

    public String getName() {
        return getString("Name");
    }

    public void setName(String name) {
        put("Name", name);
    }

}