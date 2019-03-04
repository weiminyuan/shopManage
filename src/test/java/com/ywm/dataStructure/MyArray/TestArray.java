package com.ywm.dataStructure.MyArray;

public class TestArray {
    public static void main(String[] args) {
//        MyArray myArray = new MyArray();
//        myArray.show();
//        myArray.add(1);
//        myArray.add(2);
//        myArray.show();
//        myArray.insert(2,3);
//        myArray.show();
//        myArray.insert(3,4);
//        myArray.show();
//        myArray.get(3);
//        myArray.show();
//        myArray.delete(3);
//        myArray.show();
//
//        myArray = new MyArray();
//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
//        myArray.addAll(arr);
//        int target =4;
//        int index = myArray.findArray(target);
//        System.out.println(index);

        hanoi(5, 'A', 'B', 'c');
    }


    /**
     *  递归-汉诺塔
     * @param n 盘子数量
     * @param from  开始的柱子
     * @param in    中间的柱子
     * @param to    目标柱子
     * 无论有多少个盘子，都认为2个，上面的所有盘子和下面一个盘子
     */
    public static void hanoi(int n , char from, char in, char to){
        if(n==1){
            System.out.println("第1个盘子从"+from+"移到"+to);
        //   论有多少个盘子，都认为2个，上面的所有盘子和下面一个盘子
        }else {
            //移动上面盘子到中间盘子
            hanoi(n-1,from,to,in);
            //移动下面盘子到目标盘子
            System.out.println("第"+n+"个盘子从"+from+"移到"+to);
            //把上面盘子移到目标盘子
            hanoi(n-1,in,from,to);
        }

    }


}
