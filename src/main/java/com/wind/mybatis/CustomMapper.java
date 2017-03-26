package com.wind.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface CustomMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
