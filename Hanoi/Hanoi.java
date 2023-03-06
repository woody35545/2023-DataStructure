/*
    - 소속: 충남대학교 컴퓨터공학과
    - 과목: 자료구조(08반)
    - 학번: 201701975
    - 이름: 구건모
 */

public class Hanoi {

    public static void move(int disk, char start, char end, char middle)
    {
        if(disk==1){
            System.out.println("Moved disk " + disk+" from " + start +" to " +end);
        }
        else {
            move(disk-1, start,middle,end);
            System.out.println("Moved disk " + disk+" from " + start +" to " +end);
            move(disk-1,middle,end,start);
        }
    }
}
