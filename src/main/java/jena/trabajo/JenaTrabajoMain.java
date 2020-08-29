package jena.trabajo;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManagerImpl;

import java.io.InputStream;

public class JenaTrabajoMain {
    public static void main(String[] args) {
        OntModel model=null;
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        InputStream in= FileManagerImpl.get().open("/Users/luispillaga/Downloads/proyecto_final_matriculacion.owl");
        if (in==null)
        {
            throw new IllegalArgumentException("Archivo no encontrado");
        }
        model.read(in, "");
        model.write(System.out);
//        String queryString= "PREFIX hc: <http://www.semanticweb.org/pc/ontologies/2020/6/untitled-ontology-5#>" +
//                "SELECT ?transaccion ?cajero" +
//                "WHERE "+
//                "{"+
//                "?t  hc:GeneradaPorCajero ?c."+
//                "?t  hc:codigo ?transaccion."+
//                "?c  hc:direccion ?cajero."+
//                "}";
//        Query query= QueryFactory.create(queryString);
//        QueryExecution qu= QueryExecutionFactory.create(query,model);
//
//        try{
//            ResultSet results;
//            results=(ResultSet)qu.execSelect();
//            ResultSetFormatter.out(System.out,results, query);
//        }finally {
//            qu.close();
//        }

    }
}
