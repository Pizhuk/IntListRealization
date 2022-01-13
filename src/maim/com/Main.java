package maim.com;

import maim.com.LList.LList2;

public class Main {
    public static void main(String[] args) {
        LList2 lList2 = new LList2(new Integer[] {12, 34});
        lList2.print();
        lList2.removeAll(new int[] {12, 34});
        lList2.print();

    }
}
