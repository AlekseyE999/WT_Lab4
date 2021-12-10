package by.bsuir.code.lab4.service.security;

import java.security.SecureRandom;

public class Salt {
    private final String salt;
    private final long creationTime;

    public String getValue() {
        return salt;
    }

    public Salt() {
        this.salt = Integer.toString(new SecureRandom().nextInt(Integer.MAX_VALUE));
        this.creationTime = System.currentTimeMillis();
    }

    public long getLifeTimeMs() {
        return System.currentTimeMillis() - creationTime;
    }
}
