package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.Banner;
import com.baizhi.zjh.entity.BannerDto;
import com.baizhi.zjh.mapper.BannerMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Banner> getAllBanners() {
        return bannerMapper.selectAll();
    }

    @Override
    public BannerDto getBannersByPage(int page, int rows) {
        BannerDto bannerDto = new BannerDto();
        RowBounds rowBounds = new RowBounds((page-1)*rows,rows);
        List<Banner> banners = bannerMapper.selectByRowBounds(new Banner(),rowBounds);
        int total = bannerMapper.selectCount(new Banner());
        bannerDto.setTotal(total);
        bannerDto.setRows(banners);
        return bannerDto;
    }

    @Override
    public void changeBanner(Banner banner) {
        bannerMapper.updateByPrimaryKeySelective(banner);
    }

    @Override
    public void deleteBanner(Integer id) {
        bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void increaseBanner(Banner banner) {
        bannerMapper.insert(banner);
    }

}
