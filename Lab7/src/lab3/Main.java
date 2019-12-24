package lab3;

public class Main {

    public static void main(String[] args) {
        UndoStringBuilder sb = new UndoStringBuilder("test java lab 3");
        System.out.println(sb);
        sb.appendString(" add char");
        System.out.println(sb);
        sb.actions.pop().undo();
        System.out.println(sb);
        sb.appendINT(3);
        char [] arr ={' ', 'L','a','b','a'};
        sb.appendCharArray(arr);
        System.out.println(sb);
        boolean bool = true;
        sb.appendBoolean(bool);
        System.out.println(sb);



    }
}
