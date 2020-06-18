package mycollection;

/**
 * 自定义一个HashMap
 * 实现了put方法增加键值对，并解决了键重复的时候覆盖相应的节点,重写toString
 * @author benfe
 *
 */

public class SxHashMap02 {
	
	Node[] table; //位桶数组。 bucket array
	int size;	//存放的键值对的个数
	
	public SxHashMap02() {
		table = new Node[16]; //长度一半定义成2的整数幂
	}
	
	public void put(Object key, Object value) {
		//定义新的节点对象
		Node newNode = new Node();
		newNode.hash = myHash(key.hashCode(),table.length);
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;
		
		Node tempNode = table[newNode.hash];
		Node iterLast = null; //正在遍历的最后一个元素
		
		boolean keyRepeat = false;
		
		if (tempNode == null) {
			//此处数组元素为空，则直接将新节点放进去
			table[newNode.hash] = newNode;
		} else {
			//此处数组元素不为空，则便利对应链表
			while(tempNode!=null) {
				//判断key如果重复，则覆盖
				if (tempNode.key.equals(key)) {
					System.out.println("key重复了！！");
					keyRepeat = true;
					tempNode.value = value; //只覆盖value即可，其他的值(hash,key,next)保持不变
					
					break;
					
				} else {
					//key不重复,则遍历下一个
					iterLast = tempNode;
					tempNode = tempNode.next;
				}
			}
			
			if (!keyRepeat) {
				//没有发生key重复的情况，则添加到链表最后。
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
		System.out.println("hash in myHash:"+(v&(length-1))); //直接位运算，效率高
		System.out.println("hash in myHsah:"+(v%(length-1))); //取模运算，效率低
		return v&(length-1);
	}
}
