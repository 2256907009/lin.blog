package org.example;


abstract class Animal{
    protected int age;
    protected String color;

    public Animal(int age, String color) {
        this.age = age;
        this.color = color;
    }

    public abstract void eat(String something);
    public void lookHome(){
        System.out.println("汪汪，我在看家");
    }
    public void catchMouse(){
        System.out.println("喵喵，我在逮老鼠");
    }
}


class Dog extends Animal{


    public Dog(int age, String color) {
        super(age, color);
    }
    //        System.out.println("狗两只前腿死死的抱住骨头猛吃");
    @Override
    public void eat(String something) {
        System.out.println(this.age+ "岁的" + this.color + "颜色的狗两只前腿死死的" + something);
    }



}
class Cat extends Animal{

    public Cat(int age, String color) {
        super(age, color);
    }

    @Override
    public void eat(String something) {
        System.out.println(this.age + "岁的" + this.color + "颜色的猫眯着眼睛" + something);
    }
}

class Person{
    protected String name;
    protected int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }
    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void keepPet(Dog dog, String something){
        System.out.println("年龄为" + getAge() + "岁的" + getName() + "养了一只" + dog.color + "颜色的" + dog.age + "岁的宠物");
        dog.eat(something);
    }
    public void keepPet(Cat cat,String something){
        System.out.println("年龄为" + getAge() + "岁的" + getName() + "养了一只" + cat.color + "颜色的" + cat.age + "岁的宠物");
        cat.eat(something);
    }
}


public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog(2,"黑");
        Person person = new Person("老王",30);
        person.keepPet(dog,"抱着骨头猛吃");

        Cat cat = new Cat(3,"灰");
        Person person1 = new Person("老李",25);
        person1.keepPet(cat,"侧着头吃鱼");

    }





}
