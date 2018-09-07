package org.ontology.processor.models.requests;

import org.ontology.processor.utils.Queries;
import org.ontology.processor.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thisura on 6/23/18.
 */
@SuppressWarnings("Duplicates")
public class Relationship {

    private String rel_name;
    private Node source;
    private Node destination;
    private ArrayList<Property> rel_properties;
    private String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRel_name() {
        return rel_name;
    }

    public void setRel_name(String rel_name) {
        this.rel_name = rel_name;
    }

    public ArrayList<Property> getRel_properties() {
        return rel_properties;
    }

    public void setRel_properties(ArrayList<Property> rel_properties) {
        this.rel_properties = rel_properties;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public String getPropertiesStr(){
        String str = "{$props}";
        List<String> relPropBuilder = new ArrayList<String>();
        for (Property prop: rel_properties){
            String relPropStr;
            if(Utils.isFloat(prop.getProp_value())){
                relPropStr = "`$prop_name`:$prop_val";
            }
            else{
                relPropStr = "`$prop_name`:'$prop_val'";
            }
            relPropStr = relPropStr.replace("$prop_name", prop.getProp_name());
            relPropStr = relPropStr.replace("$prop_val", prop.getProp_value());
            relPropBuilder.add(relPropStr);
        }
        String relPropStr = String.join(",", relPropBuilder);
        str = str.replace("$props", relPropStr);
        return str;

    }


    public String getRelationCreateQuery(){
        String relQuery = Queries.CREATE_RELATIONSHIP;

        relQuery = relQuery.replace("$SourceType", source.getName()).replace("$sourcePropStr", source.getPropertiesStr());
        relQuery = relQuery.replace("$destType", destination.getName()).replace("$destPropStr", destination
                .getPropertiesStr());
        String dirSrc = "-";
        String dirDest = "-";
        if (direction.equals("out")) {
            dirDest = "->";
        } else if (direction.equals("in")) {
            dirSrc = "<-";
        }
        relQuery = relQuery.replace("$dirSrc", dirSrc).replace("$dirDest", dirDest);
        relQuery = relQuery.replace("$relName", rel_name).replace("$relProps", getPropertiesStr());
        return relQuery;
    }
}
