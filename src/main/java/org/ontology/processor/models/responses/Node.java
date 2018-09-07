package org.ontology.processor.models.responses;

import java.util.HashMap;

/**
 * Created by thisura on 7/2/18.
 */

public class Node {

    private Long id;
    private HashMap <String,String> properties;

    public Node(Long id,HashMap<String,String> properties){
        this.id=id;
        this.properties=properties;
    }
}
