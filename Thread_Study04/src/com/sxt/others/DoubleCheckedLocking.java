package com.sxt.others;

/**
 * DCL����ģʽ������ʽ��·�Ļ����ϼ��벢������֤�ڶ��̻߳����£��������һ������
 * 1������˽�л� --> ������new������
 * 2���ṩ˽�еľ�̬���� --> �洢����ĵ�ַ
 * 3���ṩ�����ľ�̬���� --> ��ȡ����
 * 
 * @author B.H.Huang
 * @date 2020.06.28 20:00:27 
 *
 */
public class DoubleCheckedLocking {
	//2���ṩ˽�еľ�̬����
	//û��volatile�����߳̿��ܷ���һ��û�г�ʼ���Ķ���
	private static volatile DoubleCheckedLocking instance;
	//1��������˽�л�
	private DoubleCheckedLocking() {
		
	}
	
	//3���ṩ�����ľ�̬���� --> ��ȡ����
		public static DoubleCheckedLocking getInstance(long time) {
			//�ٴμ��
			if (null != instance) {//���ⲻ��Ҫ��ͬ�����Ѿ����ڶ���
				return instance;
			}
			if (null == instance) {
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				instance = new DoubleCheckedLocking();
				//1�����ٿռ�
				//2����ʼ��������Ϣ
				//3�����ض���ĵ�ַ������
			}
			
			return instance;
		}
	
	//3���ṩ�����ľ�̬���� --> ��ȡ����
	public static DoubleCheckedLocking getInstance1(long time) {
		//�ٴμ��
		if (null != instance) {//���ⲻ��Ҫ��ͬ�����Ѿ����ڶ���
			return instance;
		}
		synchronized (DoubleCheckedLocking.class) {
			if (null == instance) {
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				instance = new DoubleCheckedLocking();
				//1�����ٿռ�
				//2����ʼ��������Ϣ
				//3�����ض���ĵ�ַ������
			}
		}
		
		return instance;
	}
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			System.out.println(DoubleCheckedLocking.getInstance1(500));
		});
		t.start();
		System.out.println(DoubleCheckedLocking.getInstance1(1000));
	}
}
