package DS_230414_UNIONFIND;

public class UnionFind {
    protected Node[] nodeArr;

    public UnionFind(Node[] a) {
        this.nodeArr = a;
    }

    protected int find(int i){
        if (i != nodeArr[i].getParent())
            nodeArr[i].setParent(find(nodeArr[i].getParent()));

        return nodeArr[i].getParent();
    }

    public void union(int i,int j){
        int iroot = find(i);
        int jroot = find(j);
        // 동일한 set에 속한 것인지 확인, 동일할 경우 union 할 필요 없으므로 그대로 return 시킴
        if(iroot == jroot) return;

        int iRootRank = nodeArr[iroot].getRank();
        int jRootRank = nodeArr[jroot].getRank();

        // find를 통해서 union 하려는 두 트리 높이 비교
        if(iRootRank > jRootRank)
            nodeArr[jroot].setParent(iroot);
        else if(jRootRank > iRootRank){
            nodeArr[iroot].setParent(jroot);}
        else {
            // 두 tree의 높이가 동일하면 그냥 랜덤하게 한쪽으로 병합함
            nodeArr[jroot].setParent(iroot);
            nodeArr[iroot].setRank(nodeArr[iroot].getRank()+1); //  tree level 1 증가
        }
    }
}
