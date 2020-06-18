package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * ������
 * 1��д�����ȡ
 * 2.��ȡ��˳����д������һ��
 * 
 * DataOutputStream
 * DataInputStream
 * 
 * @author B.H.Huang
 * @date 2020.06.18 16:05:36 
 *
 */
public class DataTest {
	public static void main(String[] args) throws IOException {
		//д��
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
		//������������+����
		dos.writeUTF("����������");
		dos.writeInt(8);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas = baos.toByteArray();
		//��ȡ
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//˳����д��һֱ
		String msg = dis.readUTF();
		int age = dis.readInt();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		System.out.println(flag);
	}
}
