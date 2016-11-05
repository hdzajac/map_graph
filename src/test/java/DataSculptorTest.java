import org.apache.lucene.search.Query;
import org.junit.Test;
import se.kodapan.osm.domain.Node;
import se.kodapan.osm.domain.OsmObject;
import se.kodapan.osm.domain.OsmObjectVisitor;
import se.kodapan.osm.domain.Way;
import se.kodapan.osm.domain.root.PojoRoot;
import se.kodapan.osm.domain.root.indexed.IndexedRoot;
import se.kodapan.osm.util.distance.ArcDistance;
import se.kodapan.osm.util.distance.OsmObjectCentroidDistance;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DataSculptorTest {

    @Test
    public void somethingTest(){

        DataSculptor ds = new DataSculptor();

        Node n1 = new Node(1L,1.1,1.1);
        Node n2 = new Node(2L,2.2,2.2);
        Node n3 = new Node(3L,3.3,3.3);
        Node n4 = new Node(4L,4.4,4.4);
        Node n5 = new Node(5L,5.5,5.5);

        Way w1 = new Way(1L);  // POLYGON
        Way w2 = new Way(2L);  // NORMAL ROUTE
        Way w3 = new Way(3L);  // SINGLE POINT

        Way w4 = new Way(4L);  // NORMAL
        Way w5 = new Way(5L);  // NORMAL

        w1.addNode(n1);
        w1.addNode(n2);
        w1.addNode(n3);
        w1.addNode(n4);
        w1.addNode(n5);
        w1.addNode(n1);

        w2.addNode(n3);
        w2.addNode(n5);
        w2.addNode(n2);
        w2.addNode(n1);

        w3.addNode(n1);

        w4.addNode(n2);
        w4.addNode(n4);
        w4.addNode(n5);

        w5.addNode(n1);
        w5.addNode(n2);

        Map<Long, Node> nodes = new HashMap<>();
        nodes.put(n1.getId(), n1);
        nodes.put(n2.getId(), n2);
        nodes.put(n3.getId(), n3);
        nodes.put(n4.getId(), n4);
        nodes.put(n5.getId(), n5);

        Map<Long, Way> ways = new HashMap<>();
        ways.put(w1.getId(), w1);
        ways.put(w2.getId(), w2);
        ways.put(w3.getId(), w3);
        ways.put(w4.getId(), w4);
        ways.put(w5.getId(), w5);

        PojoRoot root = new PojoRoot();
        root.setNodes(nodes);
        root.setWays(ways);

        Map<OsmObject, Float> hits = ds.narrowDown(0.0,6.6, 6.6, 0.0, root);

    }

}
