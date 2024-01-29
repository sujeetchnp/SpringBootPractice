package com.sujeet.project.springboot.service;

import com.sujeet.project.springboot.entity.FlightUserEntity;
import com.sujeet.project.springboot.entity.UserAddressEntity;
import com.sujeet.project.springboot.model.FlightUser;
import com.sujeet.project.springboot.model.UserAddress;
import com.sujeet.project.springboot.repository.FlightUserRepository;
import com.sujeet.project.springboot.util.UserAddressEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightUserService {

    @Autowired
    private UserAddressEntityUtil userAddressEntityUtil;

    @Autowired
    private FlightUserRepository flightUserRepository;

    @Transactional
    public int updateUserOperation(FlightUser flightUser) {
        return flightUserRepository.updateFlightUser(flightUser.getuName(), flightUser.getuPhone(), flightUser.getuId());
    }

    public FlightUser getAddressByUserId(Integer id) {

        FlightUserEntity fEntity = flightUserRepository.findAddressByUserId(id);
        FlightUser userModel = fromEntity(fEntity);

        UserAddress userAddress = userAddressEntityUtil.fromUserAddressEntity(fEntity.getUserAddress());

        userModel.setUserAddress(userAddress);
        return userModel;
    }

    public FlightUser fromEntity(FlightUserEntity entity) {
        FlightUser model = new FlightUser();
        model.setuId(entity.getUserId());
        model.setuName(entity.getName());
        model.setuPhone(entity.getPhone());
        return model;
    }

    public List<FlightUser> fromFlightUserEntityList(List<FlightUserEntity> entityList) {
        List<FlightUser> flightUserList = new ArrayList<>();
        for (FlightUserEntity entity : entityList) {
            FlightUser fUserModel = fromEntity(entity);
            flightUserList.add(fUserModel);
        }
        return flightUserList;
    }

    public List<FlightUser> getAllFlightUsers() {
        List<FlightUserEntity> fUserEntity = flightUserRepository.findAllFlightUsers();
        List<FlightUser> flightUserList = new ArrayList<>();

        for (FlightUserEntity entity : fUserEntity) {
            FlightUser fUserModel = fromEntity(entity);

            UserAddressEntity fUserAddressEntity = entity.getUserAddress();
            fUserModel.setUserAddress(userAddressEntityUtil.fromUserAddressEntity(fUserAddressEntity));

            flightUserList.add(fUserModel);
        }
        return flightUserList;
    }

    private FlightUserEntity toEntity(FlightUser flightUser) {
        FlightUserEntity fUserEntity = new FlightUserEntity();
        fUserEntity.setUserId(flightUser.getuId());
        fUserEntity.setName(flightUser.getuName());
        fUserEntity.setPhone(flightUser.getuPhone());

        UserAddressEntity userAddressEntity = new UserAddressEntity();
        userAddressEntity.setId(flightUser.getUserAddress().getuId());
        userAddressEntity.setCity(flightUser.getUserAddress().getuCity());
        userAddressEntity.setCountry(flightUser.getUserAddress().getuCountry());
        userAddressEntity.setZipCode(flightUser.getUserAddress().getuZipCode());
        fUserEntity.setUserAddress(userAddressEntity);

        return fUserEntity;
    }

    public void saveFlightUser(FlightUser flightUser) {
        FlightUserEntity userEntity = toEntity(flightUser);
        FlightUserEntity savedEntity = flightUserRepository.save(userEntity);
        FlightUser userModel = fromEntity(savedEntity);
    }

    @Transactional
    public int deleteFlightUser(FlightUser flightUser) {
        return flightUserRepository.deleteUserByUserId(flightUser.getuId());
    }

}
