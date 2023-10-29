package com.personal.Splitwise.service;


import com.personal.Splitwise.dto.request.AddGroupRequestDto;
import com.personal.Splitwise.dto.response.AddGroupResponseDto;
import com.personal.Splitwise.dto.request.AddUserRequestDto;
import com.personal.Splitwise.dto.response.AddUserResponseDto;

public interface AddDataService {
    AddUserResponseDto addUser(AddUserRequestDto user);

    AddGroupResponseDto addGroup(AddGroupRequestDto group);
}
