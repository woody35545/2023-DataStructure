package DS_230414_UNIONFIND;

public class Node {
    int parent;
    int rank;


    public Node(int parant, int rank) {
        this.parent = parant;
        this.rank = rank;
    }

    public int getParent() {
        return parent;
    }

    public int getRank() {
        return rank;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}
