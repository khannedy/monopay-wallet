package com.monopay.wallet.service;

import com.monopay.wallet.model.service.CreateMemberServiceRequest;
import com.monopay.wallet.model.service.GetMemberServiceRequest;
import com.monopay.wallet.model.service.UpdateMemberServiceRequest;
import com.monopay.wallet.model.web.response.CreateMemberWebResponse;
import com.monopay.wallet.model.web.response.GetMemberWebResponse;
import com.monopay.wallet.model.web.response.UpdateMemberWebResponse;

import javax.validation.Valid;

public interface MemberService {

  CreateMemberWebResponse create(@Valid CreateMemberServiceRequest request);

  UpdateMemberWebResponse update(@Valid UpdateMemberServiceRequest request);

  GetMemberWebResponse get(@Valid GetMemberServiceRequest request);

}
