package org.demo.others;

import java.util.Scanner;
import java.util.Stack;

/**
 * <p>Title 数值转换类</p>
 * <p>公式: N = (N div d)xd + N mod d (其中：div为整除运算，mod为求与运算)<p/>
 * <p>N：是十进制数<p>
 * <p>d：是其他进制数</p>
 * @author belong
 * @version v-1.0
 * Created by belong on 2017/4/1.
 */
public class NumCon {
    public static void main(String[] args) {
        NumCon numCon = new NumCon();
        Scanner cin = new Scanner(System.in);
        String N = cin.next();
        String d = cin.next();
        numCon.conversion(N,d);
    }

    /**
     * 进行数值转换
     */
    public void conversion(String N,String d){
        //建立临时栈用于存储余数（然后倒序输出）
        Stack<Integer> stack = new Stack();
        //临时变量
        String num = N;
        Integer num_N = Integer.parseInt(N);
        Integer num_d = Integer.parseInt(d);

        while(num_N != 0){
            stack.push(num_N % num_d);
            num_N /= num_d;
        }
        System.out.print(num+"的"+d+"进制数是：");
        while (!stack.empty()){
            int tmp = stack.pop();
            System.out.print(tmp);
        }
    }

}
