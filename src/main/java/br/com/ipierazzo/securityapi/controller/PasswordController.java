package br.com.ipierazzo.securityapi.controller;

import br.com.ipierazzo.securityapi.constant.ConstantEndpoints;
import br.com.ipierazzo.securityapi.model.PasswordResponse;
import br.com.ipierazzo.securityapi.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.ipierazzo.securityapi.model.PasswordRequest;

@RestController
public class PasswordController {
    @Autowired
    private PasswordService passwordService;

    @RequestMapping(value = ConstantEndpoints.BASE_PATH + ConstantEndpoints.COLLECTION_PASSWORDS + "/validate", method = RequestMethod.POST)
    public PasswordResponse validate(@RequestBody PasswordRequest passwordRequest) {
        return passwordService.validatePassword(passwordRequest);
    }
}
