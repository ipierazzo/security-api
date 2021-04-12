package br.com.ipierazzo.securityapi.model;

import org.springframework.stereotype.Component;

@Component
public class PasswordResponse {
    private boolean valid;

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean getValid() {
        return this.valid;
    }
}
