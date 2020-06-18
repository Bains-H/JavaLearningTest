package mycollection;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试TreeMap
 * @author huangbh
 * @date 2020年6月16日
 *
 */
public class TestTreeMap {
	public static void main(String[] args) {
		Map<Integer, String> treeMap1 = new TreeMap<>();
		treeMap1.put(20, "aa");
		treeMap1.put(3, "bb");
		treeMap1.put(6, "cc");
		
		//按照key递增的方式排序
		for (Integer key : treeMap1.keySet()) {
			System.out.println(key+"---"+treeMap1.get(key));
		}
		
		Map<Emp, String> treeMap2 = new TreeMap<>();
		treeMap2.put(new Emp(100, "张三", 50000), "张三是一个好小伙");
		treeMap2.put(new Emp(200, "李四", 5000), "李四工作不积极");
		treeMap2.put(new Emp(150, "王五", 6000), "王五工作好不错");
		treeMap2.put(new Emp(50, "赵六", 6000), "赵六是个开心果");
		
		//按照key递增的方式排序
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
