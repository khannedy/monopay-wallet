package com.monopay.wallet.controller;

import com.monopay.wallet.entity.Authentication;
import com.example.monolith.model.service.*;
import com.monopay.wallet.model.web.WebResponse;
import com.monopay.wallet.model.web.request.PointTransactionWebRequest;
import com.monopay.wallet.model.web.request.PurchaseTransactionWebRequest;
import com.monopay.wallet.model.web.request.TopUpTransactionWebRequest;
import com.monopay.wallet.model.web.request.TransferTransactionWebRequest;
import com.example.monolith.model.web.response.*;
import com.monopay.wallet.service.TransactionService;
import com.monopay.wallet.model.service.*;
import com.monopay.wallet.model.web.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @PostMapping(value = "/topup", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<TopUpTransactionWebResponse> topUp(Authentication authentication,
                                                        @RequestBody TopUpTransactionWebRequest request) {
    TopUpTransactionServiceRequest serviceRequest = TopUpTransactionServiceRequest.builder()
      .memberId(request.getMemberId())
      .merchantId(authentication.getId())
      .total(request.getTotal())
      .build();

    TopUpTransactionWebResponse response = transactionService.topUp(serviceRequest);

    return WebResponse.<TopUpTransactionWebResponse>builder()
      .code(HttpStatus.OK.value())
      .status(HttpStatus.OK.name())
      .data(response)
      .build();
  }

  @PostMapping(value = "/purchase", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<PurchaseTransactionWebResponse> purchase(Authentication authentication,
                                                              @RequestBody PurchaseTransactionWebRequest request) {
    PurchaseTransactionServiceRequest serviceRequest = PurchaseTransactionServiceRequest.builder()
      .memberId(request.getMemberId())
      .merchantId(authentication.getId())
      .total(request.getTotal())
      .build();

    PurchaseTransactionWebResponse response = transactionService.purchase(serviceRequest);

    return WebResponse.<PurchaseTransactionWebResponse>builder()
      .code(HttpStatus.OK.value())
      .status(HttpStatus.OK.name())
      .data(response)
      .build();
  }

  @PostMapping(value = "/point", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<PointTransactionWebResponse> point(Authentication authentication,
                                                        @RequestBody PointTransactionWebRequest request) {
    PointTransactionServiceRequest serviceRequest = PointTransactionServiceRequest.builder()
      .memberId(request.getMemberId())
      .merchantId(authentication.getId())
      .total(request.getTotal())
      .build();

    PointTransactionWebResponse response = transactionService.point(serviceRequest);

    return WebResponse.<PointTransactionWebResponse>builder()
      .code(HttpStatus.OK.value())
      .status(HttpStatus.OK.name())
      .data(response)
      .build();
  }

  @PostMapping(value = "/transfer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<TransferTransactionWebResponse> transfer(Authentication authentication,
                                                              @RequestBody TransferTransactionWebRequest request) {
    TransferTransactionServiceRequest serviceRequest = TransferTransactionServiceRequest.builder()
      .merchantId(authentication.getId())
      .memberId(request.getMemberId())
      .bank(request.getBank())
      .bankAccountNumber(request.getBankAccountNumber())
      .total(request.getTotal())
      .build();

    TransferTransactionWebResponse response = transactionService.transfer(serviceRequest);

    return WebResponse.<TransferTransactionWebResponse>builder()
      .code(HttpStatus.OK.value())
      .status(HttpStatus.OK.name())
      .data(response)
      .build();
  }

  @GetMapping(value = "/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<TransactionWebResponse>> transfer(Authentication authentication,
                                                            @PathVariable("memberId") String memberId) {
    ListTransactionServiceRequest serviceRequest = ListTransactionServiceRequest.builder()
      .memberId(memberId)
      .merchantId(authentication.getId())
      .build();

    List<TransactionWebResponse> responses = transactionService.list(serviceRequest);

    return WebResponse.<List<TransactionWebResponse>>builder()
      .code(HttpStatus.OK.value())
      .status(HttpStatus.OK.name())
      .data(responses)
      .build();
  }

}
