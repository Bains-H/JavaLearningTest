package mycollection;

/**
 * �Զ���һ��HashMap
 * ʵ����put�������Ӽ�ֵ�ԣ�������˼��ظ���ʱ�򸲸���Ӧ�Ľڵ�,��дtoString
 * @author benfe
 *
 */

public class SxHashMap02 {
	
	Node[] table; //λͰ���顣 bucket array
	int size;	//��ŵļ�ֵ�Եĸ���
	
	public SxHashMap02() {
		table = new Node[16]; //����һ�붨���2��������
	}
	
	public void put(Object key, Object value) {
		//�����µĽڵ����
		Node newNode = new Node();
		newNode.hash = myHash(key.hashCode(),table.length);
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;
		
		Node tempNode = table[newNode.hash];
		Node iterLast = null; //���ڱ��������һ��Ԫ��
		
		boolean keyRepeat = false;
		
		if (tempNode == null) {
			//�˴�����Ԫ��Ϊ�գ���ֱ�ӽ��½ڵ�Ž�ȥ
			table[newNode.hash] = newNode;
		} else {
			//�˴�����Ԫ�ز�Ϊ�գ��������Ӧ����
			while(tempNode!=null) {
				//�ж�key����ظ����򸲸�
				if (tempNode.key.equals(key)) {
					System.out.println("key�ظ��ˣ���");
					keyRepeat = true;
					tempNode.value = value; //ֻ����value���ɣ�������ֵ(hash,key,next)���ֲ���
					
					break;
					
				} else {
					//key���ظ�,�������һ��
					iterLast = tempNode;
					tempNode = tempNode.next;
				}
			}
			
			if (!keyRepeat) {
				//û�з���key�ظ������������ӵ��������
				iterLast.next = newNode;
			}
			
		}
	}

	
	@Override
	public String toString() {
		//{10:aa,20:b}
				StringBuilder sBuilder = new StringBuilder('{');
				
				for (int i = 0; i < table.length; i++) {
					Node temNode = table[i];
					
					while (temNode!=null) {
						sBuilder.append(temNode.key+":"+temNode.value+",");
						temNode = temNode.next;
					}
				}
				sBuilder.setCharAt(sBuilder.length()-1, '}');
				return sBuilder.toString();
	}
	
	public static void main(String[] args) {
		SxHashMap02 m = new SxHashMap02();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(20, "ssss");
		
		m.put(53, "gg");
		m.put(69, "hh");
		m.put(85, "kk");
		
		System.out.println(m);
//		for (int i = 10; i < 100; i++) {
//			System.out.println(i+"---"+myHash(i,16));
//		}
		
	}
	
	public static int myHash(int v, int length) {
		System.out.println("hash in myHash:"+(v&(length-1))); //ֱ��λ���㣬Ч�ʸ�
		System.out.println("hash in myHsah:"+(v%(length-1))); //ȡģ���㣬Ч�ʵ�
		return v&(length-1);
	}
}
