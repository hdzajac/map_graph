package graphElements;

public final class NodeFactory {

    private static long id;

    public NodeFactory(){
        NodeFactory.id = 0;
    }

    public Node newNodeFromLibNode(se.kodapan.osm.domain.Node n){
        Node node = new Node(id, n);
        id ++;
        return node;
    }

}
