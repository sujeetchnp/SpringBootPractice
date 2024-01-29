package com.sujeet.project.springboot.service;

import com.sujeet.project.springboot.entity.UserAddressEntity;
import com.sujeet.project.springboot.model.UserAddress;
import com.sujeet.project.springboot.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    public List<UserAddress> getAllUserAddresses() {
        List<UserAddressEntity> userAddressEntityList = userAddressRepository.findAll();
        List<UserAddress> userAddressList = fromEntityList(userAddressEntityList);
        return userAddressList;
    }

    private UserAddress fromEntity(UserAddressEntity entity) {
        UserAddress userAddressModel = new UserAddress();
        userAddressModel.setuId(entity.getId());
        userAddressModel.setuCity(entity.getCity());
        userAddressModel.setuCountry(entity.getCountry());
        userAddressModel.setuZipCode(entity.getZipCode());
        return userAddressModel;
    }

    private List<UserAddress> fromEntityList(List<UserAddressEntity> entityList) {
        List<UserAddress> userAddressListAll = new ArrayList<>();
        for (UserAddressEntity eachEntity : entityList) {
            UserAddress userAddressModel = fromEntity(eachEntity);
            userAddressListAll.add(userAddressModel);
        }
        return userAddressListAll;
    }

    private UserAddressEntity toEntity(UserAddress userAddress) {
        UserAddressEntity userAddressEntity = new UserAddressEntity();
        userAddressEntity.setId(userAddress.getuId());
        userAddressEntity.setCity(userAddress.getuCity());
        userAddressEntity.setCountry(userAddress.getuCountry());
        userAddressEntity.setZipCode(userAddress.getuZipCode());
        return userAddressEntity;
    }

    public void saveUserAddress(UserAddress userAddress) {
        UserAddressEntity userAddressEntity = toEntity(userAddress);
        UserAddressEntity savedEntity = userAddressRepository.save(userAddressEntity);
        UserAddress userAddressModel = fromEntity(savedEntity);
    }

    @Transactional
    public int deleteRecord(UserAddress userAddress) {
        return userAddressRepository.deleteUserByAddressId(userAddress.getuId());
    }
}
