package test_ly;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    public static void main(String[ ] args){
        //读取文件中的值(白名单)
        int[] whitelist= In.readInts(args[0]);
        Arrays.sort(whitelist);
        //如果不是空
        while(!StdIn.isEmpty()){
            //那么就读取一个整数
            int key=StdIn.readInt();
            //如果输入的值不在文件中
            if(rank(key,whitelist)==-1){
                StdOut.println(key);
            }
        }
        
        //=====绘图相关=====
        //绘图初始化
//        StdDraw.setXscale(0, 20);
//        StdDraw.setYscale(0, 20);
//        StdDraw.setPenRadius(.01);
//        //绘图
//        StdDraw.line(2,2,10,10); 
    }
}
