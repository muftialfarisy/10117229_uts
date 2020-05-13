package com.uts.IF7_10117229.view;

import com.uts.IF7_10117229.Model.User;

import java.util.List;

public interface IView {
    void onLoad(List<User> users);

    void onSave();

    void onDelete();

    void onUpdate();
}
