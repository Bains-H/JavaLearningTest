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
 * �������˼���װ �ָ�
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
	
	//Դͷ
	private File src;
	//Ŀ�ĵأ��ļ���
	private String destDir;
	//���зָ����ļ��洢·��
	private List<String> destPaths;
	//ÿ���С
	private int blockSize;
	//���������ٿ�
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
		
		//��ʼ��
		init();
	}
	
	//��ʼ��
	private void init(){
		//�ܳ���
		long len = this.src.length();
		//���������ٿ�
		this.size = (int) Math.ceil(len*1.0/blockSize);
		//·��
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
		}
	}
	
	/**
	 * �ָ�
	 * 1������ÿһ�����ʼλ�ü���С
	 * 2���ָ�
	 * @throws IOException 
	 */
	public void split() throws IOException {
		//�ܳ���
		long len = src.length();
		//��ʼλ�ú�ʵ�ʴ�С
		int beginPos = 0;
		int actuaSize = (int) (blockSize>len?len:blockSize);
		for (int i = 0; i < size; i++) {
			beginPos = i*blockSize;
			if (i == size-1) {//���һ��
				actuaSize = (int) len;
			} else {
				actuaSize = blockSize;
				len -= actuaSize;//ʣ����
			}
			splitDetail(i, beginPos, actuaSize);
		}		
	}
	
	//ָ����i�����ʼλ�ú�ʵ�ʳ���
	private void splitDetail(int i,int beginPos, int actualSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(this.src, "r");
		RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i),"rw");
		//��ʼλ��
		//ʵ�ʴ�С
		//�����ȡ
		raf.seek(beginPos);
		//��ȡ
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
			if (actualSize>len) {//��ȡ���ζ�ȡ����������
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
	
	//�ļ��ĺϲ�
	public void merge(String destPath) throws IOException {
		//�����
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
		//������
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
	
	//�ļ��ĺϲ�
		public void merge2(String destPath) throws IOException {
			//�����
			OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
			Vector<InputStream> vi = new Vector<InputStream>();
			SequenceInputStream sis = null;
			//������
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
