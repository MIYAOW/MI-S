package com.mi.module.blog.service.impl;

import com.mi.module.blog.entity.Log;
import com.mi.module.blog.mapper.LogMapper;
import com.mi.module.blog.service.ILogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 * 操作日志; InnoDB free: 11264 kB 服务实现类
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {
	
}
