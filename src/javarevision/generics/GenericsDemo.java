package javarevision.generics;
import java.util.*;
public class GenericsDemo {
    public static void main(String[] args) {
        ObjectPool<Integer> integerObjectPool = new ObjectPool<>();
        integerObjectPool.setItem(1);
        System.out.println(integerObjectPool.getItem());    }
}

     class ObjectPool<T> {


        List<T> list= new ArrayList<>();
       private T item;

        public T getItem() {
            if(list.isEmpty())
                throw new NoSuchElementException("empty list");
            return list.get(0);
        }

        public void setItem(T item) {
            list.add(item);
        }


    }

