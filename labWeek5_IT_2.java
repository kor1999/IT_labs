public class labWeek5_IT_2 {
    public static void main(String[] args) {
        String[][] arr = {{"a","0.12","",""},{"e","0.42","",""},{"i","0.09","",""},{"o","0.3","",""},{"u","0.07","",""}};

        double a=0;
        for (int i = 0; i <arr.length ; i++) {
            a = Double.parseDouble(arr[i][1]) + a;
            arr[i][2] = String.valueOf(a);
        }
        String str = "iou";
        String code = func(str,arr);
        System.out.println(code);
        System.out.println(decode(code, arr, str.length()));
    }

    public static String decode(String binCode, String[][] arr, int str_size){
        String answer = "";
        double x = toDecimal(binCode);

        for (int i = 0; i < str_size; i++) {
            double cur = 0, next = -1;
            for (int j = 0; j < arr.length; j++) {
                next = cur + Double.parseDouble(arr[j][1]);
                if (x < next && x > cur) {
                    answer += arr[j][0];
                    break;
                }
                cur = next;
            }
            x = (x - cur) / (next - cur);
        }
        return answer;
    }

    public static String func(String str, String[][] arr){
        double low = 0, up = 1;
        for (int i = 0; i < str.length(); i++) {
            double cur = low, next = -1;
            for (int j = 0; j < arr.length; j++) {
                next = cur + Double.parseDouble(arr[j][1]) * (up - low);

                if (str.charAt(i) == arr[j][0].charAt(0))
                    break;

                cur = next;
            }
            low = cur;
            up = next;
        }
        // low, up

        String lowS = binary(low);
        String upS = binary(up);

        String ans = "";

        int i = 0;
        while (lowS.charAt(i) == upS.charAt(i)) {
            ans += lowS.charAt(i);
            i++;
        }
        //100011|0110101
        //100011|1000000
        boolean f = false;
        for (int j = i; j < lowS.length(); j++) {
            if (lowS.charAt(j) != '0') {
                f = true;
                break;
            }
        }
        if (!f)
            return lowS.substring(0,i);

        for (int j = i+1; j < upS.length(); j++) {
            if (upS.charAt(j) == '1')
                return upS.substring(0,i+1);
        }

        while (lowS.charAt(i) == '1') {
            i++;
        }

        return lowS.substring(0, i) + '1';
    }

    public static String binary(double x){

        String binCode = "";
        for (int i = 0; i < 64; i++) {
            x = x*2;
            binCode += (int) x;
            if (x>=1)
                x -= 1;
        }
        return binCode;
    }

    public static double toDecimal (String binCode){
        double x = 0;
        for (int i = 0; i <binCode.length() ; i++) {
            x += Double.parseDouble(String.valueOf(binCode.charAt(i))) * Math.pow(2,-(i+1));
        }
        return x;
    }
}
