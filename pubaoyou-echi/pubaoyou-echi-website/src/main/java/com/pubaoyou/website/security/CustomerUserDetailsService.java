package com.pubaoyou.website.security;

import com.pubaoyou.dao.models.ItsscAccount;
import com.pubaoyou.service.service.login.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Slf4j
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    PasswordEncoder pw;

    @Resource
    protected UserLoginService userLoginService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("current login user is {}",userName);

        try {
            List<ItsscAccount> list = userLoginService.queryUserAccount(userName,null);
            log.info("list length is {}",list.size());

            if(list == null || list.size() == 0)
                throw new UsernameNotFoundException("用户不存在！！");

            ItsscAccount itsscAccount = list.get(0);
            String password = pw.encode(itsscAccount.getUserPwd());
            return new User(itsscAccount.getUserName(),password,AuthorityUtils.commaSeparatedStringToAuthorityList("admin.normal"));

        } catch (Exception e) {
            throw new UsernameNotFoundException("用户不存在！！");
        }

    }
}
