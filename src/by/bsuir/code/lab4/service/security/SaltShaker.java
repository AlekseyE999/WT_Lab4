package by.bsuir.code.lab4.service.security;

import java.util.ArrayList;
import java.util.List;

public class SaltShaker {
    private final long saltExpireTimeMs;

    private final List<Salt> salts = new ArrayList<>();

    public SaltShaker(long saltExpireTimeMs) {
        this.saltExpireTimeMs = saltExpireTimeMs;
    }

    protected void removeOld() {
        synchronized (salts) {
            for (int i = salts.size() - 1; i >= 0; i--) {
                if (salts.get(i).getLifeTimeMs() > saltExpireTimeMs) {
                    salts.remove(i);
                }
            }
        }
    }

    public String createSalt() {
        removeOld();

        Salt salt = new Salt();
        synchronized (salts) {
            salts.add(salt);
        }

        return salt.getValue();
    }

    public boolean tryUse(String salt) {
        Salt used = null;
        synchronized (salts) {

            for (Salt curSalt : salts) {
                if (curSalt.getValue().equals(salt)) {
                    used = curSalt;
                    break;
                }
            }

            if (used == null) {
                return false;
            }

            salts.remove(used);
        }

        return used.getLifeTimeMs() <= saltExpireTimeMs;
    }
}
