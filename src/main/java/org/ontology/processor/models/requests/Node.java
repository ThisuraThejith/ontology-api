package org.ontology.processor.models.requests;


import org.ontology.processor.utils.Queries;

import java.util.ArrayList;
import java.util.List;
import org.ontology.processor.utils.Utils;
/**
 * Created by thisura on 6/22/18.
 */

@SuppressWarnings("Duplicates")
public class Node {

    private String name;
    private ArrayList<Property> properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    //Creating a node
    public String getCreateQuery(){
        String query = Queries.CREATE_NODE;
        List<String> propBuilder = new ArrayList<String>();
        for (Property prop: properties){
            String propStr;
            if(Utils.isFloat(prop.getProp_value())){
                propStr = "`$prop_name`:$prop_val";
            }
            else{
                propStr = "`$prop_name`:'$prop_val'";
            }

            propStr = propStr.replace("$prop_name", prop.getProp_name());
            propStr = propStr.replace("$prop_val", prop.getProp_value());
            propBuilder.add(propStr);
        }
        String nodePropStr = String.join(",", propBuilder);
        query = query.replace("$nodeLabel", name);
        query = query.replace("$nodeProperties", nodePropStr);
        return query;
    }


    public String getPropertiesStr(){
        String str = "{$props}";
        List<String> propBuilder = new ArrayList<String>();
        for (Property prop: properties){
            String propStr = "`$prop_name`:'$prop_val'";
            propStr = propStr.replace("$prop_name", prop.getProp_name());
            propStr = propStr.replace("$prop_val", prop.getProp_value());
            propBuilder.add(propStr);
        }
        String nodePropStr = String.join(",", propBuilder);
        str = str.replace("$props", nodePropStr);
        return str;
    }
}
