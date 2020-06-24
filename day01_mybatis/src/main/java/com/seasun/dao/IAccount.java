package com.seasun.dao;

import com.seasun.domain.Account;

import java.util.List;

public interface IAccount {
    List<Account> findAll();

    Account findById(Integer id);
}
