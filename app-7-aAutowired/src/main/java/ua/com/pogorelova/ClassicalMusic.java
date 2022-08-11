package ua.com.pogorelova;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Beethoven - Moonlight Sonata";
    }
}
