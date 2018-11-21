package com.crw.security.service;

import com.crw.security.model.SecUser;

public interface SecUserService {

    int insert(SecUser secUser);

    boolean updateById(SecUser secUser);

    SecUser getByUserName(String username);

}
