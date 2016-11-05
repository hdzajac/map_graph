import org.apache.lucene.search.Query;
import org.junit.Test;
import se.kodapan.osm.domain.Node;
import se.kodapan.osm.domain.Way;
import se.kodapan.osm.domain.root.PojoRoot;
import se.kodapan.osm.domain.root.indexed.IndexedRoot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DataSculptorTest {

    @Test
    public void somethingTest(){

        Node n1 = new Node(1L,1.1,1.1);
        Node n2 = new Node(2L,2.2,2.2);
        Node n3 = new Node(3L,3.3,3.3);
        Node n4 = new Node(4L,4.4,4.4);
        Node n5 = new Node(5L,5.5,5.5);

        Way w1 = new Way();  // POLYGON
        Way w2 = new Way();  // NORMAL ROUTE
        Way w3 = new Way();  // SINGLE POINT

        Way w4 = new Way();  // NORMAL
        Way w5 = new Way();  // NORMAL


        w1.addNode(n1);
        w1.addNode(n2);
        w1.addNode(n3);
        w1.addNode(n4);
        w1.addNode(n5);
        w1.addNode(n1);

        assertTrue(w1.isPolygon());

        w2.addNode(n3);
        w2.addNode(n5);
        w2.addNode(n2);
        w2.addNode(n1);

        assertFalse(w2.isPolygon());

        w3.addNode(n1);

        w4.addNode(n2);
        w4.addNode(n4);
        w4.addNode(n5);

        w5.addNode(n1);
        w5.addNode(n2);


        PojoRoot root = new PojoRoot();

    }

}
