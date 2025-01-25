package org.example.MainMenu;

import org.example.exception.BusinessException;

public interface Menu {
    public abstract void execute() throws BusinessException;
}
