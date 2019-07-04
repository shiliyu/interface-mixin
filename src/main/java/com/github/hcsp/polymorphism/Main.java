package com.github.hcsp.polymorphism;

public class Main {
    private static class animal{
        private String name;

        animal(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    interface 会跑 {
        default void 跑() {
            System.out.println("乌龟跑啊跑啊跑");
        }
    }

    interface 会游泳 {
        default void 游泳() {
            System.out.println("乌龟游啊游啊游");
        }
    }

    static class 猫 extends animal implements 会跑 {
        猫() {
            super("小花猫");
        }

        @Override
        public void 跑() {
            System.out.println(getName() + "跑啊跑啊跑");
        }
    }

    static class 鱼 extends animal implements 会游泳 {
        鱼() {
            super("鱼");
        }

        @Override
        public void 游泳() {
            System.out.println(getName() + "游啊游啊游");
        }
    }

    // 现在 乌龟 想要同时复用会跑和会游泳的代码
    // 请尝试通过接口的默认方法实现mixin
    // 从而实现最大程度的代码复用
    //
    static class 乌龟 extends animal implements 会跑, 会游泳 {
        乌龟() {
            super("乌龟");
        }
    }

    public static void main(String[] args) {
        new 乌龟().跑();
        new 乌龟().游泳();
    }
}
