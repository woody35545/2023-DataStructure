package DS_TEXTBOOK.UNION_FIND;

public class UnionFind {
    protected Node[] a;
    public UnionFind(Node[] iarray){ // 생성자
        a = iarray;
    }

    protected int find(int i){ // 경로 압축
        if(i != a[i].getParent())
            a[i].setParent(find(a[i].getParent()));
        return a[i].getParent();
    }

    public void union(int i, int j){
        int iroot = find(i);
        int jroot = find(j);
        if(iroot == jroot) return; // 루트가 동일하면 더 이상의 수행 없이 그대로 리턴
        // rank가 높은 루트가 승자가 된다.
        if(a[iroot].getRank() > a[jroot].getRank())
            a[jroot].setParent(iroot); // iroot가 승자
        else if(a[iroot].getRank() < a[jroot].getRank())
            a[iroot].setParent(jroot); // jroot가 승자
        else {
            a[jroot].setParent(iroot); // 둘 중의 하나 임의로 승자
            int t = a[iroot].getRank() + 1;
            a[iroot].setRank(t); // iroot의 rank 1 증가
        }
    }
}

class UnionFindApplication{
    public static void main(String[] args){
        int N = 10;
        Node[] a = new Node[N];

        for (int i=0; i<N; i++){
            a[i] = new Node(i,0);
        }
        UnionFind uf = new UnionFind(a);

        uf.union(2,1); uf.union(2,6);
        uf.union(7,3); uf.union(4,5);
        uf.union(9,5); uf.union(7,2);
        uf.union(7,8); uf.union(0,4);

        System.out.print ("8회의 union 연산 수행 후\n(i:parent, rank): ");
        for(int i=0; i<N; i++)
            System.out.print("("+i+":"+ uf.a[i].getParent() + "," + uf.a[i].getRank()+") ");

        uf.union(9, 1);
        System.out.print("\n\nunion(9, 1) 수행 후 \n(i:parent, rank): ");
        for(int i=0;i<N;i++)
            System.out.print("("+i+":"+ uf.a[i].getParent()+","+uf.a[i].getRank()+") ");
        System.out.println();
    }
}
