package dcdev.demospringsecurityjwt.security;

import java.util.*;

public class JWTObject {
    private String subject;
    private Date issuedAt;
    private Date expiration;
    private List<String> roles;

    public void setRoles(String ...roles) {
        this.roles = Arrays.asList(roles);
    }

    public String getSubject() {
        return subject;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public Date getExpiration() {
        return expiration;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
