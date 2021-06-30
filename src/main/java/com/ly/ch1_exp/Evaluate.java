package com.ly.ch1_exp;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 四则运算
 */
public class Evaluate {
    private static double exec(){
        Stack<String> stackOpt=new Stack<>();
        Stack<Double> stackVal=new Stack<>();
        //知道输入完毕
        while (!StdIn.isEmpty()){
            String s=StdIn.readString();
            //不处理左括号
            switch (s){
                case "(":continue;
                case "+":
                case "-":
                case "*":
                case "/":{
                    stackOpt.push(s);
                }break;
                case ")":{
                    String opt=stackOpt.pop();
                    Double val2=stackVal.pop();
                    Double val1=stackVal.pop();
                    double resultTemp = 0.0;
                    if("+".equals(opt)){
                        resultTemp=val1+val2;
                    }else if("-".equals(opt)){
                        resultTemp=val1-val2;
                    }else if("*".equals(opt)){
                        resultTemp=val1*val2;
                    }else if("/".equals(opt)){
                        resultTemp=val1/val2;
                    }
                    stackVal.push(resultTemp);
                }break;
                //处理数值
                default:{
                    stackVal.push(Double.parseDouble(s));
                }break;
            }
        }
        return stackVal.size()==0?0.0:stackVal.pop();
    }

    public static void main(String[] args) {
        System.out.println(exec());
    }
}
