package com.uts.IF7_10117229.presenter;

import com.uts.IF7_10117229.Model.User;

import java.util.List;

public interface IPresenter {
    void save(User user);

    void update(User user);

    void delete(User user);

    void load();
}
