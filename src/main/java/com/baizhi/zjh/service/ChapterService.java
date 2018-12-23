package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.Chapter;

public interface ChapterService {
    public void increaseChapter(Chapter chapter);
    public Chapter getOneChapter(String id);
}
