package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.Chapter;
import com.baizhi.zjh.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Override
    public void increaseChapter(Chapter chapter) {
        chapterMapper.insert(chapter);
    }

    @Override
    public Chapter getOneChapter(String id) {
        return chapterMapper.selectByPrimaryKey(id);
    }

}
