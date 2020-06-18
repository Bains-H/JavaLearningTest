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
 * @date 2020年6月16日 下午5:02:19
 *
 */
public class TestIterator {
	public static void main(String[] args) {
//		TestIteratorList();
//		TestIteratorSet();
		TestIteratorMap();
	}
	
	//使用iterator遍历List
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
	
	//使用iterator遍历Set
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
	
	//使用iterator遍历Map
	public static void TestIteratorMap() {
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(100, "aa");
		map1.put(200, "bb");
		map1.put(300, "cc");
		
		//第一种遍历Map方式
		Set<Entry<Integer, String>>	ssEntries = map1.entrySet();
		for (Iterator<Entry<Integer, String>> iterator = ssEntries.iterator(); iterator.hasNext();) {
			Entry<Integer, String> tempEntry = (Entry<Integer, String>) iterator.next();
			System.out.println(tempEntry.getKey() + "---" + tempEntry.getValue());
		}
		
		System.out.println("************");
		//第二种遍历Map的方式
		Set<Integer> keySet = map1.keySet();
		for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext();) {
			Integer key = (Integer) iterator.next();
			System.out.println(key + "---" + map1.get(key));
		}
		
	}
}
