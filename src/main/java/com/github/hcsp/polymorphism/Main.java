package com.github.hcsp.polymorphism;

public class Main {

    interface 会跑 {
        void 跑();
    }

    interface 会游泳 {
        void 游泳();
    }

    abstract static class 会跑的东西 implements 会跑 {
        String name;

        会跑的东西(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        public void 跑() {
            System.out.println(name + "跑啊跑啊跑");
        }
    }

    abstract static class 会游泳的东西 implements 会游泳 {
        String name;

        会游泳的东西(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        public void 游泳() {
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

    // 现在 乌龟 想要同时复用会跑和会游泳的代码
    // 请尝试通过接口的默认方法实现mixin
    // 从而实现最大程度的代码复用
    //
    static class 乌龟 extends 会游泳的东西 implements 会跑 {
        乌龟() {
            super("乌龟");
        }

        @Override
        public void 跑() {
            System.out.println(super.name + "跑啊跑啊跑");
        }
    }

    public static void main(String[] args) {
        new 乌龟().跑();
        new 乌龟().游泳();
    }
}
