package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.jar.Attributes.Name;

import javax.tools.JavaCompiler;

/**
 * 对象流
 * 1、写出后读取
 * 2、读取的顺序与写出保持一致
 * 3、不是所有的对象都可以序列化Serializable
 * 
 * ObjectOutputStream
 * ObjectInputStream
 * 
 * @author B.H.Huang
 * @date 2020.06.18 16:18:25 
 *
 */
public class ObjectTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//写出 -->序列化
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
		//操作数据类型+数据
		oos.writeUTF("编码辛酸泪");
		oos.writeInt(8);
		oos.writeBoolean(false);
		oos.writeChar('a');
		//对象
		oos.writeObject("谁解其中味");
		oos.writeObject(new Date());
		Employee emp = new Employee("马云",400);
		oos.writeObject(emp);
		oos.flush();
		byte[] datas = baos.toByteArray();
		//读取-->反序列化
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//顺序与写出一直
		String msg = ois.readUTF();
		int age = ois.readInt();
		boolean flag = ois.readBoolean();
		char ch = ois.readChar();
		System.out.println(flag);
		//对象数据还原
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

//javabean 封装数据
class Employee implements java.io.Serializable{
	private transient String name;//该数据不需要序列化
	private double salsry;
	public Employee() {
	}
	public Employee(String name, double salsry) {
		super();
		this.name = name;
		this.salsry = salsry;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalsry() {
		return salsry;
	}
	public void setSalsry(double salsry) {
		this.salsry = salsry;
	}
	
}
