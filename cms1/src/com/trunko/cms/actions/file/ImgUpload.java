package com.trunko.cms.actions.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.trunko.cms.util.Escape;
import com.trunko.cms.util.Poi4Xls;
import com.trunko.project.dao.CbxmDao;
import com.trunko.project.dao.ZdaxmDao;
import com.trunko.project.dao.ZsxmDao;
import com.trunko.project.entity.ProCbxm;
import com.trunko.project.entity.ProZdaxm;
import com.trunko.project.entity.ProZsxm;


/**
 * 上传控制类
 * @author gjz
 *
 */
public class ImgUpload  extends ActionSupport {  
	 
    private File file;  //注意file名与表单name对应
    private String fileFileName;  //file+FileName为固定写法,否则取不到
    private String fileContentType;  //file+ContentType为固定写法
  
    private String message = "[\"success\"]";  

    private String downloadname;
    private String ajaxfilename;

    private String lb;
    private String signal;
    
	public String getSignal() {
		return signal;
	}


	public void setSignal(String signal) {
		this.signal = signal;
	}


	public void setDownloadname(String downloadname) {

		this.downloadname = Escape.unescape(downloadname);
	}


	public String getDownloadname() {
		   String fileName=Escape.unescape(downloadname);
		   String downFileName = fileName;
		   try {
		    downFileName = new String(downFileName.getBytes(), "ISO8859-1");
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		   return downFileName;
	}

	
	/**
     * 文件下载
     * @return
     * @throws Exception
     */
	public String download(){
		return SUCCESS;
	}
	
	public InputStream getDownloadfile() throws Exception{
		InputStream in=ServletActionContext.getServletContext().getResourceAsStream("/upload/"+downloadname);
	
		return in;
	}
	
	//ajax 上传
	public void xlsupload() throws Exception {  
		
		FileInputStream fis = new FileInputStream(file);
		//创建一个在当前工程webroot文件夹下的相应路径的文件夹
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		System.out.println(path);
		HttpServletRequest request= ServletActionContext.getRequest();
//		String downloadpath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload"+thefileFileName;   

		//设置要保存的文件
		String fixname =fileFileName.substring(fileFileName.indexOf("."),fileFileName.length());
		fileFileName=Escape.unescape(ajaxfilename)+fixname;
		
		File toFile = new File(path, fileFileName);
		System.out.println(fileFileName);
	
		if(!toFile.exists()){
			toFile.createNewFile();
		}

		FileOutputStream fos = new FileOutputStream(toFile);
		
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] buff = new byte[128];
		int count = -1;

		while ((count = bis.read(buff)) != -1) {
			fos.write(buff, 0, count);
		}

		bis.close();
		
		fis.close();
		fos.close();

        FileInputStream size = new FileInputStream(file);
        String filesize=size.available()/1000+"kb";
        System.out.println(filesize);
        size.close();
        
        Poi4Xls poi = new Poi4Xls();
        
        if(lb.equals("zsxm")){     
        	List<ProZsxm> pZsxm= poi.readXlsForZsxm(path+"\\"+fileFileName);
        	if(pZsxm.get(0).getNd()==10000l){
        		message = "[\"error\",\""+convert(pZsxm.get(0).getMc())+"\"]";;
        	}else{
        		if(ZsxmDao.xlsImport(pZsxm)){
        			message = "[\"success\"]";
        		}else{
        			message = "[\"error\",\""+convert("数据库存入错误，请重新导入！")+"\"]";
        		}
        	}
        	
	    /*    if(ZsxmDao.xlsImport(poi.readXlsForZsxm(path+"\\"+fileFileName))){
	        	message = "[\"success\"]";
	        }*/  
        }else if(lb.equals("cbxm")){     
        	List<ProCbxm> pCbxm= poi.readXlsForCbxm(path+"\\"+fileFileName);
        	if(pCbxm.get(0).getNd()==10000l){
        		message = "[\"error\",\""+convert(pCbxm.get(0).getMc())+"\"]";;
        	}else{
        		if(CbxmDao.xlsImport(pCbxm)){
        			message = "[\"success\"]";
        		}else{
        			message = "[\"error\",\""+convert("数据库存入错误，请重新导入！")+"\"]";
        		}
        	}
        	
        }else if(lb.equals("zdaxm")){     
        	List<ProZdaxm> pZdaxm= poi.readXlsForZdaxm(path+"\\"+fileFileName);
        	if(pZdaxm.get(0).getNd()==10000l){
        		message = "[\"error\",\""+convert(pZdaxm.get(0).getMc())+"\"]";;
        	}else{
        		if(ZdaxmDao.xlsImport(pZdaxm)){
        			message = "[\"success\"]";
        		}else{
        			message = "[\"error\",\""+convert("数据库存入错误，请重新导入！")+"\"]";
        		}
        	}
        	
        }

		HttpServletResponse response= ServletActionContext.getResponse();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");  
		out.write(message);
		out.close();
	}
	
	
    
