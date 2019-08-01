package com.monopay.wallet.controller;

import com.monopay.wallet.entity.Authentication;
import com.monopay.wallet.model.service.CreateMemberServiceRequest;
import com.monopay.wallet.model.service.GetMemberServiceRequest;
import com.monopay.wallet.model.service.UpdateMemberServiceRequest;
import com.monopay.wallet.model.web.WebResponse;
import com.monopay.wallet.model.web.request.CreateMemberWebRequest;
import com.monopay.wallet.model.web.request.UpdateMemberWebRequest;
import com.monopay.wallet.model.web.response.CreateMemberWebResponse;
import com.monopay.wallet.model.web.response.GetMemberWebResponse;
import com.monopay.wallet.model.web.response.UpdateMemberWebResponse;
import com.monopay.wallet.service.MemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/members")
public class MemberController {

  @Autowired
  private MemberService memberService;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<CreateMemberWebResponse> create(Authentication authentication,
                                                     @RequestBody CreateMemberWebRequest request) {

    CreateMemberServiceRequest serviceRequest = CreateMemberServiceRequest.builder()
      .merchantId(authentication.getId())
      .build();
    BeanUtils.copyProperties(request, serviceRequest);

    CreateMemberWebResponse serviceResponse = memberService.create(serviceRequest);

    return WebResponse.<CreateMemberWebResponse>builder()
      .code(HttpStatus.OK.value())
      .status(HttpStatus.OK.name())
      .data(serviceResponse)
      .build();
  }

  @PutMapping(value = "/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<UpdateMemberWebResponse> update(Authentication authentication,
                                                     @PathVariable("memberId") String memberId,
                                                     @RequestBody UpdateMemberWebRequest request) {

    UpdateMemberServiceRequest serviceRequest = UpdateMemberServiceRequest.builder()
      .memberId(memberId)
      .merchantId(authentication.getId())
      .build();
    BeanUtils.copyProperties(request, serviceRequest);

    UpdateMemberWebResponse serviceResponse = memberService.update(serviceRequest);

    return WebResponse.<UpdateMemberWebResponse>builder()
      .code(HttpStatus.OK.value())
      .status(HttpStatus.OK.name())
      .data(serviceResponse)
      .build();
  }

  @GetMapping(value = "/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<GetMemberWebResponse> get(Authentication authentication,
                                               @PathVariable("memberId") String memberId) {
    GetMemberServiceRequest serviceRequest = GetMemberServiceRequest.builder()
      .memberId(memberId)
      .merchantId(authentication.getId())
      .build();

    GetMemberWebResponse serviceResponse = memberService.get(serviceRequest);

    return WebResponse.<GetMemberWebResponse>builder()
      .code(HttpStatus.OK.value())
      .status(HttpStatus.OK.name())
      .data(serviceResponse)
      .build();
  }
}
