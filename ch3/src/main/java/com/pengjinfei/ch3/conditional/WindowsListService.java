package com.pengjinfei.ch3.conditional;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
