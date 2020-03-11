package com.zhanglei.utils;
/** 
* @ClassName: FileUtil 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月11日 下午3:01:11 
*/
public class FileUtil {

	/*
	* 方法1：给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”(10分)
	*/
	public static String getExtendName(String fileName){
	
		String[] split = fileName.split("\\.");
		String str = "."+split[1];
		return str;
	}

	public static void main(String[] args) {
		String extendName = getExtendName("qwe.jsp");
		System.out.println(extendName);
		
	}
	
}
