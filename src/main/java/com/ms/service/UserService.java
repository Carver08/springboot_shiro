package com.ms.service;

import com.ms.entity.User;

/**
 * @author ms_miao
 * @createTime 2020-06-01 10:30
 */
public interface UserService {

    User findByName(String username);

    User findById(Integer id);
}
