package com.monopay.wallet.service;

import com.monopay.wallet.model.service.ListTransferServiceRequest;
import com.monopay.wallet.model.web.response.TransferWebResponse;

import javax.validation.Valid;
import java.util.List;

public interface TransferService {

  List<TransferWebResponse> list(@Valid ListTransferServiceRequest request);

}
