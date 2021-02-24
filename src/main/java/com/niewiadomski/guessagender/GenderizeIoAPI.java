package com.niewiadomski.guessagender;

import com.niewiadomski.guessagender.service.Genderize;
import com.niewiadomski.guessagender.service.GenderizeService;


public class GenderizeIoAPI {
    private GenderizeIoAPI() { }
    
    public static Genderize create() {
        return new GenderizeService();
    }

    /**
     * @param apiKey Genderize.io API key.
     * @return A client instance that can make more queries than one without a key.
     */
    public static Genderize create(String apiKey) {
        return new GenderizeService(apiKey);
    }
}
