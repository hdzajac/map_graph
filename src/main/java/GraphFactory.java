import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import se.kodapan.osm.domain.root.PojoRoot;
import se.kodapan.osm.domain.root.indexed.IndexedRoot;
import se.kodapan.osm.parser.xml.OsmXmlParserException;
import se.kodapan.osm.parser.xml.instantiated.InstantiatedOsmXmlParser;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hubert on 01.11.2016.
 */
public class GraphFactory {

    public IndexedRoot<Query> makeGraph(String mapsName) throws IOException, OsmXmlParserException {
        PojoRoot root = new PojoRoot();
        IndexedRoot<Query> index = IndexedRoot.newInstance(root);
        index.open();

        InstantiatedOsmXmlParser parser = InstantiatedOsmXmlParser.newInstance();
        parser.setRoot(index);
        parser.parse(getClass().getResourceAsStream("/" + mapsName));
        index.commit();

        System.out.print(root.getNodes().size());
        return index;
    }
}
