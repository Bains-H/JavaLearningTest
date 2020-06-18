package mycollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author huangbh
 * @date 2020��6��16�� ����5:02:19
 *
 */
public class TestIterator {
	public static void main(String[] args) {
//		TestIteratorList();
//		TestIteratorSet();
		TestIteratorMap();
	}
	
	//ʹ��iterator����List
	public static void TestIteratorList() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		for (Iterator<String> iterator = list.iterator() ; iterator.hasNext();) {
			String tenpString = iterator.next();
			System.out.println(tenpString);
		}
	}
	
	//ʹ��iterator����Set
	public static void TestIteratorSet() {
		Set<String> set = new HashSet<>();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		
		for (Iterator<String> iterator = set.iterator() ; iterator.hasNext();) {
			String tenpString = iterator.next();
			System.out.println(tenpString);
		}
	}
	
	//ʹ��iterator����Map
	public static void TestIteratorMap() {
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(100, "aa");
		map1.put(200, "bb");
		map1.put(300, "cc");
		
		//��һ�ֱ���Map��ʽ
		Set<Entry<Integer, String>>	ssEntries = map1.entrySet();
		for (Iterator<Entry<Integer, String>> iterator = ssEntries.iterator(); iterator.hasNext();) {
			Entry<Integer, String> tempEntry = (Entry<Integer, String>) iterator.next();
			System.out.println(tempEntry.getKey() + "---" + tempEntry.getValue());
		}
		
		System.out.println("************");
		//�ڶ��ֱ���Map�ķ�ʽ
		Set<Integer> keySet = map1.keySet();
		for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext();) {
			Integer key = (Integer) iterator.next();
			System.out.println(key + "---" + map1.get(key));
		}
		
	}
}
