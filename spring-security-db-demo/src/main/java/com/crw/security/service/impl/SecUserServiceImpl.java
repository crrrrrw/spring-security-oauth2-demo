package com.crw.security.service.impl;

import com.crw.security.mapper.SecUserMapper;
import com.crw.security.model.SecUser;
import com.crw.security.service.SecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecUserServiceImpl implements SecUserService {

    @Autowired
    private SecUserMapper secUserMapper;

    @Override
    public int insert(SecUser secUser) {
        long now = System.currentTimeMillis();
        secUser.setCreateAt(now);
        secUser.setUpdateAt(now);
        secUser.setRoles(SecUser.DEFAULT_ROLE);
        encryptPassword(secUser);
        return secUserMapper.insertSelective(secUser);
    }

    @Override
    public boolean updateById(SecUser secUser) {
        long now = System.currentTimeMillis();
        secUser.setUpdateAt(now);
        return secUserMapper.updateByPrimaryKeySelective(secUser) == 1;
    }

    @Override
    public SecUser getByUserName(String username) {
        return secUserMapper.selectByUserName(username);
    }

    /**
     * 加密密码
     */
    private void encryptPassword(SecUser secUser) {
        String password = secUser.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        secUser.setPassword(password);
    }
}
