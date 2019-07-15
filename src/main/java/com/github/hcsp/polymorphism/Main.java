package com.github.hcsp.polymorphism;

public class Main {
    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }
    interface 会跑 {
        void 跑();
    }

    interface 会游泳 {
        void 游泳();
    }

    static class 猫 extends Animal implements 会跑 {
        猫() {
            super("小花猫");
        }
        @Override
        public void 跑() {
            System.out.println(name + "跑啊跑啊跑");
        }
    }

    static class 鱼 extends Animal implements 会游泳 {
        鱼() {
            super("鱼");
        }
        @Override
        public void 游泳() {
            System.out.println(name + "游啊游啊游");
        }
    }

    // 现在 乌龟 想要同时复用会跑和会游泳的代码
    // 请尝试通过接口的默认方法实现mixin
    // 从而实现最大程度的代码复用
    //
    static class 乌龟 extends Animal implements 会跑, 会游泳 {
        乌龟() {
            super("乌龟");
        }
        @Override
        public void 跑() {
            System.out.println(name + "跑啊跑啊跑");
        }
        
        @Override
        public void 游泳() {
            System.out.println(name + "游啊游啊游");
        }
    }

    public static void main(String[] args) {
        new 乌龟().跑();
        new 乌龟().游泳();
    }
}
