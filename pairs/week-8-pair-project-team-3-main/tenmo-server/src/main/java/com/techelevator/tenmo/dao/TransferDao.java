package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {
    void sendMoney(int fromAccountId, int toUserId,BigDecimal amount);

    List<Transfer> listTransfersByAccountId(int userId);

    Transfer getTransferById(int transferId);
}
