package mycollection;

public class Test {
	public static void main(String[] args) {
		int h = 25860399;
		int length = 16;//length为2的整数次幂，这h&(length-1)相当于对length取模 
		myHash(h, length);
	}
	
	/**
	 * @param h 任意整数
	 * @param length 长度必须为2的整数幂
	 * @return
	 */
	public static int myHash(int h,int length) {
		System.out.println(h&(length-1));
		//length为2的整数幂情况下，和取余的值一样
		System.out.println(h%length);//取余数
		return h&(length-1);
		
	}

}
