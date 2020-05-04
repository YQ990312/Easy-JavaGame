package org.base64encode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class EncodeToImage {
	public static void toImage(String source) {
		FileInputStream fileinput=null;
		FileOutputStream fileoutput=null;
		try {
			byte[] imagebyte=Base64.decode(source);
			File file=new File("yangjiaqi.png");
			fileoutput=new FileOutputStream(file);
			fileoutput.write(imagebyte);
			fileoutput.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
