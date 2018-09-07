package org.ontology.processor.utils;

/**
 * Created by Thisura on 5/14/17.
 */
public class Constants {

	public static class RequestUri {

	     public static class Node {
             public static final String GET_NODE = "/node_info";
         }

        public static class Relationship {
            public static final String GET_RELATIONSHIP = "/rel_info";
        }

        public static class Database{
            public static final String GET_DATABASE = "/get_database";
            public static final String GET_DOMAIN_DATABASE = "/get_domain_database";
            public static final String GET_DOMAIN_NODES = "get_domain_nodes";
            public static final String GET_DOMAIN_SENTENCES = "/get_domain_sentences";
            public static final String GET_DROPDOWN_DOMAIN_NODES = "/get_dropdown_domain_nodes";
            public static final String GET_NODE_LABELS = "/get_node_labels";
        }

	}

}
