package br.com.ipierazzo.securityapi.service.impl;

import br.com.ipierazzo.securityapi.model.PasswordRequest;
import br.com.ipierazzo.securityapi.model.PasswordResponse;
import br.com.ipierazzo.securityapi.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordServiceImpl implements PasswordService {
    @Autowired
    PasswordResponse passwordResponse;

    @Value("${password.pattern}")
    private String patternString;

    @Value("${password.pattern-duplicate}")
    private String patternDuplicateString;

    public PasswordResponse validatePassword(PasswordRequest passwordRequest) {
        String passwordString = passwordRequest.getPassword();
        Pattern patternDup = Pattern.compile(patternDuplicateString);
        Pattern patternPwd = Pattern.compile(patternString);
        Matcher matcherDup = patternDup.matcher(passwordString);

        if (matcherDup.find()) { //check character duplicate
            passwordResponse.setValid(false);
        } else { //check password pattern
            passwordResponse.setValid(patternPwd.matcher(passwordString).matches());
        }
        return passwordResponse;
    }
}
