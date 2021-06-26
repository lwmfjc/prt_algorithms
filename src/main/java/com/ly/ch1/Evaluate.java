package com.ly.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops=new Stack<String>();
        Stack<Double> vals=new Stack<>();
        while (!StdIn.isEmpty()){
            String s=StdIn.readString();
            if(s.equals("#")){
                break;
            }
            if(s.equals("(")){

            }else if(s.equals("+")||
            s.equals("-")||s.equals("*")||s.equals("/")
            ||s.equals("sqrt")){
                ops.push(s);
            }else if(s.equals(")")){
                String op=ops.pop();
                double v=vals.pop();
                if(op.equals("+")){
                    //pop第一位操作数与第二位进行操作
                    v=vals.pop()+v;
                }else if(op.equals("-")){
                    v=vals.pop()-v;
                }else if(op.equals("*")){
                    v=vals.pop()*v;
                }else if(op.equals("/")){
                    v=vals.pop()/v;
                }else if(op.equals("sqrt")){
                    v=Math.sqrt(v);
                }
                vals.push(v);
            }else {
                //将数值压入数值栈中
                vals.push(Double.parseDouble(s));
            }
        }
        if(!vals.isEmpty()) {
            StdOut.println(vals.pop());
        }
    }
}
