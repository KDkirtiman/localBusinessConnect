package com.lbc.localbusinessconnect.util;


import com.lbc.localbusinessconnect.model.UserCredentialDetails;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

    public UserCredentialDetails getUserCredentialsDetails(String userId, String password, String accountType, String accountStatus) {
        UserCredentialDetails userCredentialDetails = new UserCredentialDetails();
        userCredentialDetails.setUserId(userId);
        userCredentialDetails.setPassword(password);
        userCredentialDetails.setAccountType(accountType);
        userCredentialDetails.setAccountStatus(accountStatus);
        return userCredentialDetails;
    }
}
