package com.monopay.wallet.service.impl;

import com.monopay.wallet.entity.Balance;
import com.monopay.wallet.entity.Member;
import com.monopay.wallet.model.service.CreateMemberServiceRequest;
import com.monopay.wallet.model.service.GetMemberServiceRequest;
import com.monopay.wallet.model.service.UpdateMemberServiceRequest;
import com.monopay.wallet.model.web.response.CreateMemberWebResponse;
import com.monopay.wallet.model.web.response.GetMemberWebResponse;
import com.monopay.wallet.model.web.response.UpdateMemberWebResponse;
import com.monopay.wallet.repository.BalanceRepository;
import com.monopay.wallet.repository.MemberRepository;
import com.monopay.wallet.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.UUID;

@Service
@Validated
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private BalanceRepository balanceRepository;

  @Override
  public CreateMemberWebResponse create(@Valid CreateMemberServiceRequest request) {
    Member member = Member.builder()
      .id(UUID.randomUUID().toString())
      .email(request.getEmail())
      .phone(request.getPhone())
      .merchantId(request.getMerchantId())
      .name(request.getName())
      .verified(Boolean.FALSE)
      .build();

    member = memberRepository.save(member);

    Balance balance = Balance.builder()
      .id(member.getId())
      .merchantId(request.getMerchantId())
      .point(0L)
      .balance(0L)
      .build();

    balance = balanceRepository.save(balance);

    return CreateMemberWebResponse.builder()
      .id(member.getId())
      .name(member.getName())
      .phone(member.getPhone())
      .email(member.getEmail())
      .build();
  }

  @Override
  public UpdateMemberWebResponse update(@Valid UpdateMemberServiceRequest request) {
    Member member = memberRepository.findByIdAndMerchantId(request.getMemberId(), request.getMerchantId());
    member.setName(request.getName());
    member.setVerified(request.getVerified());

    memberRepository.save(member);

    return UpdateMemberWebResponse.builder()
      .id(member.getId())
      .name(member.getName())
      .phone(member.getPhone())
      .email(member.getEmail())
      .build();
  }

  @Override
  public GetMemberWebResponse get(@Valid GetMemberServiceRequest request) {
    Member member = memberRepository.findByIdAndMerchantId(request.getMemberId(), request.getMerchantId());
    Balance balance = balanceRepository.findById(member.getId()).get();

    return GetMemberWebResponse.builder()
      .id(member.getId())
      .name(member.getName())
      .phone(member.getPhone())
      .email(member.getEmail())
      .balance(GetMemberWebResponse.Balance.builder()
        .balance(balance.getBalance())
        .point(balance.getPoint())
        .build())
      .build();
  }
}
