package mycollection;

import java.util.HashSet;
import java.util.Set;

/**
 * ����HsahSet�Ļ����÷�
 * @author huangbh
 * @date 2020��6��16��
 *
 */

public class TestHashSet {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		
		set1.add("aa");
		set1.add("bb");
		set1.add("aa");
		System.out.println(set1);
		set1.remove("bb");
		
	}
}
