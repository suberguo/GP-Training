package com.dds.app.bs;

import com.dds.annotation.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    private Random random = new Random();

    @Override
    public DdsUser getById(int userId) {
        DdsUser user = new DdsUser();
        user.setName("guoshaobo");
        user.setAge(18);
        return user;
    }

    @Override
    public List<DdsUser> list() {
        List<DdsUser> users = new ArrayList<>();

        DdsUser user = new DdsUser();
        user.setName("某某某");

        user.setAge(random.nextInt(100));
        users.add(user);
        return users;
    }
}
