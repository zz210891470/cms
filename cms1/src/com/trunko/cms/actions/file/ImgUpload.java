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
 * �ϴ�������
 * @author gjz
 *
 */
public class ImgUpload  extends ActionSupport {  
	 
    private File file;  //ע��file�����name��Ӧ
    private String fileFileName;  //file+FileNameΪ�̶�д��,����ȡ����
    private String fileContentType;  //file+ContentTypeΪ�̶�д��
  
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
     * �ļ�����
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
	
	//ajax �ϴ�
	public void xlsupload() throws Exception {  
		
		FileInputStream fis = new FileInputStream(file);
		//����һ���ڵ�ǰ����webroot�ļ����µ���Ӧ·�����ļ���
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		System.out.println(path);
		HttpServletRequest request= ServletActionContext.getRequest();
//		String downloadpath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload"+thefileFileName;   

		//����Ҫ������ļ�
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
        			message = "[\"error\",\""+convert("���ݿ������������µ��룡")+"\"]";
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
        			message = "[\"error\",\""+convert("���ݿ������������µ��룡")+"\"]";
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
        			message = "[\"error\",\""+convert("���ݿ������������µ��룡")+"\"]";
        		}
        	}
        	
        }

		HttpServletResponse response= ServletActionContext.getResponse();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");  
		out.write(message);
		out.close();
	}
	
	
    
	//ajax �ϴ�
	public void fileupload() throws Exception {  
		
		FileInputStream fis = new FileInputStream(file);
		//����һ���ڵ�ǰ����webroot�ļ����µ���Ӧ·�����ļ���
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		HttpServletRequest request= ServletActionContext.getRequest();
//		String downloadpath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload"+thefileFileName;   
		System.out.println(path);
		//����Ҫ������ļ�
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
            message = "[\"fail\",\""+convert("�ļ��ϴ������������ϴ�!")+"\"]";  
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
	* ���ַ���ת��unicode
	* @param str ��ת�ַ���
	* @return unicode�ַ���
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
		j = (c >>>8); //ȡ����8λ
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
		sb.append("0");
		sb.append(tmp);
		j = (c & 0xFF); //ȡ����8λ
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