	//ajax 上传
	public void fileupload() throws Exception {  
		
		FileInputStream fis = new FileInputStream(file);
		//创建一个在当前工程webroot文件夹下的相应路径的文件夹
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		HttpServletRequest request= ServletActionContext.getRequest();
//		String downloadpath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload"+thefileFileName;   
		System.out.println(path);
		//设置要保存的文件
		String fixname =fileFileName.substring(fileFileName.indexOf("."),fileFileName.length());
		fileFileName=Escape.unescape(ajaxfilename)+fixname;
		fileFileName=fileFileName.substring(fileFileName.lastIndexOf("\\")+1,fileFileName.length());
		File toFile = new File(path, fileFileName);
		System.out.println(fileFileName);
	
		if(!toFile.exists()){
			toFile.createNewFile();
		}

		FileOutputStream fos = new FileOutputStream(toFile);
		
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] buff = new byte[128];
		int count = -1;

		while ((count = bis.read(buff)) != -1) {
			fos.write(buff, 0, count);
		}

		bis.close();
		
		fis.close();
		fos.close();

        FileInputStream size = new FileInputStream(file);
        String filesize=size.available()/1000+"kb";
        System.out.println(filesize);
        size.close();
		
        message = "[\"success\",\""+convert(fileFileName)+"\",\""+filesize+"\"]";
		HttpServletResponse response= ServletActionContext.getResponse();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");  
		out.write(message);
		out.close();
	}
	
	
    public void upload() throws Exception { 

		HttpServletRequest request= ServletActionContext.getRequest();
		HttpServletResponse response= ServletActionContext.getResponse();
		
		String imgpath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload/";
		
		
    	String path = ServletActionContext.getServletContext().getRealPath("/upload");

        
        Calendar cc=Calendar.getInstance();
       
        String monthpath=cc.get(Calendar.YEAR)+""+(cc.get(Calendar.MONTH)+1)+"/";
    	try {  
            File f = this.getFile();  

            FileInputStream inputStream = new FileInputStream(f);  
            File fpath=new File(path+"/"+monthpath);
            if(!fpath.exists()){		    	
		    	fpath.mkdirs();    	
		    }
            System.out.println("geshi:"+fileFileName.substring(fileFileName.lastIndexOf("."),fileFileName.length()));
            java.util.Date dd=new java.util.Date();
            String realFileName=dd.getTime()+fileFileName.substring(fileFileName.lastIndexOf("."),fileFileName.length());
            
            FileOutputStream outputStream = new FileOutputStream(path + "/"+monthpath+realFileName);  
            byte[] buf = new byte[10240];  
            int length = 0;  
            while ((length = inputStream.read(buf)) != -1) {  
                outputStream.write(buf, 0, length);  
            }  
            System.out.println(inputStream.available());
            inputStream.close();  
            outputStream.flush();  
            
            FileInputStream fis = new FileInputStream(f) ;
            System.out.println(fis.available()/1000+"kb");
            fis.close();
      //      System.err.println(ServletActionContext.getServletContext().getResource("/upload").toString());
            message = "[\"success\",\""+"upload/"+monthpath+realFileName+"\"]";
        } catch (Exception e) {  
            e.printStackTrace();  
            message = "[\"fail\",\""+convert("文件上传出错，请重新上传!")+"\"]";  
        }  
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");  
		out.write(message);
		out.close();	
		
    	
    	
    }

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}  

	
	/**
	* 将字符串转成unicode
	* @param str 待转字符串
	* @return unicode字符串
	*/ 
	public String convert(String str)
	{
		str = (str == null ? "" : str);
		String tmp;
		StringBuffer sb = new StringBuffer(1000);
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++)
		{
		c = str.charAt(i);
		sb.append("\\u");
		j = (c >>>8); //取出高8位
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
		sb.append("0");
		sb.append(tmp);
		j = (c & 0xFF); //取出低8位
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
		sb.append("0");
		sb.append(tmp);
	
		}
		return (new String(sb));
	}


	public void setAjaxfilename(String ajaxfilename) {
		this.ajaxfilename = ajaxfilename;
	}


	public String getAjaxfilename() {
		return ajaxfilename;
	}


	public void setLb(String lb) {
		this.lb = lb;
	}


	public String getLb() {
		return lb;
	}


}
