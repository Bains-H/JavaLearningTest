package mycollection;

import java.util.HashMap;

/**
 * �ֶ�ʵ��һ��HashSet,��������HashSet�ײ�ԭ��
 * @author huangbh
 * @date 2020��6��16��
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
		sBuilder.setCharAt(sBuilder.length()-1, ']');//ע��ڶ���������char����ʹ��˫����
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
