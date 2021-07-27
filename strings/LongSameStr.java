/**
 * 相同字符的最长子串，忽略大小写
 * 输入： SGEfweeeEEabcdddDddd
 * 输出：dddDddd
 */
public class LongSameStr {

    public static void main(String[] args) {
        System.out.println(find("SGEfweeeEEabcDddd"));
    }

    private static String find(String s) {
        String max = "";
        StringBuilder res = new StringBuilder("" + s.charAt(0));
        String last = "" + s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            String tmp = "" + s.charAt(i);
            if (last.equalsIgnoreCase(tmp)) {
                res.append(tmp);
            } else {
                max = res.length() > max.length() ? res.toString() : max;
                res = new StringBuilder("" + tmp);
            }
            last = tmp;
        }
        return res.length() > max.length() ? res.toString() : max;
    }

}
