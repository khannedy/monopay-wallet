package com.monopay.wallet.service.impl;

import com.monopay.wallet.model.service.ListTransferServiceRequest;
import com.monopay.wallet.model.web.response.TransferWebResponse;
import com.monopay.wallet.repository.TransferRepository;
import com.monopay.wallet.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class TransferServiceImpl implements TransferService {

  @Autowired
  private TransferRepository transferRepository;

  @Override
  public List<TransferWebResponse> list(@Valid ListTransferServiceRequest request) {
    return transferRepository.findAllByMemberIdAndMerchantIdOrderByCreatedAtDesc(request.getMemberId(), request.getMerchantId())
      .stream()
      .map(transfer -> TransferWebResponse.builder()
        .id(transfer.getId())
        .memberId(transfer.getMemberId())
        .bank(transfer.getBank())
        .bankAccountName(transfer.getBankAccountName())
        .total(transfer.getTotal())
        .status(transfer.getStatus())
        .createdAt(transfer.getCreatedAt())
        .build())
      .collect(Collectors.toList());
  }
}
