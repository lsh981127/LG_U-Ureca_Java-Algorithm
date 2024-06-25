package Uplus_Java_Class;

import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQueue {
    static class Car {


        String name;
        int year;

        Car(String name, int year) {
            this.name = name;
            this.year = year;
        }

        @Override
        public String toString() {
            return name + " " +year;
        }
    }


    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        /*
        pq.offer(21);
        pq.offer(11);
        pq.offer(32);
        System.out.println(pq);
        while(!pq.isEmpty()) {
            System.out.println(pq.poll() + " ");
        }
        System.out.println();*/


        PriorityQueue<Car> pq = new PriorityQueue<>((o1,o2) -> -Integer.compare(o1.year, o2.year));      // 역순
        pq.offer(new Car("아방이", 2024));
        pq.offer(new Car("그란데", 2018));
        System.out.println(pq);

     }
}
