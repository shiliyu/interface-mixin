package com.github.hcsp.polymorphism;

public class Main {
    interface 会跑 {

//        default 会跑(String name) {
//            this.name = name;
//        }
//
//        default String getName() {
//            return name;
//        }

        void 跑() ;
//        {
//            System.out.println(name + "跑啊跑啊跑");
//        }
    }

    interface 会游泳 {


//        default 会游泳(String name) {
//            this.name = name;
//        }
//
//        default String getName() {
//            return name;
//        }

        void 游泳();
//        {
//            System.out.println(name + "游啊游啊游");
//        }
    }

    static abstract class 会跑的东西 implements 会跑{
        String name;
        会跑的东西(String name){
            this.name = name;
        }
        String getName(){
            return this.name;
        }
        @Override
        public void 跑(){
            System.out.println(name + "跑啊跑啊跑");
        }
    }

    static abstract class 会游泳的东西 implements  会游泳{
        String name;
        会游泳的东西(String name){
            this.name = name;
        }
        String getName(){
            return this.name;
        }
        public void 游泳(){
            System.out.println(name + "游啊游啊游");
        }
    }

    static class 猫 extends 会跑的东西 {
        猫() {
            super("小花猫");
        }
    }

    static class 鱼 extends 会游泳的东西 {
        鱼() {
            super("鱼");
        }
    }

    static class 乌龟 extends 会跑的东西 implements 会游泳{
        乌龟(){
            super("小乌龟");
        }
        public void 游泳(){
            System.out.println(super.name + "游啊游啊游");
        }
    }
    // 现在 乌龟 想要同时复用会跑和会游泳的代码
    // 请尝试通过接口的默认方法实现mixin
    // 从而实现最大程度的代码复用
    //
    // static class 乌龟 extends 会跑, 会游泳 {
    // }

    public static void main(String[] args) {
        new 乌龟().跑();
        new 乌龟().游泳();
    }
}
