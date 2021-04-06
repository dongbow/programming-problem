import java.util.Arrays;
import java.util.List;

/**
 * 打印树
 **/
public class TreePrint {

    private static final String SPACE = "  ";

    static class Node {
        int id;
        int parentId;
        String name;

        public Node(int id, int parentId, String name) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Node> nodeList = Arrays.asList(
                new Node(1, 0, "AA"),
                new Node(2, 1, "BB"),
                new Node(3, 1, "CC"),
                new Node(4, 3, "DD"),
                new Node(5, 3, "EE"),
                new Node(6, 2, "FF"),
                new Node(7, 2, "GG"),
                new Node(8, 4, "HH"),
                new Node(9, 5, "II"),
                new Node(10, 0, "JJ"),
                new Node(11, 10, "KK"),
                new Node(12, 10, "LL"),
                new Node(13, 12, "MM"),
                new Node(14, 13, "NN"),
                new Node(15, 14, "OO")
        );
        print(nodeList);
    }

    public static void print(List<Node> nodeList) {
        print(nodeList, 0, 0);
    }

    private static void print(List<Node> nodeList, int parentId, int depth) {
        for (Node node : nodeList) {
            if (node.parentId == parentId) {
                System.out.println(calcPrintLine(depth, node.name));
                print(nodeList, node.id, depth + 1);
            }
        }
    }

    private static String calcPrintLine(int depth, String name) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            s.append(SPACE);
        }
        return s.append(name).toString();
    }

}
