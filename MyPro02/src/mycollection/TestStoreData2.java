/**
 * 
 */
package mycollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试表格数据的存储
 * 体会ORM思想
 * 每一行数据使用javabean对象存储，多行使用放到map或者list中
 * @author b.h.huang
 * @time 2020.06.16 17:55:00
 *
 */
public class TestStoreData2 {
	public static void main(String[] args) {
		User user1 = new User(1001,"张三",20000,"2018.5.5");
		User user2 = new User(1002,"李四",30000,"2005.4.4");
		User user3 = new User(1003,"王五",3000,"2020.5.4");
		
		List<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		for (User user : list) {
			System.out.println(user);
		}
		
		System.out.println("**************");
		
		Map<Integer, User> map = new HashMap<Integer, User>();
		map.put(1001, user1);
		map.put(1002, user2);
		map.put(1003, user3);
		
		Set<Integer> keySet = map.keySet();
		for (Integer key : keySet) {
			System.out.println(map.get(key));
		}
	}
}

class User{
	private int id;
	private String name;
	private double salary;
	private String hiredate;
	
	public User() {
		
	}
	
	public User(int id, String name, double salary, String hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hiredate = hiredate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id+" name:"+name+" salary:"+" 入职日期："+hiredate;
	}
}
