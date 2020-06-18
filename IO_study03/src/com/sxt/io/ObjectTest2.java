package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * ������
 * 1��д�����ȡ
 * 2����ȡ��˳����д������һ��
 * 3���������еĶ��󶼿������л�Serializable
 * 
 * ObjectOutputStream
 * ObjectInputStream
 * 
 * @author B.H.Huang
 * @date 2020.06.18 16:18:25 
 *
 */
public class ObjectTest2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//д�� -->���л�
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.ser")));
		//������������+����
		oos.writeUTF("����������");
		oos.writeInt(8);
		oos.writeBoolean(false);
		oos.writeChar('a');
		//����
		oos.writeObject("˭������ζ");
		oos.writeObject(new Date());
		Employee emp = new Employee("����",400);
		oos.writeObject(emp);
		oos.flush();
		oos.close();
		//��ȡ-->�����л�
		ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("obj.ser")));
		//˳����д��һֱ
		String msg = ois.readUTF();
		int age = ois.readInt();
		boolean flag = ois.readBoolean();
		char ch = ois.readChar();
		System.out.println(flag);
		//�������ݻ�ԭ
		Object str = ois.readObject();
		Object date = ois.readObject();
		Object employee = ois.readObject();
		
		if (str instanceof String) {
			String strObj = (String)str;
			System.out.println(strObj);
		}
		if (date instanceof Date) {
			Date dateObj = (Date)date;
			System.out.println(dateObj);
		}
		if (employee instanceof Employee) {
			Employee employeeObj = (Employee)employee;
			System.out.println(employeeObj);
		}
	}
}
