package com.sxt.thread;

/**
 * 
 * 
 * @author B.H.Huang
 * @date 2020.06.22 18:04:23 
 *
 */
public class IDownloader implements Runnable{
	private String url; //远程路径
	private String name; //存储名字
	
	
	public IDownloader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public void run() {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		IDownloader id1 = new IDownloader("http://seopic.699pic.com/photo/50030/5545.jpg_wh1200.jpg", "yd.jpg");
		IDownloader id2 = new IDownloader("https://img3.doubanio.com/view/subject/l/public/s29541140.jpg", "spl.jpg");
		IDownloader id3 = new IDownloader("https://www.ivsky.com/download_pic.html?picurl=/img/tupian/pic/201906/23/diannaoshouji-001.jpg", "phone.jpg");
		
		//启动三个线程
		new Thread(id1).start();
		new Thread(id2).start();
		new Thread(id3).start();
	}
}
