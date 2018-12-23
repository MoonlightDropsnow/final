package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.Album;
import com.baizhi.zjh.entity.AlbumDto;


public interface AlbumService {
    public AlbumDto getAlbums(Integer page, Integer rows);
    public Album getOneAlbum(Integer id);
    public void increaseAlbum(Album album);
}
