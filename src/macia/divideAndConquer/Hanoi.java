package macia.divideAndConquer;

/**
 * @author zenggs
 * @Date 2022/9/15
 * 汉诺塔
 */
public class Hanoi {

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
//        hanoi.hanoi(64, "A", "B", "C");
        hanoi.hanoi(3, "A", "B", "C");
    }

    private void hanoi(int n,String source,String target,String temp){
        if (n == 1){
            // 只有一层 源数据区 -> 目标区
            System.out.printf("%s - > %s\n", source, target);
        }else {
            // 1. 数据源区 -> 缓冲区
            hanoi(n-1, source, temp, target);
            // 2. 数据源区 -> 目标区
            hanoi(1, source, target, temp);
            // 3. 缓冲区 -> 目标区
            hanoi(n-1, temp, target, source);
        }
    }
}
