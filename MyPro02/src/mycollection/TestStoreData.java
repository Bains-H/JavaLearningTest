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
 * ���Ա�����ݵĴ洢
 * ORM˼��ļ�ʵ�֣�map��ʾһ�����ݣ���������Ƕ��map�������map�ŵ�list��
 * @author huangbh
 * @date 2020��6��16�� ����5:36:21
 *
 */
public class TestStoreData {
	public static void main(String[] args) {
		
		Map<String, Object> row1 = new HashMap<>();
		row1.put("id", 1001);
		row1.put("name", "����");
		row1.put("salary", 20000);
		row1.put("��ְ����", "2018.05.05");
		
		Map<String, Object> row2 = new HashMap<>();
		row2.put("id", 1002);
		row2.put("name", "����");
		row2.put("salary", 30000);
		row2.put("��ְ����", "2005.04.04");
		
		Map<String, Object> row3 = new HashMap<>();
		row3.put("id", 1003);
		row3.put("name", "����");
		row3.put("salary", 3000);
		row3.put("��ְ����", "2020.05.04");
		
		List<Map<String, Object>> table1 = new ArrayList<Map<String,Object>>();
		table1.add(row1);
		table1.add(row2);
		table1.add(row3);
		
		for (Map<String, Object> row : table1) {
			Set<String> keySet = row.keySet();
			for (String key : keySet) {
				System.out.print(key + ":" + row.get(key) + "\t");
			}
			System.out.println();
		}
	}
}
