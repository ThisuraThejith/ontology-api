package org.ontology.processor.models.requests;

/**
 * Created by thisura on 6/23/18.
 */
public class Property {
    private String prop_name;
    private String prop_value;

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public String getProp_value() {
        return prop_value;
    }

    public void setProp_value(String prop_value) {
        this.prop_value = prop_value;
    }
}
