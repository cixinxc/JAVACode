package com.cixin.EffectiveJava.Builder;

/**
 * Created by cixinxc on 2017/4/19.
 */
public class BuildePerson {
    private final String id;
    private final String name;
    private final int age;

    public BuildePerson(Builder builder) {
        id = builder.id;
        name = builder.name;
        age = builder.age;
    }

    public static class Builder {
        private final String id;
        private String name;
        private int age;

        public Builder(String id){
            this.id = id;
        }

        public Builder Name(String name) {
            this.name = name;
            return this;
        }
        public Builder Age(int age) {
            this.age = age;
            return this;
        }

        public BuildePerson build() {
            return new BuildePerson(this);
        }
    }
    /*
    * ÷ÿ–¥toString()∑Ω∑®
    * */
    @Override
    public String toString() {
        return "BuildePerson@id:"+this.id;
    }
}
