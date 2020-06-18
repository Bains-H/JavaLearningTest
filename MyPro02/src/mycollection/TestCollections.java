/**
 * 
 */
package mycollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections辅助类的使用
 * @author huangbh
 * @date 2020年6月16日 下午5:27:27
 *
 */
public class TestCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("gao:"+i);
		}
		System.out.println(list);
		
		Collections.shuffle(list);//随机排列list中的元素
		System.out.println(list);
		
		Collections.reverse(list);//逆序排列
		System.out.println(list);
		
		Collections.sort(list);//按照递增的方式排列。自定义的类使用：Comparable接口
		System.out.println(list);
		
		//二分法查找
		System.out.println(Collections.binarySearch(list, "a3"));
		Collections.fill(list, "hello");
		System.out.println(list);
		
	}
}
