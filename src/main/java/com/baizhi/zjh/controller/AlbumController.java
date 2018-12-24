package com.baizhi.zjh.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.zjh.entity.Album;
import com.baizhi.zjh.entity.AlbumDto;
import com.baizhi.zjh.entity.Chapter;
import com.baizhi.zjh.mapper.ChapterMapper;
import com.baizhi.zjh.service.AlbumService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private Environment env;

    @RequestMapping("allAlbumsThisPage")
    @ResponseBody
    public AlbumDto allAlbumsThisPage(Integer page, Integer rows) {
        return albumService.getAlbums(page, rows);
    }

    @RequestMapping("oneAlbum")
    @ResponseBody
    public Album oneAlbum(Integer id) {
        return albumService.getOneAlbum(id);
    }

    @RequestMapping("addAlbum")
    @ResponseBody
    public void addAlbum(Album album, @RequestParam("file") MultipartFile file) throws IOException {
        File file1 = new File(System.getProperty("user.dir") + "/src/main/webapp/images/audioCollection/" + new Date().getTime() + file.getOriginalFilename());
        String path = "images/audioCollection/" + new Date().getTime() + file.getOriginalFilename();
        album.setCoverImg(path);
        album.setCount(0);
        album.setScore(0);
        album.setPubDate(new Date());
        albumService.increaseAlbum(album);
        file.transferTo(file1);
    }

    @RequestMapping("exportAlbum")
    public void exportAlbum(HttpServletResponse response) {
        List<Album> albums = albumService.getAllAlbums();
        for (Album album : albums) {
            String realPath = env.getProperty("file.real.path");
            album.setCoverImg(realPath + File.separatorChar + album.getCoverImg());
            System.out.println(album.getCoverImg());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑", "专辑"), Album.class, albums);
        try {
            String encode = URLEncoder.encode("user.xls", "UTF-8");
            response.setHeader("content-disposition", "attachment;filename=" + encode);
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
