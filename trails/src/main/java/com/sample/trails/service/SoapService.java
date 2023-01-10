package com.sample.trails.service;

import com.sample.trails.model.entity.UserEntity;
import com.sample.trails.model.soaprequest.CreateUserRequest;
import com.sample.trails.model.soaprequest.GetUserRequest;
import com.sample.trails.model.soaprequest.UpdateUserRequest;
import com.sample.trails.model.soapresponse.CreateUserResponse;
import com.sample.trails.model.soapresponse.GetUserResponse;
import com.sample.trails.model.soapresponse.UpdateUserResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SoapService {
    private final UserEntity userEntity;

    public SoapService(UserEntity userEntity) {
        this.userEntity = userEntity;
    }


    public CreateUserResponse createUser(CreateUserRequest soapRequest){
        BeanUtils.copyProperties(soapRequest,userEntity);
        return new CreateUserResponse(userEntity.getUserId(), userEntity.getUserName(), userEntity.getUserAge(), userEntity.getUserGender());
    }

    public GetUserResponse getUser(GetUserRequest getSoapRequest) {
        if(getSoapRequest.getUserId().equals(userEntity.getUserId())){
            return new GetUserResponse(userEntity.getUserId(), userEntity.getUserName(), userEntity.getUserAge(), userEntity.getUserGender());
        }else{
            throw new RuntimeException("UserId NOT FOUND for given request");
        }
    }

    public UpdateUserResponse updateUser(UpdateUserRequest updateSoapRequest) {
        if(updateSoapRequest.getUserId().equals(userEntity.getUserId())){
            String updatedUserName = StringUtils.isNotBlank(updateSoapRequest.getUserName())? updateSoapRequest.getUserName() : userEntity.getUserName();
            userEntity.setUserName(updatedUserName);
            Integer updatedUserAge = updateSoapRequest.getUserAge()==0 ? userEntity.getUserAge() : updateSoapRequest.getUserAge();
            userEntity.setUserAge(updatedUserAge);
            String updateUserGender = StringUtils.isNotBlank(updateSoapRequest.getUserGender())? updateSoapRequest.getUserGender() : userEntity.getUserGender();
            userEntity.setUserGender(updateUserGender);
            return new UpdateUserResponse(userEntity.getUserId(), userEntity.getUserName(), userEntity.getUserAge(), userEntity.getUserGender());
        }else{
            throw new RuntimeException("UserId NOT FOUND for given request");
        }
    }
}
