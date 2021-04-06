import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 简单分配红包，尽量公平、合理
 */
public class RedPkg {

    private static final BigDecimal MIN = BigDecimal.valueOf(0.01);

    public static void main(String[] args) {
        deal(100, 14);
    }

    public static void deal(double money, int n) {
        if (n * MIN.doubleValue() > money) {
            throw new IllegalArgumentException("无法尽可能均分");
        }
        List<Double> list = Lists.newArrayListWithCapacity(n);
        BigDecimal divide = BigDecimal.valueOf(money).divide(BigDecimal.valueOf(n), 2, BigDecimal.ROUND_FLOOR);
        BigDecimal subtract = BigDecimal.valueOf(money).subtract(divide.multiply(BigDecimal.valueOf(n)));
        int m = subtract.divide(MIN).intValue();
        for (int i = 0; i < n; i++) {
            if (i < m) {
                list.add(divide.add(MIN).doubleValue());
            } else {
                list.add(divide.doubleValue());
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

}
