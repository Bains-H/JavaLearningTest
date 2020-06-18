package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 面向对象思想封装 分割
 * 
 * @author B.H.Huang
 * @date 2020.06.18 16:57:22 
 *
 */
public class SplitFile {
	
	public static void main(String[] args) throws IOException{
		SplitFile sf = new SplitFile("src/com/sxt/io/RandTest01.java", "dest", 1024*10);
		sf.split();
		sf.merge("merge.java");
		sf.merge2("merge.java");
	}
	
	//源头
	private File src;
	//目的地（文件）
	private String destDir;
	//所有分割后的文件存储路径
	private List<String> destPaths;
	//每块大小
	private int blockSize;
	//块数：多少块
	private int size;
	
	
	/**
	 * @param src
	 * @param destDir
	 * @param blockSize
	 */
	public SplitFile(String srcPath, String destDir, int blockSize) {
		super();
		this.src = new File(srcPath);
		this.destDir = destDir;
		this.blockSize = blockSize;
		this.destPaths = new ArrayList<String>();
		
		//初始化
		init();
	}
	
	//初始化
	private void init(){
		//总长度
		long len = this.src.length();
		//块数：多少块
		this.size = (int) Math.ceil(len*1.0/blockSize);
		//路径
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
		}
	}
	
	/**
	 * 分割
	 * 1、计算每一块的起始位置及大小
	 * 2、分割
	 * @throws IOException 
	 */
	public void split() throws IOException {
		//总长度
		long len = src.length();
		//起始位置和实际大小
		int beginPos = 0;
		int actuaSize = (int) (blockSize>len?len:blockSize);
		for (int i = 0; i < size; i++) {
			beginPos = i*blockSize;
			if (i == size-1) {//最后一块
				actuaSize = (int) len;
			} else {
				actuaSize = blockSize;
				len -= actuaSize;//剩余量
			}
			splitDetail(i, beginPos, actuaSize);
		}		
	}
	
	//指定第i块的起始位置和实际长度
	private void splitDetail(int i,int beginPos, int actualSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(this.src, "r");
		RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i),"rw");
		//起始位置
		//实际大小
		//随机读取
		raf.seek(beginPos);
		//读取
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
			if (actualSize>len) {//获取本次读取的所有内容
//				System.out.println(new String(flush,0,len));
				raf2.write(flush,0,len);
				actualSize -= len;
			} else {
//				System.out.println(new String(flush,0,actualSize));
				raf2.write(flush,0,actualSize);
				break;
			}
		}
		raf2.close();
		raf.close();
	}
	
	//文件的合并
	public void merge(String destPath) throws IOException {
		//输出流
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
		//输入流
		for (int i = 0; i < destPaths.size(); i++) {
			InputStream is = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
			
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush,0,len);
			}
			os.flush();
			is.close();
		}
		os.close();
	}
	
	//文件的合并
		public void merge2(String destPath) throws IOException {
			//输出流
			OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
			Vector<InputStream> vi = new Vector<InputStream>();
			SequenceInputStream sis = null;
			//输入流
			for (int i = 0; i < destPaths.size(); i++) {
				vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
				
			}
			sis = new SequenceInputStream(vi.elements());
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len = sis.read(flush)) != -1) {
				os.write(flush,0,len);
			}
			os.flush();
			sis.close();
			os.close();
		}
}
