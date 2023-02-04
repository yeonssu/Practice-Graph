public class Dfs {
    public static void main(String[] args) {
        System.out.println(barcode(3)); // "121"

        System.out.println(barcode(7)); // "1213121"

        System.out.println(barcode(20)); // "12131231321231213123"
    }
    public static String barcode(int len) {
        return addStr("",len);
    }
    public static boolean check(String str){
        int mid = (int) Math.floor(str.length()/2);

        for (int i = 1; i <= mid; i++) {
            if (str.substring(str.length()-2*i,str.length()-i).equals(str.substring(str.length()-i,str.length()))) return false;
        }
        return true;

    }
    public static String addStr(String str, int len){
        String oneTwoThree = "123";

        if (str.length()==len) return str;

        for (int i = 0; i < 3; i++) {
            String result = str + oneTwoThree.charAt(i);
            if (check(result)){
                String founded = addStr(result, len);
                if (founded!=null) return founded;
            }
        }
        return null;
    }
}
