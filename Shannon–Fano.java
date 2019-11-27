import java.util.ArrayList;

public class Main {




    public static void main(String[] args) {
        String[][] arr = {{"a","99",""},{"b","20",""},{"c","15",""},{"d","14",""},{"e","2",""}};
        recurs(arr);
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i][0]+ " = "+arr[i][2]);
        }

    }

    public static void recurs(String[][] arr){
        if (arr.length == 1)
            return;

        int h = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i <= h; i++) {
            a += Integer.parseInt(arr[i][1]);
        }

        for (int i = h + 1; i < arr.length; i++) {
            b += Integer.parseInt(arr[i][1]);
        }

        int diff1 = 99999;
        int diff2 = Math.abs(a - b);

        while (diff1 > diff2) {
            h++;
            a = 0;
            b = 0;
            for (int i = 0; i <= h; i++) {
                a += Integer.parseInt(arr[i][1]);
            }

            for (int i = h + 1; i < arr.length; i++) {
                b += Integer.parseInt(arr[i][1]);
            }

            diff1 = diff2;
            diff2 = Math.abs(a - b);
        }
        //System.out.println(h);
        String[][] arrc1 = new String[h][3];
        System.arraycopy(arr, 0, arrc1, 0, h);
        for (int i = 0; i < h; i++) {
            arr[i][2] += "0";
        }
        recurs(arrc1);
        //System.out.println(h);
        String[][] arrc2 = new String[arr.length - (h)][3];
        System.arraycopy(arr, h, arrc2, 0, arr.length - (h));
        for (int i = h; i < arr.length; i++) {
            arr[i][2] += "1";
        }
        recurs(arrc2);

        //System.out.println(arr[0][0] + " = " + arr[0][2]);

    }
}
