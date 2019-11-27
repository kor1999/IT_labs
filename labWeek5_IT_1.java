public class labWeek5_IT_1 {

    public static void main(String[] args) {
        //String[][] arr = {{"a","0.5",""},{"b","0.3",""},{"c","0.2",""}};
        String[][] arr = {{"a","0.25","",""},{"b","0.25","",""},{"c","0.2","",""},{"d","0.15","",""},{"e","0.15","",""}};

        double a=0;
        for (int i = 0; i <arr.length ; i++) {
            a = Double.parseDouble(arr[i][1]) + a;
            arr[i][2] = String.valueOf(a);
        }
        System.out.println("Coding:");
        for (int i = 0; i <arr.length ; i++) {
            arr[i][3] = func(Double.parseDouble(arr[i][1]), Double.parseDouble(arr[i][2]));
            System.out.println(arr[i][0] + " = " + arr[i][3]);
        }
        System.out.println("Encoding:");
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i][3] + " = " + decode(arr[i][3], arr));
        }
    }
    public static String decode(String binCode,String[][] arr){
        double x = 0;
        for (int i = 0; i <binCode.length() ; i++) {
            x += Double.parseDouble(String.valueOf(binCode.charAt(i))) * Math.pow(2,-(i+1));
        }
        for (int i = 0; i <arr.length ; i++) {
            if (x <= Double.parseDouble(arr[i][2]) )
                return arr[i][0];
        }
        //System.out.println(x);
        return "Error";
    }
    public static String func(double prob, double Fx){
        double midpointF = Fx - prob/2 ;
        int l = (int) (Math.ceil(log2(1/prob)) + 1);
        return binary(midpointF,l);
    }

    public static String binary(double x, int l){
        String binCode = "";

        for (int i = 0; i < l; i++) {
        //while (x<1){
            x = x*2;
            binCode += (int) x;
            if (x>1)
                x -= 1;
        }
        return binCode;
        //return binCode.substring(0,l);
    }


    public static double log2(double x)
    {
        return (Math.log(x) / Math.log(2));
    }
}
