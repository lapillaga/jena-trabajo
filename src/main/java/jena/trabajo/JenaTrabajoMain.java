package jena.trabajo;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManagerImpl;

import java.io.InputStream;

public class JenaTrabajoMain {
    public static void main(String[] args) {
        OntModel model = null;
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        InputStream in = FileManagerImpl.get().open("/Users/luispillaga/Downloads/proyecto_final_matriculacion.owl");
        if (in == null) {
            throw new IllegalArgumentException("Archivo no encontrado");
        }
        model.read(in, "");
//        model.write(System.out);
        String queryString = "PREFIX ma: <http://www.semanticweb.org/pc/ontologies/2020/7/untitled-ontology-10#>" +
            "SELECT ?estudiante ?materia " +
            "WHERE " +
            "{" +
                "?m ma:TieneMaterias ?mat." +
                "?mat ma:nombre ?materia." +
                "?e ma:MatriculadoEn ?m." +
                "?e ma:nombre ?estudiante." +
            "}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qu = QueryExecutionFactory.create(query, model);
        try {
            ResultSet results;
            results = qu.execSelect();
            ResultSetFormatter.out(System.out, results, query);
        } finally {
            qu.close();
        }

    }
}
