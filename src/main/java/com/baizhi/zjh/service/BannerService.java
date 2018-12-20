package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.Banner;
import com.baizhi.zjh.entity.BannerDto;

import java.util.List;

public interface BannerService {
    public List<Banner> getAllBanners();
    public BannerDto getBannersByPage(int page, int rows);
    public void changeBanner(Banner banner);
    public void deleteBanner(Integer id);
    public void increaseBanner(Banner banner);
}
