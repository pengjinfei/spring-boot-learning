package com.pengjinfei.dao;

import com.pengjinfei.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long>{

    SysUser findByUsername(String username);
}
