package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author b.h.huang
 * @time 2020.06.17 17:52:35
 *
 */
public class IOTempTest {
	public static void main(String[] args) {
		File srcFile = new File("abc.txt");
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(srcFile);
			int temp;
			while ((temp = inputStream.read()) != -1) {
				System.out.print((char)temp);
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
