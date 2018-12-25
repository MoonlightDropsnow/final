package com.baizhi.zjh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMsg implements Serializable {
    private String name;
    private Integer value;
}
