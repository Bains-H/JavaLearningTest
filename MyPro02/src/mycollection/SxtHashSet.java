package mycollection;

import java.util.HashMap;

/**
 * 手动实现一个HashSet,更深刻理解HashSet底层原理
 * @author huangbh
 * @date 2020年6月16日
 *
 */

public class SxtHashSet {

	HashMap map;
	
	private static final Object PRESENT = new Object();
	
	public SxtHashSet() {
		// TODO Auto-generated constructor stub
		map = new HashMap();
	}
	
	public int size() {
		return map.size();
	}
	
	public void add(Object o) {
		map.put(o, PRESENT);
	}
	
	@Override
	public String toString() {

		StringBuilder sBuilder  = new StringBuilder();
		sBuilder.append("[");
		for (Object key : map.keySet()) {
			sBuilder.append(key+",");
		}
//		System.out.println(sBuilder.length()-1);
		sBuilder.setCharAt(sBuilder.length()-1, ']');//注意第二个参数是char不能使用双引号
		return sBuilder.toString();
	}
	
	public static void main(String[] args) {
		SxtHashSet set = new SxtHashSet();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		System.out.println(set);
	}
}
