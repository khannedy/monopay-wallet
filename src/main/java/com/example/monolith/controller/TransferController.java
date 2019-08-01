package com.example.monolith.controller;

import com.example.monolith.entity.Authentication;
import com.example.monolith.model.service.ListTransferServiceRequest;
import com.example.monolith.model.web.WebResponse;
import com.example.monolith.model.web.response.TransferWebResponse;
import com.example.monolith.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/transfers")
public class TransferController {

  @Autowired
  private TransferService transferService;

  @RequestMapping(value = "/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<TransferWebResponse>> list(Authentication authentication,
                                                     @PathVariable("memberId") String memberId) {
    ListTransferServiceRequest serviceRequest = ListTransferServiceRequest.builder()
      .memberId(memberId)
      .merchantId(authentication.getId())
      .build();

    List<TransferWebResponse> responses = transferService.list(serviceRequest);

    return WebResponse.<List<TransferWebResponse>>builder()
      .code(HttpStatus.OK.value())
      .status(HttpStatus.OK.name())
      .data(responses)
      .build();
  }

}
