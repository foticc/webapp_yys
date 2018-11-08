package fun.have.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(name = "FileTest",urlPatterns = {"/file"})
public class FileTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serverPath = "C:\\Users\\lenovo\\Desktop\\test.jpg";
        File file = new File(serverPath);
        boolean isFile = ServletFileUpload.isMultipartContent(request);
        // 是否是带有文件  enctype="multipart/form-data"
        if (isFile){
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            fileUpload.setFileSizeMax(2*1024*1024);
            // 总大小
            fileUpload.setSizeMax(10*1024*1024);
            List<FileItem> listFile = null;
            try {
                listFile = fileUpload.parseRequest(request);

                for (FileItem item:listFile) {
                    System.out.println(item.getSize());
                    System.out.println(item.getName());
                    // 非普通表单
                    if (!item.isFormField()){
                        FileOutputStream fos = new FileOutputStream(file);
                        InputStream fis = item.getInputStream();
                        byte[] buffer = new byte[1024];
                        int len = 0;
                        while ((len = fis.read(buffer))!=-1){
                            fos.write(buffer,0,len);
                        }
                        fos.flush();
                        fos.close();
                        fis.close();

                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
