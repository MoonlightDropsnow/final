package com.baizhi.zjh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Menu {
    @Id
    private Integer id;
    private String title;
    private String iconCls;
    private String url;
    private Integer parentId;
}
