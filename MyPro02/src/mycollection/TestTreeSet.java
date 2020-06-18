package mycollection;

import java.util.Set;
import java.util.TreeSet;

/**
 * ����ʹ��TreeSet
 * @author huangbh
 * @date 2020��6��16��
 *
 */

public class TestTreeSet {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		
		set.add(300);
		set.add(200);
		set.add(600);
		
		//����Ԫ�ص����ķ�ʽ����
		for (Integer m : set) {
			System.out.println(m);
		}
		
		Set<Emp2> set2 = new TreeSet();
		set2.add(new Emp2(100, "����", 3000));
		set2.add(new Emp2(50, "����", 2000));
		set2.add(new Emp2(150, "����", 8000));
		set2.add(new Emp2(30, "����", 20000));
		
		for (Emp2 mEmp2 : set2) {
			System.out.println(mEmp2);
		}
	}
}

class Emp2 implements Comparable<Emp2>{
	int id;
	String name;
	double salary;
	
	public Emp2(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id+" name:"+name+" salary:" + salary;
	}
	
	@Override
	public int compareTo(Emp2 o) {
		// TODO Auto-generated method stub
		//
		if (this.salary > o.salary) {
			return 1;
		}else if (this.salary < o.salary) {
			return -1;
		}else {
			if (this.id > o.id) {
				return 1;
			}else if (this.id < o.id) {
				return -1;
			}else {
				return 0;
			}
		}
	}
}

