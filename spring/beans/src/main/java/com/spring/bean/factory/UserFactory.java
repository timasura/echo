package com.spring.bean.factory;

import com.spring.ioc.domain.User;

public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }
}
