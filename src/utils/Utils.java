package utils;

import java.util.List;

public class Utils {

    public static final <T> void print(T a) {
        System.out.print(a);
    }

    public static final <T> void println(T a) {
        System.out.println(a);
    }

    public static final <T> void printList(List<T> lists) {
        System.out.print("[");
        for (T item: lists) {
            System.out.print(item);
            System.out.print(",");
        }
        System.out.println("]");
    }

    public static final <T> void printNestList(List<List<T>> lists) {
        for (List<T> list : lists) {
            System.out.print("[");
            for (T item: list) {
                System.out.print(item);
                System.out.print(",");
            }
            System.out.println("]");
        }
    }

    public static final void printArray() {

    }

    public static final void printNestArray() {

    }
}
