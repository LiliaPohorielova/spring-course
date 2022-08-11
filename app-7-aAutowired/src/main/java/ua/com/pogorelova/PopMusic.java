package ua.com.pogorelova;

import org.springframework.stereotype.Component;

//@Component
public class PopMusic implements Music {
    @Override
    public String getSong() {
        return "O la la la";
    }
}