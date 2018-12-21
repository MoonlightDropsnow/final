package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.AlbumDto;


public interface AlbumService {
    public AlbumDto getAlbums(Integer page, Integer rows);
}
