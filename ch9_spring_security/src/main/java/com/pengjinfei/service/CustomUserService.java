package com.pengjinfei.service;

import com.pengjinfei.dao.SysUserRepository;
import com.pengjinfei.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Pengjinfei on 16/9/12.
 * Description:
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserRepository.findByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return sysUser;
    }
}
