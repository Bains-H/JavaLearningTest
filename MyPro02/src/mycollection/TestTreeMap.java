package mycollection;

import java.util.Map;
import java.util.TreeMap;

/**
 * ����TreeMap
 * @author huangbh
 * @date 2020��6��16��
 *
 */
public class TestTreeMap {
	public static void main(String[] args) {
		Map<Integer, String> treeMap1 = new TreeMap<>();
		treeMap1.put(20, "aa");
		treeMap1.put(3, "bb");
		treeMap1.put(6, "cc");
		
		//����key�����ķ�ʽ����
		for (Integer key : treeMap1.keySet()) {
			System.out.println(key+"---"+treeMap1.get(key));
		}
		
		Map<Emp, String> treeMap2 = new TreeMap<>();
		treeMap2.put(new Emp(100, "����", 50000), "������һ����С��");
		treeMap2.put(new Emp(200, "����", 5000), "���Ĺ���������");
		treeMap2.put(new Emp(150, "����", 6000), "���幤���ò���");
		treeMap2.put(new Emp(50, "����", 6000), "�����Ǹ����Ĺ�");
		
		//����key�����ķ�ʽ����
		for (Emp key : treeMap2.keySet()) {
			System.out.println(key+"---"+treeMap2.get(key));
		}
	}
}

class Emp implements Comparable<Emp>{
	int id;
	String name;
	double salary;
	
	public Emp(int id, String name, double salary) {
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
	public int compareTo(Emp o) {
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
