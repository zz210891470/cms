package com.trunko.cms.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.trunko.project.entity.ProCbxm;
import com.trunko.project.entity.ProZdaxm;
import com.trunko.project.entity.ProZsxm;

/**
 * ����xls��ʽ��Excel�ĵ�
 * @author gjz
 *
 */
public class Poi4Xls {

    public static void main( String[] args) throws IOException {
        Poi4Xls xlsMain = new Poi4Xls(); 
        
        
       // xlsMain.readXls("");
    }
    /**
     * ��ȡ������Ŀ��Ϣ����
     * @param path
     * @return
     * @throws IOException
     */
    public  List<ProZsxm> readXlsForZsxm(String path) throws IOException{
    	List<ProZsxm> zsxmList= new ArrayList<ProZsxm>();
     //  InputStream is = new FileInputStream("D:\\baidu\\��Ŀ����.xls");
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook( is); 
        String flag = "";
        
        
            

        Exp:
        // ѭ��������Sheet
        for(int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt( numSheet);
            if(hssfSheet == null){
                continue;
            }
            
            // ѭ����Row 
            for(int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++){
                HSSFRow hssfRow = hssfSheet.getRow( rowNum);
                if(hssfRow == null){
                    continue;
                }
                ProZsxm zsxm = new ProZsxm();
                // ѭ����Cell  
                for(int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++){
                    HSSFCell hssfCell = hssfRow.getCell( cellNum);
                    if(hssfCell == null){
                        continue;
                    }      

                    System.out.print("    " + getValue( hssfCell));
                   
					switch (cellNum) {

						case 0: {
							try { // ��Ŀ���
								zsxm.setNd(Long.valueOf(getValue(hssfCell)));
							} catch (NumberFormatException e) {
								System.out.println("��" + (rowNum+1) + "�е�"
										+ (cellNum + 1) + "�г���ӦΪ����");
								flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
										+ "�С���Ŀ��ȡ���������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
								break Exp;
							}
							break;
						}
						case 1: { //��Ŀ����
							zsxm.setMc(getValue(hssfCell));
							break;
						}
						case 2: { // ��Ŀ����
							zsxm.setDq(getValue(hssfCell));
							break;
						}
						case 3: { // ��ҵ����
							zsxm.setLb1(getValue(hssfCell));
							break;
						}
						case 4: { // ��ҵС��
							zsxm.setLb2(getValue(hssfCell));
							break;
						}
						case 5: { // �����ģ
							zsxm.setJsgm(getValue(hssfCell));
							break;
						}
						case 6: { // ��Ͷ��
							try { 
								Float ztz = FavoritesHelper.stringTofloat(getValue(hssfCell));
								zsxm.setZtz(String.valueOf(ztz));
							} catch (NumberFormatException e) {
								System.out.println("��" + (rowNum+1) + "�е�"
										+ (cellNum + 1) + "�г���ӦΪ����");
								flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
										+ "�С���Ͷ�ʡ���������ʽӦΪ���֣����޸ĺ����µ���";
								break Exp;
							}
							
							break;
						}
						case 7: { // ������ʽ
							zsxm.setHzfs(getValue(hssfCell));
							break;
						}
						case 8: { // ��ϵ��λ
							zsxm.setLxdw(getValue(hssfCell));
							break;
						}
						case 9: { // ��ϵ��
							zsxm.setLxr(getValue(hssfCell));
							break;
						}
						case 10: { // ��ϵ�绰
							zsxm.setLxdh(getValue(hssfCell));
							break;
						}
						case 11: { // ���ڹ���
							zsxm.setQqgz(getValue(hssfCell));
							break;
						}
					}
       
                }
                zsxmList.add(zsxm);
                System.out.println();
            }
            
            
        }
        
        if(!flag.equals("")){
        	zsxmList.clear();
        	ProZsxm zsxm = new ProZsxm();
        	zsxm.setNd(10000l);
        	zsxm.setMc(flag);
            zsxmList.add(zsxm);	
            return zsxmList;
        }
        
        
        return zsxmList;
    }
  
