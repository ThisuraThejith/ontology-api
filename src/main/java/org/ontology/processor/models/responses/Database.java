package org.ontology.processor.models.responses;

import org.neo4j.ogm.response.model.NodeModel;
import org.neo4j.ogm.response.model.RelationshipModel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by thisura on 7/2/18.
 */
public class Database {
    private HashMap<Long, NodeModel> nodes;
    private ArrayList<RelationshipModel> relationships;

    public Database() {
        this.nodes = new HashMap<>();
        this.relationships = new ArrayList<>();
    }

    public HashMap<Long, NodeModel> getNodes() {
        return nodes;
    }

    public void addNode(NodeModel node) {
        if (!this.nodes.containsKey(node.getId())) {
            this.nodes.put(node.getId(), node);
        }
    }

    public void setNodes(HashMap<Long, NodeModel> nodes) {
        this.nodes = nodes;
    }

    public void addRelation(RelationshipModel relation) {
        this.relationships.add(relation);
    }

    public ArrayList<RelationshipModel> getRelationships() {
        return relationships;
    }

    public void setRelationships(ArrayList<RelationshipModel> relationships) {
        this.relationships = relationships;
    }
}
