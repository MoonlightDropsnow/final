package com.baizhi.zjh.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album")
@ExcelTarget(value = "ID")
public class Album implements Serializable {
    //1
    @Id
    @Excel(name = "ID",needMerge = true)
    private Integer id;
    @Excel(name = "封面",needMerge=true,type = 2,width = 40,height = 40)
    private String coverImg;
    @Excel(name = "名称",needMerge=true)
    private String title;
    @Excel(name = "评分",needMerge=true)
    private Integer score;
    @Excel(name = "作者",needMerge=true)
    private String author;
    @Excel(name = "播音",needMerge=true)
    private String announcer;
    @Excel(name = "集数",needMerge=true)
    private Integer count;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Excel(name = "时间",needMerge=true,width = 20,databaseFormat = "yyyyMMddHHmmss",format = "yyyy-MM-dd")
    private Date pubDate;
    @Excel(name = "简介",needMerge=true)
    private String brief;
    @ExcelCollection(name = "章节")
    private List<Chapter> children;
}
