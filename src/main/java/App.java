
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import se.kodapan.osm.domain.OsmObject;
import se.kodapan.osm.domain.root.PojoRoot;
import se.kodapan.osm.domain.root.indexed.IndexedRoot;
import se.kodapan.osm.domain.root.indexed.IndexedRootImpl;
import se.kodapan.osm.parser.xml.OsmXmlParserException;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Hubert on 01.11.2016.
 */
public class App {

    public static void main(String[] args) throws IOException, OsmXmlParserException {
        GraphFactory gf = new GraphFactory();
        IndexedRoot<Query> index = gf.makeGraph("andorra-latest.osm");

        BooleanQuery bq = new BooleanQuery();

        bq.add(index.getQueryFactories().containsTagKeyQueryFactory().setKey("highway").build(), BooleanClause.Occur.MUST);
        bq.add(index.getQueryFactories().nodeEnvelopeQueryFactory()
                .setSouthLatitude(42.5110129).setWestLongitude(1.527749)
                .setNorthLatitude(42.5209083).setEastLongitude(1.544432)
                .build(), BooleanClause.Occur.MUST);

        Map<OsmObject, Float> hits = index.search(bq);

        for(OsmObject entry : hits.keySet()){
            System.out.println(" ["+  entry.getId() + "] "+ entry.getTags() + " " + entry.getAttributes());
        }

    }

}
