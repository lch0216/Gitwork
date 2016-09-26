package com.yc.web.biz;

import com.yc.web.bean.User;

public interface UserBiz {
	public User login(User user );
	public boolean  register(User user );
	public boolean  validate(User user );
}
