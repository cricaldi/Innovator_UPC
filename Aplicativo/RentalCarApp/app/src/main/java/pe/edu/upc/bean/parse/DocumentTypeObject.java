package pe.edu.upc.bean.parse;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Ronny on 04/12/2015.
 */
@ParseClassName("DocumentType")
public class DocumentTypeObject extends ParseObject {

    public String getName() {
        return getString("Name");
    }

    public void setName(String name) {
        put("Name", name);
    }

}