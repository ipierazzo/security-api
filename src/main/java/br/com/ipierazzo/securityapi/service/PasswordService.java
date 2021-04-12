package br.com.ipierazzo.securityapi.service;

import br.com.ipierazzo.securityapi.model.PasswordRequest;
import br.com.ipierazzo.securityapi.model.PasswordResponse;

public interface PasswordService {
    PasswordResponse validatePassword(PasswordRequest passwordRequest);
}
