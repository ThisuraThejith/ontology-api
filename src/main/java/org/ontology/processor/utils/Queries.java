package org.ontology.processor.utils;


/**
 * Created by thisura on 7/2/18.
 */
public class Queries {
    public static final String CREATE_NODE = "CREATE (n:$nodeLabel {$nodeProperties})";
    public static final String CREATE_RELATIONSHIP = "MATCH (source:$SourceType$sourcePropStr), " +
            "(dest:$destType$destPropStr) CREATE (source)" +
            "$dirSrc[:$relName$relProps]$dirDest(dest)";
    public static final String GET_DATABASE_QUERY = "MATCH (n) OPTIONAL MATCH (n)-[r]-(m) RETURN n,r,m";
    public static final String GET_DOMAIN_DATABASE_QUERY = "MATCH (n$domain) OPTIONAL MATCH (n)-[r]-(m) RETURN n,r,m";
    public static final String GET_DOMAIN_NODES_QUERY = "MATCH (n:$domain) RETURN n";
    public static final String GET_DOMAIN_SENTENCES_QUERY = "MATCH (a:$domain)-[r]->(b:$domain) RETURN a.name + \" \"" +
            " + type(r) + " +
            "\" \" + b" +
            ".name AS sentence";
    public static final String GET_DROPDOWN_DOMAIN_NODES_QUERY = "Match(n:$domain) return n.name AS nodeName,ID(n) AS" +
            " nodeID ORDER BY n.name";
    public static final String GET_NODE_LABELS_QUERY = "MATCH (n) RETURN DISTINCT labels(n) AS Label ORDER BY labels(n)";
}