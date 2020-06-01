package com.ms.mapper;

import com.ms.entity.User;

/**
 * @author ms_miao
 * @createTime 2020-06-01 10:26
 */
public interface UserMapper {

    User findByName(String username);

    User findById(Integer id);
}
