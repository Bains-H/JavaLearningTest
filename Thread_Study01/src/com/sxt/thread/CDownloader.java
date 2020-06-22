package com.sxt.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * �˽ⴴ���̵߳ķ�ʽ��
 * 
 * @author B.H.Huang
 * @date 2020.06.22 18:04:23 
 *
 */
public class CDownloader implements Callable<Boolean>{
	private String url; //Զ��·��
	private String name; //�洢����
	
	
	public CDownloader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public Boolean call() throws Exception {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
		return true;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CDownloader cd1 = new CDownloader("http://seopic.699pic.com/photo/50030/5545.jpg_wh1200.jpg", "yd.jpg");
		CDownloader cd2 = new CDownloader("https://img3.doubanio.com/view/subject/l/public/s29541140.jpg", "spl.jpg");
		CDownloader cd3 = new CDownloader("https://www.ivsky.com/download_pic.html?picurl=/img/tupian/pic/201906/23/diannaoshouji-001.jpg", "phone.jpg");
		
		//����ִ�з���
		ExecutorService ser = Executors.newFixedThreadPool(3);
		//�ύִ��
		Future<Boolean> result1 = ser.submit(cd1);
		Future<Boolean> result2 = ser.submit(cd2);
		Future<Boolean> result3 = ser.submit(cd3);
		//��ȡ���
		boolean r1 = result1.get();
		boolean r2 = result2.get();
		boolean r3 = result3.get();
		//�رշ���
		ser.shutdownNow();
	}
}
