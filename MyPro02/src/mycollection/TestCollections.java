/**
 * 
 */
package mycollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections�������ʹ��
 * @author huangbh
 * @date 2020��6��16�� ����5:27:27
 *
 */
public class TestCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("gao:"+i);
		}
		System.out.println(list);
		
		Collections.shuffle(list);//�������list�е�Ԫ��
		System.out.println(list);
		
		Collections.reverse(list);//��������
		System.out.println(list);
		
		Collections.sort(list);//���յ����ķ�ʽ���С��Զ������ʹ�ã�Comparable�ӿ�
		System.out.println(list);
		
		//���ַ�����
		System.out.println(Collections.binarySearch(list, "a3"));
		Collections.fill(list, "hello");
		System.out.println(list);
		
	}
}
