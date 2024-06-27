package org.example;
//群主发普通红包，群主的一笔金额，从群主余额中扣除，平均分成n等份，让成员领取；成员领取完红包，保存到成员余额中


import java.util.Arrays;
import java.util.Random;

abstract class User{
    protected int money;
    protected String name;

    public User(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public void show(){
        System.out.println("成员：" + this.name + "," + "金额：" + this.money);
    }
}

//成员
class Member extends User{

    public Member(){
    }

    public Member(int money, String name) {
        super(money, name);
    }
    public void showMember(){
        System.out.println("成员：" + this.name + "," + "金额：" + this.money);
    }

    public void receive(int[] list){
        for (int li:list){
            System.out.println(li);
        }
        if(list==null|| list.length==0){

            System.out.println("没有余额发红包了");
            return ;
        }
        int index = new Random().nextInt(list.length);
        int delta = list[index];
        if(delta!=-1){
            System.out.println(delta);
            list[index] = -1;
            int money = super.getMoney();
            super.setMoney(delta + money);
        }

    }

}

//群主
class Manger extends User{

    public Manger(){}

    public Manger(int money, String name) {
        super(money, name);
    }
    public void showManger(){
        System.out.println("群主：" + this.name + "," + "金额：" + this.money);
    }
    public int[] send(int total, int count){
        int[] list = new int[count];
        int remain = super.getMoney();
        System.out.println("群主剩余余额为：" + remain);
        if(remain<total){
            System.out.println("余额不足！");
            return null;
        }
        super.setMoney(remain - total);

        Random random = new Random();

        Arrays.fill(list,1);
        int s = total-count;
        while (s>0){
            int x = random.nextInt(count); //随机选择红包序列号
            int y = random.nextInt(s); //生成随机金额数
            if (s == 1){
                list[x]++;
                break;
            }else {
                list[x] += y;
            }
            s -= y;

        }
        return list;


    }
}


public class Money {


    public static void main(String[] args) {
        Manger manger = new Manger(100,"老王");
        int[] list = manger.send(80,3);
        Member member = new Member(0,"小李");
        member.showMember();
        manger.showManger();
        if(list!=null){
            member.receive(list);
            member.showMember();
            manger.showManger();
        }else {
            System.out.println("群主余额不足");
        }
        System.out.println("--------------");
        int[] list2 = manger.send(30,3);
        member.showMember();
        manger.showManger();
        if(list!=null) {
            member.receive(list2);
            member.showMember();
            manger.showManger();


        }

    }
}
