package com.zhanglei.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import com.sun.imageio.plugins.common.InputStreamAdapter;

/** 
* @ClassName: StreamUtil 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月11日 下午3:06:49 
*/
public class StreamUtil {

	/*
	* 方法1：批量关闭流，参数能传入无限个。(10分)
	* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	*/
	public static void closeAll(InputStream... fileInputStream){
		for (InputStream inputStream : fileInputStream) {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*
	* 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	*/
	/**
	 * @param src
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static String readTextFile(File src) throws FileNotFoundException{
		FileInputStream fip = new FileInputStream(src);
		InputStreamReader inputStreamReader = new InputStreamReader(fip);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str = "";
		try {
			while((str = bufferedReader.readLine()).length()!=0) {
				str=str+bufferedReader.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			closeAll();
		}
		
		return str;
	}

	/*
	* 方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	*/
	public static String readTextFile(File txtFile,InputStreamReader src){
	
		
		String str = "";
		try {
			FileInputStream fip = new FileInputStream(txtFile);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fip));
			while((str = bufferedReader.readLine()).length()!=0) {
				str=str+bufferedReader.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeAll();
		return str;
	}

	
}
