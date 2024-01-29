package com.sujeet.project.springboot.util;

import com.sujeet.project.springboot.entity.UserAddressEntity;
import com.sujeet.project.springboot.model.UserAddress;
import org.springframework.stereotype.Component;

@Component
public class UserAddressEntityUtil {
    public UserAddress fromUserAddressEntity(UserAddressEntity uEntity) {
        UserAddress aModel = new UserAddress();
        aModel.setuId(uEntity.getId());
        aModel.setuCity(uEntity.getCity());
        aModel.setuCountry(uEntity.getCountry());
        aModel.setuZipCode(uEntity.getZipCode());
        return aModel;
    }
}
