package com.sxt.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * �ֽ���������� ByteArrayOutputStream
 * 1������Դ���ڲ�ά��
 * 2��ѡ������������Դ
 * 3������(д������)
 * 4���ͷ���Դ�����Բ���
 * 
 * ��ȡ���ݣ�toByteArray()
 * 
 * @author huang b.h
 * @date 2020.06.18 11:40:55
 */

public class IOTest07 {
	public static void main(String[] args) {
		//����Դ
		byte[] dest = null;
		//ѡ����  ��������
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			//����
			String mag = "shou me the code";
			byte[] datas = mag.getBytes();
			baos.write(datas,0,datas.length);
			baos.flush();
			//��ȡ����
			dest = baos.toByteArray();
			System.out.println(dest.length+"-->"+new String(dest,0,baos.size()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != baos) {
				//�ͷ���Դ
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
