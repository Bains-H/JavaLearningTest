package mycollection;

/**
 * �Զ���һ��HashMap
 * ʵ����get���������ݼ������ö�Ӧ��ֵ����
 * @author benfe
 *
 */

public class SxHashMap04<K,V> {
	
	Node2[] table; //λͰ���顣 bucket array
	int size;	//��ŵļ�ֵ�Եĸ���
	
	public SxHashMap04() {
		table = new Node2[16]; //����һ�붨���2��������
	}
	
	public V get(K key) {
		
		int hash = myHash(key.hashCode(), table.length);
		V value = null;
		
		if (table[hash] != null) {
			Node2 temNode2 = table[hash];
			
			while (temNode2!=null) {
				if (temNode2.key.equals(key)) {
					//�����ȣ���˵���ҵ��˶�Ӧ�ļ�ֵ�ԣ�������Ӧ��value
					value = (V) temNode2.value;
					break;
				} else {
					temNode2 = temNode2.next;
				}
			}
		}
		return value;
	}
	
	public void put(K key, V value) {
		
		//�����µĽڵ����
		Node2 newNode2 = new Node2();
		newNode2.hash = myHash(key.hashCode(),table.length);
		newNode2.key = key;
		newNode2.value = value;
		newNode2.next = null;
		
		Node2 tempNode2 = table[newNode2.hash];
		Node2 iterLast = null; //���ڱ��������һ��Ԫ��
		
		boolean keyRepeat = false;
		
		if (tempNode2 == null) {
			//�˴�����Ԫ��Ϊ�գ���ֱ�ӽ��½ڵ�Ž�ȥ
			table[newNode2.hash] = newNode2;
		} else {
			//�˴�����Ԫ�ز�Ϊ�գ��������Ӧ����
			while(tempNode2!=null) {
				//�ж�key����ظ����򸲸�
				if (tempNode2.key.equals(key)) {
//					System.out.println("key�ظ��ˣ���");
					keyRepeat = true;
					tempNode2.value = value; //ֻ����value���ɣ�������ֵ(hash,key,next)���ֲ���
					
					break;
					
				} else {
					//key���ظ�,�������һ��
					iterLast = tempNode2;
					tempNode2 = tempNode2.next;
				}
			}
			
			if (!keyRepeat) {
				//û�з���key�ظ������������ӵ��������
				iterLast.next = newNode2;
			}
			
		}
	}

	
	@Override
	public String toString() {
		//{10:aa,20:b}
				StringBuilder sBuilder = new StringBuilder('{');
				
				for (int i = 0; i < table.length; i++) {
					Node2 temNode2 = table[i];
					
					while (temNode2!=null) {
						sBuilder.append(temNode2.key+":"+temNode2.value+",");
						temNode2 = temNode2.next;
					}
				}
				sBuilder.setCharAt(sBuilder.length()-1, '}');
				return sBuilder.toString();
	}
	
	public static void main(String[] args) {
		SxHashMap04<Integer, String> m = new SxHashMap04<>();
		m.put(10, "aa");
		m.put(20, "bb");

		System.out.println(m.get(20));
		
//		for (int i = 10; i < 100; i++) {
//			System.out.println(i+"---"+myHash(i,16));
//		}
		
	}
	
	public static int myHash(int v, int length) {
//		System.out.println("hash in myHash:"+(v&(length-1))); //ֱ��λ���㣬Ч�ʸ�
//		System.out.println("hash in myHsah:"+(v%(length-1))); //ȡģ���㣬Ч�ʵ�
		return v&(length-1);
	}
}
