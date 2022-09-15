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
            System.out.printf("%s - > %s\n", source, target);
        }else {
            hanoi(n-1, source, temp, target);
            // 打印移动轨迹
            hanoi(1, source, target, temp);
            hanoi(n-1, temp, target, source);
        }
    }
}
