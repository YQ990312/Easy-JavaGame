package WeChatHeader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.Parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Logo.WeChatLogo;

public class HeaderChange extends ActionSupport{
	private final int BUFFER_SIZE=100*100;
	private File file;
	private String savePath="/images";
	private String fileFileName;
	private String fileContentType;
	
	private String LogoPath="";
	private String sourcePath="";
	private String newLogoPath="";
	private String newLogoName="";
	
	
	@Override
	public String execute(){
		System.out.println("接受的文件"+file);
		File save=null;
		String path="C:\\Users\\Administrator\\Desktop\\imageUpload"+"\\"+this.getFileFileName();
		String pathdirs="C:\\Users\\Administrator\\Desktop\\imageUpload";
		//newLogoPath="http://39.101.193.149:8080/images/"+newLogoName;
		System.out.println("保存文件的地址"+path);
		try {
			save=new File(path);
			File pathfile=new File(pathdirs);
			if(!pathfile.exists()) {
				if(pathfile.mkdir()) {
					System.out.println("创建文件成功");
				}else {
					System.out.println("创建文件失败");
				}
			}else {
				System.out.println("文件以存在");
			}
		}catch(Exception e) {
			System.out.println("创建接收文件的文件夹");
		}
		if(save==null) {
			return "REUPLOAD";
		}
		if(CopyFile(file,save)) {
			System.out.println("图像保存成功");
			sourcePath=path;
			LogoPath="C:\\Users\\Administrator\\Desktop\\imageUpload\\logo2.jpg";
			newLogoPath="C:\\Users\\Administrator\\Desktop\\images\\";
			newLogoName=UUID.randomUUID().toString();
			WeChatLogo.addLogo(sourcePath, LogoPath, newLogoPath, newLogoName);
			ActionContext.getContext().getSession().put("WeChat", "http://39.101.193.149:8080/images/"+newLogoName+".jpg");
			System.out.println("网络地址"+"http://39.101.193.149:8080/images/"+newLogoName+".jpg");
			return "SUCCESS";
		}
		else
			return "REUPLOAD";
	}
	
	
	private boolean CopyFile(File inputFile,File outputFile) {
		//创建最基本的输入输出流实例
		InputStream inputstream=null;
		OutputStream outputstream=null;
		try {
			//输入流
			inputstream=new BufferedInputStream(new FileInputStream(inputFile),BUFFER_SIZE);
			//输出流
			outputstream=new BufferedOutputStream(new FileOutputStream(outputFile),BUFFER_SIZE);
			
			byte [] buffer=new byte[BUFFER_SIZE];
			int bufferlong;
			while((bufferlong=inputstream.read(buffer))>0) {
				outputstream.write(buffer,0,bufferlong);
			}
			inputstream.close();
			outputstream.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getSavePath() {
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	public String getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}


	public String getFileContentType() {
		return fileContentType;
	}


	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}


	public int getBUFFER_SIZE() {
		return BUFFER_SIZE;
	}

	
	
}
