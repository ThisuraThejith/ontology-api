package org.ontology.processor.services;

import org.neo4j.ogm.model.Result;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

/**
 * Created by thisura on 6/22/18.
 */
@Service
public class NeoService {

    @Autowired
    private Neo4jOperations neo4jOperations;

    public Result execute(String query){
        Result result= neo4jOperations.query(query, Collections.emptyMap());
        return result;
    }

}
