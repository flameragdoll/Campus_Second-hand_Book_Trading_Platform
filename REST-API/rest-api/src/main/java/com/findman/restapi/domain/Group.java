package com.findman.restapi.domain;

import java.util.ArrayList;

public class Group {
    private String groupName;
    private ArrayList<User> users;

    public Group(String groupName) {
        users = new ArrayList<User>();
        this.groupName = groupName;
        System.out.println(groupName + "小组创建成功！");
        System.out.println("----------------------------");
    }

    //注册方法
    public void Join(User user) {
        System.out.println(user.getName() + " 加入兴趣小组：" + this.groupName);
        users.add(user);
    }

    //注销方法
    public void Quit(User user) {
        System.out.println(user.getName() + " 退出兴趣小组：" + this.groupName);
        users.remove(user);
    }

    public void NotifyUser(String username, String title) {
        System.out.println(this.groupName + "小组通知：组员" + username + "发布了一本书籍：" + title);
        //遍历观察者集合，调用每一个用户（自己除外）的围观方法
        for (User user : users) {
            if (!user.getName().equals(username)) {
                user.onlook();
            }
        }
    }
}
