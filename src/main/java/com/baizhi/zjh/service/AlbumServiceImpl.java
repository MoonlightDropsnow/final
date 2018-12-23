package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.Album;
import com.baizhi.zjh.entity.AlbumDto;
import com.baizhi.zjh.entity.Chapter;
import com.baizhi.zjh.mapper.AlbumMapper;
import com.baizhi.zjh.mapper.ChapterMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    private AlbumMapper albumMapper;
    @Autowired
    private ChapterMapper chapterMapper;
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public AlbumDto getAlbums(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Album> albums = albumMapper.selectAll();
        for (Album album:albums) {
            Chapter chapter = new Chapter();
            chapter.setAlbumId(album.getId());
            List<Chapter> chapters = chapterMapper.select(chapter);
            album.setChildren(chapters);
        }
        Integer total = albumMapper.selectCount(new Album());
        AlbumDto albumDto = new AlbumDto(total,albums);
        return albumDto;
    }

    @Override
    public Album getOneAlbum(Integer id) {
        return albumMapper.selectByPrimaryKey(id);
    }

    @Override
    public void increaseAlbum(Album album) {
        albumMapper.insert(album);
    }
}
