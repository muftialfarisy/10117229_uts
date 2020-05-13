package com.uts.IF7_10117229.presenter;

import com.uts.IF7_10117229.view.IView;
import com.uts.IF7_10117229.Model.IUser;
import com.uts.IF7_10117229.Model.User;
import com.uts.IF7_10117229.presenter.IPresenter;

import java.util.ArrayList;
import java.util.List;
public class Presenter implements IPresenter {
    private IView mainView;
    private List<User> users = new ArrayList<>();
    private String nim = "10117229";


    public Presenter(Presenter mainView) {
        this.mainView = (IView) mainView;
        init();

    }

    private void init() {
        User alfa = new User();

        alfa.setNIM("10117229");
        alfa.setNama("Mufti Alfarisy");
        alfa.setKelas("IF7");
        alfa.setDesc("seorang mahasiswa di unikom");


    }

    @Override
    public void save(User user) {
        user.setNIM(nim);

        users.add(user);

        mainView.onSave();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void load() {

    }


}
