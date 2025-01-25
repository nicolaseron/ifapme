package org.example.car.exception;

import java.util.List;

public class UserHasCarException extends BusinessException {
    public UserHasCarException(Integer userId, List<String> plaques) {
        super("L'utilsateur avec l'id : " + userId + " posséde les voitures : " + String.join(",", plaques));
    }
}
