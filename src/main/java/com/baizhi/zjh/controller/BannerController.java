package com.baizhi.zjh.controller;

import com.baizhi.zjh.entity.Banner;
import com.baizhi.zjh.entity.BannerDto;
import com.baizhi.zjh.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("allBanners")
    public List<Banner> allBanners() {
        return bannerService.getAllBanners();
    }
    @RequestMapping("allBannersThisPage")
    public BannerDto allBannersThisPage(Integer page, Integer rows) {
        return bannerService.getBannersByPage(page, rows);
    }
    @RequestMapping("editBanner")
    public void editBanner(Banner banner){
        bannerService.changeBanner(banner);
    }
    @RequestMapping("removeBanner")
    public void removeBanner(Integer id){
        bannerService.deleteBanner(id);
    }
    @RequestMapping(value = "addBanner",method = RequestMethod.POST)
    public void addBanner(Banner banner, @RequestParam("file") MultipartFile file)throws IOException {
        File file1 = new File(System.getProperty("user.dir")+"/src/main/webapp/images/shouye/"+file.getOriginalFilename());
        //System.out.println(file1);
        String path = "images/shouye/"+file.getOriginalFilename();
       // System.out.println(path);
        banner.setImgPath(path);
        banner.setPubDate(new Date());
        banner.setStatus(0);
        bannerService.increaseBanner(banner);
        file.transferTo(file1);
    }
}
