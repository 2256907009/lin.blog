package org.example;

import java.util.*;

/**
 * @Author 小林学长
 * @Date 2024/6/27
 * @Project Study
 */

/*
* 队列实现删除添加操作
* 使用scanner类
* 底层的原理LinkedList
* */

    /*
    * 对于每组测试数据:
如果操作为“取出队首”，输出队首元素，如果无法取出，输出“-1”
如果操作为“删除队首”，如果无法删除，输出“-1”
如果操作为“队列大小”，输出队列大小
其他操作无需输出
    *
    * 插入队尾: PUSH X
取出队首: TOP//仅仅是看一下队首元素，不要把队首元素删除
删除队首: POP
队列大小: SIZE
清空队列: CLEAR
    *
    * */
public class Que {


    public static void main(String[] args) {
        System.out.println("请输入一些整数：");
        Scanner scanner = new Scanner(System.in);
            //只能得到空格和回车执勤的数
        //第一个输入的数是为了再次循环输入
        int ine = scanner.nextInt();
        scanner.nextLine();
        while (ine > 0) {
            //第二个输入的数为了判断可以添加进链表的个数
            int q = scanner.nextInt();
            List<Integer> list = new LinkedList<>();
            for (int i =0;i<=q;i++){
                //第三个输入的数或者时字符串用于输入进去
                //可用于循环输入，只需在上一个输入中输入n个数字，就可在添加n个数字的空间
                //但不可超出n个数，还需要看List的类型进行输入
                String s = scanner.nextLine();
                //用于做判断
                if(s.equals("")){
                    continue;
                }
                if(s.startsWith("PUTH")){
                    list.add(Integer.valueOf((s.split(" ")[1])));
                    System.out.println(list);
                } else if(s.equals("TOP")) {
                    //获取首列
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(list.get(0));
                    }
                }else if(s.equals("POP")){
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else {
                        list.removeLast();
                        System.out.println("删除列尾的集合是：" + list);
                    }
                }else if(s.equals("SIZE")){
                    System.out.println("集合的大小是：" + list.size());
                }else if(s.equals("CLEAR")){
                    list.clear();
                    System.out.println("已成功删除集合！");
                }
            }
        }

        scanner.close();




    }
}
