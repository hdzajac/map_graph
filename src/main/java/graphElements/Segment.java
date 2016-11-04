package graphElements;

public class Segment implements Comparable<Segment> {

    private final long id;
    private Node n1;
    private Node n2;
    private Double length;

    protected Segment(Long id, Node n1){
        this.id = id;
        this.n1 = n1;
        this.n2 = null;
        this.length = 0.0;
    }

    protected Segment(Long id, Node n1, Node n2) {
        this.id = id;
        this.n1 = n1;
        this.n2 = n2;
        calculateLength();
    }

    private void calculateLength() {
    }

    public int compareTo(Segment o) {
        if((n1.getId() == o.getNode1().getId() && n2.getId() == o.getNode2().getId())
                || (n2.getId() == o.getNode1().getId() && n1.getId() == o.getNode1().getId()))
            return 0;
        else if (length >= o.getLength())
            return 1;
        else
            return -1;
    }

    public long getId() {
        return id;
    }

    public Node getNode1() {
        return n1;
    }

    public void setNode1(Node n1) {
        this.n1 = n1;
            if (this.n2 != null)
                calculateLength();
    }

    public Node getNode2() {
        return n2;
    }

    public void setNode2(Node n2) {
        this.n2 = n2;
        if (this.n1 != null)
            calculateLength();
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public boolean contains(Node n){
        return (n1.equals(n) || n2.equals(n));
    }

    public Node getNeighbour(Node n){
        return n.equals(n1)? n2 : n1;
    }

    @Override
    public String toString() {
        return "-- " + n1 + " ---- " + n2 + " --";
    }
}