    /**
     * ��ȡ������Ŀ��Ϣ����
     * @param path
     * @return
     * @throws IOException
     */
    public  List<ProCbxm> readXlsForCbxm(String path) throws IOException{
    	List<ProCbxm> cbxmList= new ArrayList<ProCbxm>();
     //  InputStream is = new FileInputStream("D:\\baidu\\��Ŀ����.xls");
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook( is); 
        String flag = "";
    
        Exp:
        // ѭ��������Sheet
        for(int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt( numSheet);
            if(hssfSheet == null){
                continue;
            }
            
            // ѭ����Row 
            for(int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++){
                HSSFRow hssfRow = hssfSheet.getRow( rowNum);
                if(hssfRow == null){
                    continue;
                }
                ProCbxm cbxm = new ProCbxm();
                // ѭ����Cell  
                for(int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++){
                    HSSFCell hssfCell = hssfRow.getCell( cellNum);
                    if(hssfCell == null){
                        continue;
                    }      

                    System.out.print("    " + getValue( hssfCell));
                   
                    switch(cellNum){

					case 0: {
						try { // ��Ŀ���
							cbxm.setNd(Long.valueOf(getValue(hssfCell)));
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
									+ "�С���Ŀ��ȡ���������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
					case 1: { //��Ŀ����
						cbxm.setMc(getValue(hssfCell));
						break;
					}
					case 2: { // �������
						cbxm.setDq(getValue(hssfCell));
						break;
					}
					case 3: { // ����ص�
						cbxm.setJsdd(getValue(hssfCell));
						break;
					}
					case 4: { // ��ҵ����
						cbxm.setLb1(getValue(hssfCell));
						break;
					}
					case 5: { // ��ҵС��
						cbxm.setLb2(getValue(hssfCell));
						break;
					}
					case 6: { // ���������
						cbxm.setBgs(getValue(hssfCell));
						break;
					}
					case 7: { // �걨��λ
						cbxm.setSbdw(getValue(hssfCell));
						break;
					}
					case 8: { // ��ϵ��
						cbxm.setLxr(getValue(hssfCell));
						break;
					}
					case 9: { // ��ϵ�绰
						cbxm.setLxdh(getValue(hssfCell));
						break;
					}
					case 10: { // ��������
						cbxm.setDzyx(getValue(hssfCell));
						break;
					}
					case 11: { // �߻���λ
						cbxm.setChdw(getValue(hssfCell));
						break;
					}
					case 12: { // ���ʵȼ�
						cbxm.setZzdj(getValue(hssfCell));
						break;
					}
					case 13: { // ��ϵ��
						cbxm.setLxr1(getValue(hssfCell));
						break;
					}
					case 14: { // ��ϵ�绰
						cbxm.setLxdh1(getValue(hssfCell));
						break;
					}
					case 15: { // ��������
						cbxm.setDzyx1(getValue(hssfCell));
						break;
					}
					case 16: { // �а쵥λ
						cbxm.setCbdw(getValue(hssfCell));
						break;
					}
					case 17: { // ��ϵ��
						cbxm.setLxr2(getValue(hssfCell));
						break;
					}
					case 18: { // ��ϵ�绰
						cbxm.setLxdh2(getValue(hssfCell));
						break;
					}
					case 19: { // ��������
						cbxm.setDzyx2(getValue(hssfCell));
						break;
					}
					case 20: { // ������ʽ
						cbxm.setHzfs(getValue(hssfCell));
						break;
					}
					case 21: { // ��Ŀ��������������
						cbxm.setLygc(getValue(hssfCell));
						break;
					}
					case 22: { // ��Ŀ��Ͷ�ʣ���Ԫ��
						try { 
							Double ztz =Double.valueOf(getValue(hssfCell));
							cbxm.setZtz(ztz);
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
									+ "�С���Ͷ�ʡ���������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
							break Exp;
						}
						
						break;
					}
					case 23: { // ��Ŀ�����ģ������
						cbxm.setJsgm(getValue(hssfCell));
						break;
					}
					case 24: { // ��Ŀ��Ҫ��������
						cbxm.setJstj(getValue(hssfCell));
						break;
					}
					case 25: { // ��Ŀ����Ч�����
						cbxm.setXyfx(getValue(hssfCell));
						break;
					}
					case 26: { // ��Ҫ��������ָ��
						cbxm.setJsjjzb(getValue(hssfCell));
						break;
					}
					case 27: { // ��Ŀǰ���ƽ�״��
						cbxm.setTjzk(getValue(hssfCell));
						break;
					}
					case 28: { // ����ʱ��
						String bssj = getValue(hssfCell);
						try {
							cbxm.setBssj(FavoritesHelper.stringToDate(bssj));
						} catch (ParseException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
									+ "�С�����ʱ�䡿������ʱ���ʽӦΪ��2014-01-01�����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
				}
       
                }
                cbxm.setZt("�����");
                cbxm.setShyj("ͬ��");
                cbxmList.add(cbxm);
            }
            
            
        }
        if(!flag.equals("")){
        	cbxmList.clear();
        	ProCbxm cbxm = new ProCbxm();
        	cbxm.setNd(10000l);
        	cbxm.setMc(flag);
        	cbxmList.add(cbxm);	
            return cbxmList;
        }
        return cbxmList;
    }
  
    /**
     * ��ȡ�ش���Ŀ��Ϣ����
     * @param path
     * @return
     * @throws IOException
     */
    public  List<ProZdaxm> readXlsForZdaxm(String path) throws IOException{
    	List<ProZdaxm> zdaxmList= new ArrayList<ProZdaxm>();
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook( is); 
        String flag = "";
    
        Exp:
        // ѭ��������Sheet
        for(int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt( numSheet);
            if(hssfSheet == null){
                continue;
            }
            
            // ѭ����Row 
            for(int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++){
                HSSFRow hssfRow = hssfSheet.getRow( rowNum);
                if(hssfRow == null){
                    continue;
                }
                ProZdaxm zdaxm = new ProZdaxm();
                // ѭ����Cell  
                for(int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++){
                    HSSFCell hssfCell = hssfRow.getCell( cellNum);
                    if(hssfCell == null){
                        continue;
                    }      

                    System.out.print("    " + getValue( hssfCell));
                   
                    switch(cellNum){

					case 0: {
						try { // ��Ŀ���
							zdaxm.setNd(Long.valueOf(getValue(hssfCell)));
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
									+ "�С���Ŀ��ȡ���������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
					case 1: { //��Ŀ����
						zdaxm.setMc(getValue(hssfCell));
						break;
					}
					case 2: { // �������
						zdaxm.setDq(getValue(hssfCell));
						break;
					}
					case 3: { // ����ص�
						zdaxm.setJsdd(getValue(hssfCell));
						break;
					}
					case 4: { // ��ҵ����
						zdaxm.setLb1(getValue(hssfCell));
						break;
					}
					case 5: { // ��ҵС��
						zdaxm.setLb2(getValue(hssfCell));
						break;
					}
					case 6: { // �����ģ
						zdaxm.setJsgm(getValue(hssfCell));
						break;
					}
					case 7: { // ��Ͷ��
						try { 
							Long ztz = FavoritesHelper.stringTolong(getValue(hssfCell));
							zdaxm.setZtz(ztz);
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
									+ "�С���Ͷ�ʡ���������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
					case 8: { // �����ĺ�
						zdaxm.setBawh(getValue(hssfCell));
						break;
					}
					case 9: { // �������ޣ��ԣ�
						try { 
							int jsnx1 = FavoritesHelper.stringToint(getValue(hssfCell));
							zdaxm.setJsnx1(jsnx1);
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
									+ "�С��������ޣ��ԣ�����������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
					case 10: { // �������ޣ�����
						try { 
							int jsnx2 = FavoritesHelper.stringToint(getValue(hssfCell));
							zdaxm.setJsnx2(jsnx2);
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
									+ "�С��������ޣ���������������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
					case 11: { // �ƻ�Ͷ��
						try { 
							Long jhtz = FavoritesHelper.stringTolong(getValue(hssfCell));
							zdaxm.setJhtz(jhtz);
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
									+ "�С��ƻ�Ͷ�ʡ���������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
					case 12: { // ����Ŀ��
						zdaxm.setJdmb(getValue(hssfCell));
						break;
					}
					case 13: { // �������
						try { 
							Long kgnf = FavoritesHelper.stringTolong(getValue(hssfCell));
							String kgn = String.valueOf(kgnf);
							zdaxm.setKgn(kgn);
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
									+ "�С�������ݡ���������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
					case 14: { // �����·�
						try { 
							Long kgyf = FavoritesHelper.stringTolong(getValue(hssfCell));
							String kgy = String.valueOf(kgyf);
							zdaxm.setKgy(kgy);
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
									+ "�С������·ݡ���������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
					case 15: { // �������
						try { 
							Long jgnf = FavoritesHelper.stringTolong(getValue(hssfCell));
							String jgn = String.valueOf(jgnf);
							zdaxm.setJgn(jgn);
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
									+ "�С�������ݡ���������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
					case 16: { // �����·�
						try { 
							Long jgyf = FavoritesHelper.stringTolong(getValue(hssfCell));
							String jgy = String.valueOf(jgyf);
							zdaxm.setJgy(jgy);
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
									+ "�С������·ݡ���������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
					case 17: { // �õ����
						try { 
							float yd = FavoritesHelper.stringTofloat(getValue(hssfCell));
							zdaxm.setYd(yd);
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
							+ "�С��õ��������������ʽӦΪ���֣����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
					case 18: { // �������
						try { 
							float yl = FavoritesHelper.stringTofloat(getValue(hssfCell));
							zdaxm.setLd(yl);
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
							+ "�С������������������ʽӦΪ���֣����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
					case 19: { // �ۼ����Ͷ��
						try {
							Long wctz = FavoritesHelper.stringTolong(getValue(hssfCell));
							zdaxm.setWctz(wctz);
						} catch (NumberFormatException e) {
							System.out.println("��" + (rowNum+1) + "�е�"
									+ (cellNum + 1) + "�г���ӦΪ����");
							flag = "��" + (rowNum+1) + "�е�" + (cellNum + 1)
							+ "�С��ۼ����Ͷ�ʡ���������ʽӦΪ������������С�������ĸ�����޸ĺ����µ���";
							break Exp;
						}
						break;
					}
				}
       
                }
                zdaxm.setZt("�����");
                zdaxm.setShyj("ͬ��");
                zdaxmList.add(zdaxm);
            }
            
            
        }
        if(!flag.equals("")){
        	zdaxmList.clear();
        	ProZdaxm zdaxm = new ProZdaxm();
        	zdaxm.setNd(10000l);
        	zdaxm.setMc(flag);
        	zdaxmList.add(zdaxm);	
            return zdaxmList;
        }
        return zdaxmList;
    }
    
    /**
    * ��ȡ��Ԫ���ڵ�ֵ�������ͣ���ֵ�ͣ� �ַ���
    * @param hssfCell
    * @return
    */
    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell){
    	
        if(hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN){
        	
            return String.valueOf( hssfCell.getBooleanCellValue());
        }else if(hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC){
        	
            return String.valueOf( hssfCell.getNumericCellValue());
        }else{
        	
            return String.valueOf( hssfCell.getStringCellValue());
        }
    }
  
}

