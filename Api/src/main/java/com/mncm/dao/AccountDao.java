package com.mncm.dao;

import com.api.common.entity.common.Account;
import com.api.common.entity.common.App;
import com.api.common.model.contact.ContactModel;
import com.api.common.model.request.AccountRequestModel;

/**
 * Created by sonudhakar on 18/03/18.
 */
public interface AccountDao {
    public Account get(String id);
    public Account getByContactId(String contactId);
    public Account createAccount(AccountRequestModel accountRequestModel, ContactModel contactModel) throws Exception;
    public Account saveAccount(Account account) throws Exception;
    public Account deleteAccount(Account account) throws Exception;
}
