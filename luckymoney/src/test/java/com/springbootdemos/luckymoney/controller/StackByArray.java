package com.springbootdemos.luckymoney.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class StackByArray {
    private static final Logger logger = LoggerFactory.getLogger(StackByArray.class);


    private  Integer[] array;  //存储数组
    private int initialCapacity; //初始化数组（栈）的容量
    private int count ; //表示找顶位置
    private static final int resizeFactor = 2;

    public StackByArray(){
        this.array = new Integer[8];
        this.initialCapacity = 8;
        this.count = 0;
    }

    /**
     * 带参构造器，使用用户自定义的容量大小
     * @param initialCapacity
     */
    public StackByArray(int initialCapacity){
        if (initialCapacity<1)
        {
            logger.info("容量太小！");
            return;
        }
        this.initialCapacity = initialCapacity;
        this.array = new Integer[initialCapacity];
        this.count = 0;
    }

    /**
     * 添加元素
     * @param value
     */
    public void add(int value){
        if (count == initialCapacity){
            //如果已经达到容量大小就进行扩容
            resizeArray();
        }
        array[count++] = value;
    }

    /**
     * 每次扩容都为原数组大小的两倍
     */
    public void resizeArray(){
        int newCapacity = initialCapacity*resizeFactor;
        array = Arrays.copyOf(array,newCapacity);
        initialCapacity = newCapacity;
    }

    /**
     * 出栈并返回元素
     * @return
     */
    public Integer pop(){
        if(count == 0){
            throw new IllegalArgumentException("stack is empty");
        }
        count--;
        return array[count];
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public Integer peek(){
        if(count == 0){
            return null;
        }
        return array[count-1];
    }

    /**
     * 返回栈中当前元素个数
     * @return
     */
    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }


    /**
     * 使用数组实现栈，测试
     * @param args
     */
    public static void main(String[] args) {
         StackByArray stack = new StackByArray(5);
         stack.add(5);
         stack.add(4);
         stack.add(3);
         stack.add(2);
         stack.add(1);
         stack.add(0);

        System.out.println("the size of stack=" + stack.size());
        System.out.println("the stack is empty? " + stack.isEmpty());
        System.out.println("the peek element of stack=" + stack.peek());
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + ",");
        }
    }
}
