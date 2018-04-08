package com.mncm.daoimpl;

import com.api.common.entity.address.Address;
import com.api.common.entity.common.Account;
import com.api.common.entity.common.LinkedProduct;
import com.api.common.entity.common.App;
import com.api.common.entity.contact.Contact;
import com.api.common.entity.contact.ContactMethod;
import com.api.common.enums.AccountType;
import com.api.common.model.common.AccountModel;
import com.api.common.model.common.LinkedProductModel;
import com.api.common.model.contact.ContactMethodModel;
import com.api.common.model.contact.ContactModel;
import com.api.common.model.request.AccountRequestModel;
import com.api.common.services.objectify.OfyService;
import com.api.common.utils.RandomUtil;
import com.mncm.dao.AccountDao;
import com.mncm.dao.AddressDao;
import com.mncm.dao.ContactMethodDao;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by sonudhakar on 18/03/18.
 */
@Slf4j
public class AccountDaoImpl extends OfyService implements AccountDao{

    @Override
    public Account get(String id) {
        return get(Account.class, id);
    }

    @Override
    public Account getByContactId(String contactId) {
        if (contactId == null)
            return null;

        //TODO it can be cached
        return ofy().load().type(Account.class).filter("contactId", contactId).first().now();
    }

    @Override
    public Account createAccount(AccountRequestModel accountRequestModel, ContactModel contactModel) throws Exception {

        Set<String> contactMethodIds = new HashSet<>();
        Set<String> addressIds = new HashSet<>();

        AccountModel accountModel = accountRequestModel.getAccountModel();
        Set<String> linkedContactIds = new HashSet<>();
        linkedContactIds.add(contactModel.getId());

        AccountType accountType = accountModel.getType();

        String accountId = "";
        if (accountModel.getId() != null) {
            accountId = accountModel.getId();
        } else {
            accountId = RandomUtil.generateSecureRandomString(32, RandomUtil.RandomModeType.ALPHANUMERIC);
        }

        try {
            ContactMethodDao contactMethodDao = new ContactMethodDaoImpl();
            List<ContactMethod> contactMethods = contactMethodDao.createBulk(accountRequestModel.getLinkedContactMethods());
            Iterator iterator = contactMethods.iterator();

            while (iterator.hasNext()){
                ContactMethod contactMethod = (ContactMethod) iterator.next();
                contactMethodIds.add(contactMethod.getId());
            }
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }

        try {
            AddressDao addressDao = new AddressDaoImpl();
            List<Address> addressSet = addressDao.createBulk(accountRequestModel.getLinkedAddresses());
            Iterator iterator = addressSet.iterator();

            while (iterator.hasNext()){
                Address address = (Address) iterator.next();
                addressIds.add(address.getId());
            }
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }

        Account account = new Account(accountId,accountModel.getName(),accountType,linkedContactIds,contactMethodIds,addressIds);

        return saveAccount(account);

    }

    @Override
    public Account saveAccount(Account account) throws Exception{
        return save(account) != null ? account : null;
    }

    @Override
    public Account deleteAccount(Account account) throws Exception{

        return delete(account) ? account : null;

    }


}
