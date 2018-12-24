package com.baizhi.zjh.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chapter")
public class Chapter implements Serializable {
    @Id
    @ExcelIgnore
    private String id;
    @Excel(name = "标题",needMerge = true)
    private String title;
    @Excel(name = "大小",needMerge = true)
    private Double size;
    @Excel(name = "时长",needMerge = true,width = 20)
    private String time;
    @Excel(name = "路径",needMerge = true,width = 50)
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "上传时间",width = 20,needMerge = true,databaseFormat = "yyyyMMddHHmmss",format = "yyyy-MM-dd")
    private Date uploadDate;
    @ExcelIgnore
    private Integer albumId;
}
