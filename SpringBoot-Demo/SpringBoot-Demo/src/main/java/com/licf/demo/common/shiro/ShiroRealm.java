package com.licf.demo.common.shiro;

import com.licf.demo.model.Role;
import com.licf.demo.model.User;
import com.licf.demo.service.RoleService;
import com.licf.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
/**
* 类描述: 实现AuthorizingRealm接口用户用户认证
 * 步骤是先授权 再验证
* @author licanfeng
* @date 2019/3/12 11:47
* @version 1.0
*/
@Slf4j
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    /**
     * 身份验证 : 用来验证用户身份 登录时被调用
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        log.info("---------------- 执行 Shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();
        // 从数据库获取对应用户名密码的用户
        User user = userService.getUserByName(name);
        if (user != null) {
            // 用户为禁用状态
            if (!"1".equals(user.getLoginFlag())) {
                throw new DisabledAccountException();
            }
            log.info("---------------- Shiro 凭证认证成功 ----------------------");
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user, //用户
                    user.getPassword(), //密码
                    getName()  //realm name
            );
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }

    /**
     * 授权
     * 角色权限和对应权限添加
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("---------------- 执行 Shiro 权限获取 ---------------------");
        //获取登录用户名
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (principal instanceof User) {
            User userLogin = (User) principal;
            log.info("当前登录用户为：{}，密码为：{}",userLogin.getLoginName() + userLogin.getPassword() );
            if(userLogin != null){
                //通过用户id获取用户拥有的角色
                List<Role> roleList = roleService.findByUserid(userLogin.getId());
                if(CollectionUtils.isNotEmpty(roleList)){
                    for(Role role : roleList){
                        info.addRole(role.getEnname());

/*                        //添加具体菜单权限 暂不需要 后续如果觉得使用角色不足以控制 可以对加上角色与接口权限的对应关系
                        List<Menu> menuList = menuService.getAllMenuByRoleId(role.getId());
                        if(CollectionUtils.isNotEmpty(menuList)){
                            for (Menu menu : menuList){
                                if(StringUtils.isNoneBlank(menu.getPermission())){
                                    info.addStringPermission(menu.getPermission());
                                }
                            }
                        }*/
                    }
                }
            }
        }
        log.info("---------------- 获取到以下权限 ----------------");
        log.info("当前用户角色为：{}",Arrays.toString(info.getRoles().toArray()));
        //log.info(info.getStringPermissions().toString());
        log.info("---------------- Shiro 权限获取成功 ----------------------");
        return info;
    }
}
