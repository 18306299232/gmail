package com.mzy.gmail.user.service.impl;



import com.mzy.gmail.user.mapper.UmsMemberReceiveAddressMapper;
import com.mzy.gmail.user.mapper.UserMapper;
import com.mzy.gmall.bean.UmsMember;
import com.mzy.gmall.bean.UmsMemberReceiveAddress;
import com.mzy.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;


    @Override
    public List<UmsMember> getAlluser() {

        List<UmsMember> userMembers = userMapper.selectAll();

        return userMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getUserAddress(Long member) {


        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(member);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList=umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddressList;
    }
}
