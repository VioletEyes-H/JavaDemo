package com.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlGetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://www.baidu.com");
			InputStream in = url.openStream();
			InputStreamReader read = new InputStreamReader(in,"UTF-8");
			BufferedReader get = new BufferedReader(read);
			String data = get.readLine();
			while (data != null) {
				System.out.println(data);
				data = get.readLine();
			}
			in.close();
			read.close();
			get.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
