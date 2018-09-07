package org.ontology.processor.controller;

import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.response.model.NodeModel;
import org.neo4j.ogm.response.model.RelationshipModel;
import org.ontology.processor.models.requests.RelationshipInfo;
import org.ontology.processor.models.responses.Database;
import org.ontology.processor.utils.Constants;
import org.ontology.processor.utils.Queries;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.ontology.processor.models.requests.NodeInfo;
import org.ontology.processor.services.NeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by thisura on 6/22/18.
 */
//(origins = "http://localhost:4200")
@CrossOrigin
@RestController
@SuppressWarnings("Duplicates")
@RequestMapping("ontology")
public class OntologyController {

    @Autowired
    private NeoService neoService;

	@RequestMapping(value = Constants.RequestUri.Node.GET_NODE, headers = "Accept=application/json", method =
			RequestMethod.POST, produces = "application/json")
	public void getNode(@RequestBody NodeInfo nodeInfo) {
		String query = nodeInfo.getNodeInfo().getCreateQuery();
		this.neoService.execute(query);
	}

	@RequestMapping(value = Constants.RequestUri.Relationship.GET_RELATIONSHIP, headers = "Accept=application/json", method =
			RequestMethod.POST, produces = "application/json")
	public void getRelationship(@RequestBody RelationshipInfo relationshipInfo) {
		String query = relationshipInfo.getRelationshipInfo().getRelationCreateQuery();
		this.neoService.execute(query);
	}


	@RequestMapping(value = Constants.RequestUri.Database.GET_DATABASE, headers = "Accept=application/json", method =
			RequestMethod.GET, produces = "application/json")
	public Database getDatabase() {
        String query = Queries.GET_DATABASE_QUERY;
        Result result = this.neoService.execute(query);
        Database database = new Database();

        result.queryResults().forEach( a-> {
				NodeModel source = (NodeModel)a.get("n");
				RelationshipModel rel = (RelationshipModel)a.get("r");
				NodeModel dest = (NodeModel)a.get("m");
				if (source != null) {
					database.addNode(source);
				} else {
					return;
				}
				if (rel != null) {
					database.addRelation(rel);
				} else {
					return;
				}
				if (dest != null) {
					database.addNode(dest);
				}

        });
        return database;
	}

    @RequestMapping(value = Constants.RequestUri.Database.GET_DOMAIN_DATABASE, headers = "Accept=application/json", method =
            RequestMethod.GET, produces = "application/json")
    public Database getDomainDatabase(@RequestParam("domain") String domain) {

        String query = Queries.GET_DOMAIN_DATABASE_QUERY;
        if ("all".equals(domain.toLowerCase())) {
            query = query.replace("$domain", "");
        } else {
            query = query.replace("$domain", ":" + domain);
        }
        Result result = this.neoService.execute(query);
        Database database = new Database();

        result.queryResults().forEach( a-> {
            NodeModel source = (NodeModel)a.get("n");
            RelationshipModel rel = (RelationshipModel)a.get("r");
            NodeModel dest = (NodeModel)a.get("m");
            if (source != null) {
                database.addNode(source);
            } else {
                return;
            }
            if (rel != null) {
                database.addRelation(rel);
            } else {
                return;
            }
            if (dest != null) {
                database.addNode(dest);
            }

        });
        return database;
    }

    @RequestMapping(value = Constants.RequestUri.Database.GET_DOMAIN_NODES, headers = "Accept=application/json", method =
            RequestMethod.GET, produces = "application/json")
    public Database getDomainNodes(@RequestParam("domain") String domain) {

        String query = Queries.GET_DOMAIN_NODES_QUERY;
        query = query.replace("$domain",domain);
        Result result = this.neoService.execute(query);
        Database database = new Database();

        result.queryResults().forEach( a-> {
            NodeModel node = (NodeModel)a.get("n");
            if (node != null) {
                database.addNode(node);
            }
        });
        return database;
    }

    @RequestMapping(value = Constants.RequestUri.Database.GET_DOMAIN_SENTENCES, headers = "Accept=application/json", method =
            RequestMethod.GET, produces = "application/json")
    public Result getDomainSentences(@RequestParam("domain") String domain) {

        String query = Queries.GET_DOMAIN_SENTENCES_QUERY;
        query = query.replace("$domain",domain);
        Result result = this.neoService.execute(query);
        return result;
    }

    @RequestMapping(value = Constants.RequestUri.Database.GET_DROPDOWN_DOMAIN_NODES, headers = "Accept=application/json",
            method = RequestMethod.GET, produces = "application/json")
    public Result getDropdownDomainNodes(@RequestParam("domain") String domain) {

        String query = Queries.GET_DROPDOWN_DOMAIN_NODES_QUERY;
        query = query.replace("$domain",domain);
        Result result = this.neoService.execute(query);
        return result;
    }

    @RequestMapping(value = Constants.RequestUri.Database.GET_NODE_LABELS, headers = "Accept=application/json",
            method = RequestMethod.GET, produces = "application/json")
    public Result getNodeLabels() {

        String query = Queries.GET_NODE_LABELS_QUERY;
        Result result = this.neoService.execute(query);
        return result;
    }
}
