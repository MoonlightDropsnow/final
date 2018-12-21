package com.baizhi.zjh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "guru")
public class Guru implements Serializable {
    @Id
    private Integer id;
    private String dharma;
    private String headPic;
    private Integer status;
}
