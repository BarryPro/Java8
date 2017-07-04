package org.demo.others;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by belong on 2017/3/28.
 */
public class Demo {
	public static void main(String[] args) {
		URL url = Demo.class.getClassLoader().getResource("str.txt");
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(url.getPath()), "utf-8"));
			String buffer = null;
			String [] path = null;
			int index = 0;
			while((buffer=reader.readLine())!=null){
//				path = buffer.replaceAll("[:、.,]", "：").split("[;；]");
				path = buffer.split("[\\s]");
				for(String s:path){
					System.out.println("\""+"com.sitech.acctmgr.inter.invoice."+s.replaceAll(".java", "")+"\",");
				}
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
