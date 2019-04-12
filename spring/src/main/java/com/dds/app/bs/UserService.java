package com.dds.app.bs;

import java.util.List;

public interface UserService {

    DdsUser getById(int userId);

    List<DdsUser> list();
}
