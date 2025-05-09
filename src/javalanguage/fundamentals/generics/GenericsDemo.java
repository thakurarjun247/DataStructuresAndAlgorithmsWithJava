package javalanguage.fundamentals.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GenericsDemo {
    public static void main(String[] args) {
        ObjectPool<Integer> integerObjectPool = new ObjectPool<>();
        integerObjectPool.setItem(1);
        System.out.println(integerObjectPool.getItem());
    }
}

class ObjectPool<T> {


    List<T> list = new ArrayList<>();
    //error
    //ChildObjectPool childObjectPool= new ChildObjectPool(5);
    ChildObjectPool childObjectPool = new ChildObjectPool(new Child());
    private T item;

    public T getItem() {
        if (list.isEmpty())
            throw new NoSuchElementException("empty list");
        return list.get(0);
    }

    public void setItem(T item) {
        list.add(item);
    }
}

class Parent {
}

class Child extends Parent {
}


record ChildObjectPool<U extends Parent>(U u) {
}







