package org.ontology.processor.models.responses;

import java.util.HashMap;

/**
 * Created by thisura on 7/2/18.
 */
public class Relationship {
    private Node source;
    private Node dest;
    private HashMap<String,String> properties;

    public Relationship(Node source,Node dest){
        this.source=source;
        this.dest =dest;
    }
}