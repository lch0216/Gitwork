
package com.yc.web.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.web.bean.User;
import com.yc.web.biz.UserBiz;
import com.yc.web.dao.BaseDao;
import com.yc.web.utils.Encrypt;
@Service
public class UserBizImpl extends BaseBizImpl implements UserBiz{
	public User login(User user) {
		user.setPassword( Encrypt.md5(user.getPassword() ));
		return (User) baseDao.find(user, "getLoginUser");
	}

	public boolean register(User user) {
		user.setPassword( Encrypt.md5(user.getPassword() ));
		baseDao.save(user, "saveUser");
		return true;
	}

	public boolean validate(User user) {
		baseDao.find(user, "getUserByName");
		return true;
	}
	
}
