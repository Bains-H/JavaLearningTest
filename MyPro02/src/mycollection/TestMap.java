package mycollection;

import java.util.HashMap;
import java.util.Map;

/**
 * ����HashMap��ʹ��
 * @author benfe
 *
 */

public class TestMap {
	public static void main(String[] args) {
		
		Map<Integer, String> m1 = new HashMap<>();
		
		m1.put(1, "one");
		m1.put(2, "two");
		m1.put(3, "Three");
		
		System.out.println(m1.get(1));
		
		System.out.println(m1.size());
		System.out.println(m1.isEmpty());
		System.out.println(m1.containsKey(2));
		System.out.println(m1.containsValue("four"));
		
		Map<Integer, String> m2 = new HashMap<>();
		m2.put(4, "��");
		m2.put(5, "��");
		
		m1.putAll(m2);
		
		System.out.println(m1);
		
		//map�м������ظ�������ظ����Ƿ��ظ�����equals�����жϣ������µĸ��Ǿɵ�
		m1.put(3, "��");
		System.out.println(m1);
	}

}