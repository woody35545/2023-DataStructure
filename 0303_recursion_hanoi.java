class Hanoi {

    public static void p(String msg){
        System.out.println(msg);
    }

    public static void move(int disk, char src, char dst, char aux)
    {
        if(disk==1){
            p("Moved disk " + disk+" from " + src +" to " +dst);
        }
        else
        {
            move(disk-1, src,aux,dst);
            p("Moved disk " + disk+" from " + src +" to " +dst);
            move(disk-1,aux,dst,src);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Hanoi.move(3,'A','B','C');
    }
}
