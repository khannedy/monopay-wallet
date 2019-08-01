package com.example.monolith.service;

import com.example.monolith.model.service.ListTransferServiceRequest;
import com.example.monolith.model.web.response.TransferWebResponse;

import javax.validation.Valid;
import java.util.List;

public interface TransferService {

  List<TransferWebResponse> list(@Valid ListTransferServiceRequest request);

}
