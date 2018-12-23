package com.baizhi.zjh.controller;

import com.baizhi.zjh.entity.Chapter;
import com.baizhi.zjh.service.ChapterService;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import it.sauronsoftware.jave.Encoder;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private Environment env;
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("addChapter")
    public @ResponseBody
    void addChapter(Integer albumId, Chapter chapter, @RequestParam("file") MultipartFile file) throws IOException {
        File file1 = new File(System.getProperty("user.dir") + "/src/main/webapp/audio/" + new Date().getTime() + file.getOriginalFilename());
        String path = "audio/" + new Date().getTime() + file.getOriginalFilename();
        Double size = file.getSize() / 1024 / 1024 + 0.0;
        chapter.setId(UUID.randomUUID().toString().replace("-", ""));
        chapter.setSize(size);
        chapter.setUploadDate(new Date());
        chapter.setUrl(path);
        chapter.setAlbumId(albumId);
        //文件时长1
        //获取上传文件信息并和指定文件信息比较
        file.transferTo(file1);
        Encoder encoder = new Encoder();
        MultimediaInfo m = null;
        try {
            m = encoder.getInfo(file1);
        } catch (EncoderException e) {
        }
        long duration = m.getDuration();
        long a = duration / 1000;
        long minute = a/60;
        long second = a-minute*60;
        String time = minute+"分"+second+"秒";
        chapter.setTime(time);
        chapterService.increaseChapter(chapter);
        /*String property = env.getProperty("spring.http.multipart.max-file-size");
        String numbers = UploadUtils.getNumbers(property);
        long i = Long.parseLong(numbers);
        if (a > i * 1000 * 1000) {

        }*/
        //
        //文件时长2
     /*   CommonsMultipartFile cf = (CommonsMultipartFile) file;
        DiskFileItem fi = (DiskFileItem)cf.getFileItem();
        File f2 = fi.getStoreLocation();
        Encoder encoder = new Encoder();
        try {
            MultimediaInfo m = encoder.getInfo(f2);
            long ls = m.getDuration();
            System.out.println(ls / 1000);
        } catch (Exception e) {

        }*/
        //3
       /*     Encoder encoder = new Encoder();
            long ls = 0;
            try {
                MultimediaInfo m = encoder.getInfo((File) file);
                ls = m.getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println( ls / 60000 + "分" + ls / 1000 + "秒！");*/

    }
    @RequestMapping("downloadChapter")
    public void download( String chapterId, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = chapterService.getOneChapter(chapterId).getUrl();
        String path = session.getServletContext().getRealPath("/");
        System.out.println(path);
        String fileUrl = path+ File.separatorChar+url;
        File file = new File(fileUrl);
        //解决文件名中的空格( )变加号(+)的问题
        if(request.getHeader("User-Agent").toUpperCase().indexOf("MSIE")>0){
            url = URLEncoder.encode(url, "UTF-8");
        }else{
            url = new String((url).getBytes("UTF-8"),"ISO8859-1");
        }
        response.setHeader("content-disposition", "attachment;filename=" + url);
        FileInputStream in = new FileInputStream(fileUrl);
        OutputStream outputStream = response.getOutputStream();
        byte buffer[] = new byte[1024];         //创建缓冲区
        int len = 0;
        while ((len = in.read(buffer))>0){
            outputStream.write(buffer, 0, len);
        }
        in.close();
        outputStream.close();
    }

}
