package com.example.demo.service.impl;

import com.example.demo.entity.DO.UsersDO;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author Xmerge
 * @since 2023-12-11
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersDO> implements UsersService {

}
