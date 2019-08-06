package com.base.test;

import java.util.HashSet;

public class t1 {

    public static void main(String[] args) {
        Person p1 = new Person("eee",100);
        Person p2 = new Person("eee",100);
        Person p3 = new Person("eee",200);
        Person p4 = new Person("EEE",100);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
        System.out.println(p1.equals(p4));

        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        System.out.println(set);
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name,int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object obj){
            if(obj == null){
                return false;
            }
            if(this == obj){
                return true;
            }
            //判断是否类型相同
            if(this.getClass() != obj.getClass()){
                return false;
            }

            Person person = (Person)obj;
            return name.equals(person.name) && age==person.age;
        }

        @Override
        public int hashCode(){
            int namehash = name.toUpperCase().hashCode();
            return namehash ^ this.age;
        }
    }

}
