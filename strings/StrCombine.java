import com.google.common.collect.Lists;

import java.util.List;

/**
 * 获取字符串的所有子串
 */
public class StrCombine {

    static List<String> results = Lists.newArrayList();

    public static void combine(String source, int num) {
        if (source.length() == 0) {
            return;
        }
        if (num == 1) {
            for (char c : source.toCharArray()) {
                results.add(String.valueOf(c));
                print();
            }
            return;
        }
        if (source.length() < num) {
            throw new IllegalArgumentException("参数异常");
        }
        combine(source, 0, 1, num);
        print();
    }

    private static void combine(String source, int rootIndex, int start, int length) {
        if (rootIndex + length > source.length()) {
            return;
        }
        int end = start + length - 1;
        if (end > source.length()) {
            rootIndex = rootIndex + 1;
            start = rootIndex + 1;
            combine(source, rootIndex, start, length);
        } else {
            results.add(source.charAt(rootIndex) + (end == source.length() ? source.substring(start) : source.substring(start, end)));
            combine(source, rootIndex, start + 1, length);
        }
    }

    private static void print() {
        for (String result : results) {
            System.out.println(result);
        }
        results.clear();
    }

    public static void main(String[] args) {
        String s = "hello";
        for (int i = 1; i <= s.length(); i++) {
            combine(s, i);
        }

    }

}
