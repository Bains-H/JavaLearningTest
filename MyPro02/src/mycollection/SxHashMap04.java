package mycollection;

/**
 * 自定义一个HashMap
 * 实现了get方法，根据键对象获得对应的值对象
 * @author benfe
 *
 */

public class SxHashMap04<K,V> {
	
	Node2[] table; //位桶数组。 bucket array
	int size;	//存放的键值对的个数
	
	public SxHashMap04() {
		table = new Node2[16]; //长度一半定义成2的整数幂
	}
	
	public V get(K key) {
		
		int hash = myHash(key.hashCode(), table.length);
		V value = null;
		
		if (table[hash] != null) {
			Node2 temNode2 = table[hash];
			
			while (temNode2!=null) {
				if (temNode2.key.equals(key)) {
					//如果相等，则说明找到了对应的键值对，返回相应的value
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
		
		//定义新的节点对象
		Node2 newNode2 = new Node2();
		newNode2.hash = myHash(key.hashCode(),table.length);
		newNode2.key = key;
		newNode2.value = value;
		newNode2.next = null;
		
		Node2 tempNode2 = table[newNode2.hash];
		Node2 iterLast = null; //正在遍历的最后一个元素
		
		boolean keyRepeat = false;
		
		if (tempNode2 == null) {
			//此处数组元素为空，则直接将新节点放进去
			table[newNode2.hash] = newNode2;
		} else {
			//此处数组元素不为空，则便利对应链表
			while(tempNode2!=null) {
				//判断key如果重复，则覆盖
				if (tempNode2.key.equals(key)) {
//					System.out.println("key重复了！！");
					keyRepeat = true;
					tempNode2.value = value; //只覆盖value即可，其他的值(hash,key,next)保持不变
					
					break;
					
				} else {
					//key不重复,则遍历下一个
					iterLast = tempNode2;
					tempNode2 = tempNode2.next;
				}
			}
			
			if (!keyRepeat) {
				//没有发生key重复的情况，则添加到链表最后。
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
//		System.out.println("hash in myHash:"+(v&(length-1))); //直接位运算，效率高
//		System.out.println("hash in myHsah:"+(v%(length-1))); //取模运算，效率低
		return v&(length-1);
	}
}
