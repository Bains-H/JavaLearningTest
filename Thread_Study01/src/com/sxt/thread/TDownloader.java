package com.sxt.thread;

/**
 * 
 * 
 * @author B.H.Huang
 * @date 2020.06.22 18:04:23 
 *
 */
public class TDownloader extends Thread{
	private String url; //远程路径
	private String name; //存储名字
	
	
	public TDownloader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public void run() {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
	}
	
	public static void main(String[] args) {
		TDownloader td1 = new TDownloader("http://seopic.699pic.com/photo/50030/5545.jpg_wh1200.jpg", "yd.jpg");
		TDownloader td2 = new TDownloader("https://img3.doubanio.com/view/subject/l/public/s29541140.jpg", "spl.jpg");
		TDownloader td3 = new TDownloader("https://www.ivsky.com/download_pic.html?picurl=/img/tupian/pic/201906/23/diannaoshouji-001.jpg", "phone.jpg");
		
		//启动三个线程
		td1.start();
		td2.start();
		td3.start();
	}
}
