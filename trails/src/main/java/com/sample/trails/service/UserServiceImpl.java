package com.sample.trails.service;

import com.sample.trails.model.request.UserRequest;
import com.sample.trails.model.response.UserResponse;
import com.sample.trails.model.soaprequest.CreateUserRequest;
import com.sample.trails.model.soaprequest.GetUserRequest;
import com.sample.trails.model.soaprequest.UpdateUserRequest;
import com.sample.trails.model.soapresponse.CreateUserResponse;
import com.sample.trails.model.soapresponse.GetUserResponse;
import com.sample.trails.model.soapresponse.UpdateUserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private final SoapService soapService;

    public UserServiceImpl(SoapService soapService) {
        this.soapService = soapService;
    }


    public UserResponse createUser(UserRequest userRequest){
        CreateUserRequest createSoapRequest = new CreateUserRequest();
        BeanUtils.copyProperties(userRequest, createSoapRequest);
        CreateUserResponse createSoapResponse =  soapService.createUser(createSoapRequest);
        return new UserResponse(createSoapResponse.getUserId(), createSoapResponse.getUserName(), createSoapResponse.getUserAge(), createSoapResponse.getUserGender());
    }


    public UserResponse getUser(String userId) {
        GetUserRequest getSoapRequest = new GetUserRequest();
        getSoapRequest.setUserId(userId);
        GetUserResponse getSoapResponse = soapService.getUser(getSoapRequest);
        return new UserResponse(getSoapResponse.getUserId(), getSoapResponse.getUserName(), getSoapResponse.getUserAge(), getSoapResponse.getUserGender());
    }

    public UserResponse updateUser(UserRequest userRequest) {
        UpdateUserRequest updateSoapRequest = new UpdateUserRequest();
        BeanUtils.copyProperties(userRequest, updateSoapRequest);
        UpdateUserResponse updateSoapResponse = soapService.updateUser(updateSoapRequest);
        return new UserResponse(updateSoapResponse.getUserId(), updateSoapResponse.getUserName(), updateSoapResponse.getUserAge(), updateSoapResponse.getUserGender());
    }
}
