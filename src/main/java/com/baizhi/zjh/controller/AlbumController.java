package com.baizhi.zjh.controller;

import com.baizhi.zjh.entity.AlbumDto;
import com.baizhi.zjh.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("allAlbumsThisPage")
    public AlbumDto allAlbumsThisPage(Integer page,Integer rows){
        return albumService.getAlbums(page,rows);
    }
}
