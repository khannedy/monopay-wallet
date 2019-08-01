package com.example.monolith.service;

import com.example.monolith.model.service.CreateMemberServiceRequest;
import com.example.monolith.model.service.GetMemberServiceRequest;
import com.example.monolith.model.service.UpdateMemberServiceRequest;
import com.example.monolith.model.web.response.CreateMemberWebResponse;
import com.example.monolith.model.web.response.GetMemberWebResponse;
import com.example.monolith.model.web.response.UpdateMemberWebResponse;

import javax.validation.Valid;

public interface MemberService {

  CreateMemberWebResponse create(@Valid CreateMemberServiceRequest request);

  UpdateMemberWebResponse update(@Valid UpdateMemberServiceRequest request);

  GetMemberWebResponse get(@Valid GetMemberServiceRequest request);

}
