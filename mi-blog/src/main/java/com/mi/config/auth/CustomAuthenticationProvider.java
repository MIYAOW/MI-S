package com.mi.config.auth;

import com.mi.module.blog.entity.User;
import com.mi.module.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 安全验证提供
 * @author yesh
 *         (M.M)!
 *         Created by 2017/7/6.
 */
@Configuration
@EnableWebSecurity
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private IUserService iUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String username = token.getName();
        String pwdDigest = token.getCredentials().toString();
        //从数据库找到的用户
        User user = new User();
        if (username != null) {
            user = iUserService.selectByName(username);
        }
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在或者密码无效");
        }else if (user.getEnabled()==1){
            throw new DisabledException("用户已被禁用");
        }else if(user.getLocked()==1){
            throw new LockedException("账号已被锁定");
        }else if(user.getCredential()==1){
            throw new LockedException("凭证已过期");
        }else if(user.getExpired()==1){
            throw new AccountExpiredException("账号已过期");
        }

        String password = user.getUserPwd();
        //密码可加密处理

        if (!password.equals(pwdDigest)) {
            throw new BadCredentialsException("用户密码错误");
        }
        //与authentication里面的credentials相比较
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        //授权
        return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
    }

    public void config(WebSecurity web) {
        web.ignoring().antMatchers("/js/**", "/css/**", "/vendor/**", "/image/**", "/admin/**");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}


