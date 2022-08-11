package ua.com.pogorelova;

import org.springframework.stereotype.Component;

//@Component
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Queen - The Show Must Go On";
    }
}
