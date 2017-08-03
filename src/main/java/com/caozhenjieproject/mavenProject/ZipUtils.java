package com.caozhenjieproject.mavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;

public class ZipUtils {

    private ZipUtils(){};  

   /**
     * 创建ZIP文件
     * @param sourcePath 文件或文件夹路径
     * @param zipPath 生成的zip文件存在路径（包括文件名）
     */
    public static Boolean createZip(String sourcePath, String zipPath) {
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipPath);
            zos = new ZipOutputStream(fos);
            writeZip(new File(sourcePath), "", zos);
            return true;
        } catch (FileNotFoundException e) {
             System.out.println("创建ZIP文件失败FileNotFoundException1111111111");
             return false;
        } finally {
            try {
                if (zos != null) {
                    zos.close();
                }
            } catch (IOException e) {
                 System.out.println("创建ZIP文件失败IOException1111111");
                 return false;
            }

        }
    }

    private static void writeZip(File file, String parentPath, ZipOutputStream zos) {
    	
    	
        if(file.exists()){
            if(file.isDirectory()){//处理文件夹
                parentPath+=file.getName()+File.separator;
                File [] files=file.listFiles();
                for(File f:files){
                	if(!"suiteinfo.zip".equals(f.getName())){
                		 writeZip(f, parentPath, zos);
                	}
                   
                }
            }else{
                FileInputStream fis=null;
                try {
                    fis=new FileInputStream(file);
                    ZipEntry ze = new ZipEntry(parentPath + file.getName());
                    zos.putNextEntry(ze);
                    byte [] content=new byte[1024];
                    int len;
                    while((len=fis.read(content))!=-1){
                        zos.write(content,0,len);
                        zos.flush();
                    }

                } catch (FileNotFoundException e) {
                     System.out.println("创建ZIP文件失败 FileNotFoundException");
                } catch (IOException e) {
                     System.out.println("创建ZIP文件失败IOException");
                }finally{
                    try {
                        if(fis!=null){
                            fis.close();
                        }
                    }catch(IOException e){
                         System.out.println("创建ZIP文件失败finallyIOException");
                    }
                }
            }
        }
    }    
//    public static void main(String[] args) {
//        System.out.print(ZipUtils.createZip("C:\\pv_suite_install\\downLoadingDIR", "C:\\pv_suite_install\\downLoadingDIR\\suiteinfo.zip"));
//
//    }
}