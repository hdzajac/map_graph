
import se.kodapan.osm.parser.xml.OsmXmlParserException;

import java.io.IOException;

/**
 * Created by Hubert on 01.11.2016.
 */
public class App {

    public static void main(String[] args) throws IOException, OsmXmlParserException {
        GraphFactory gf = new GraphFactory();

        gf.makeGraph("andorra-latest.osm");

    }

}
