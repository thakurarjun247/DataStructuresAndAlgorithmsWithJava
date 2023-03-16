package javabasics.collections;

import java.util.*;

public class ComparatorComparable {

    public static void main(String[] args) {
        final Employee emp1 = new Employee("a");
        final Employee emp2 = new Employee("b");
        final Employee emp3 = new Employee("c");

		Map<String, String> map = new HashMap<>();
        map.put(null, null);
		map.put(null, "empty");
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		hashTable.put("a", "b");
		System.out.println("hashTable"+hashTable);
		System.out.println(map);
		Set<Employee> set = new HashSet<>();
		set.add(null);
		set.add(emp2);
		set.add(emp1);
		System.out.println(set);
		System.out.println(emp1.equals(emp3));
		System.out.println(emp1 == emp3);
		System.out.println(emp1.getEmail());
		System.out.println(emp1 == emp3);
        Set<Employee> treeSet = new TreeSet<Employee>((Employee e1, Employee e2) -> {
            if (e1 == null || e2 == null || e1.getClass() != Employee.class || e2.getClass() != Employee.class) {
                throw new ClassCastException("null");
            }
            return e1.getEmail().compareTo(e2.getEmail());
        });
        treeSet.add(emp3);
        treeSet.add(emp1);
        treeSet.add(emp2);
        // treeSet.add(null);
        treeSet.forEach(item -> System.out.print(item + " "));
        String s = new String("xyz");
        s.intern();
        List<Employee> list = new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp3);
        Collections.sort(list);
        list.sort(new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getEmail().compareTo(o1.getEmail());
            }

        });
      //  list.sort((e1,e2)-> e2.getEmail().compareTo(e1.getEmail()));
        System.out.println(list);
        // System.out.println(treeSet);
    }

}

class Employee implements Comparable<Employee> {

    String email;

    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Employee(String email) {
        super();
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Employee emp = null;
          if (obj instanceof Employee) {
            emp = (Employee) obj;
        }
        // TODO Auto-generated method stub
        return this.getEmail().equals(emp.getEmail());
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getEmail();
    }

    @Override
    public int compareTo(Employee o) {
        return this.getEmail().compareTo(o.getEmail());
    }
}
