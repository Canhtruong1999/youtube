package com.example.youtube.Service.subscribe;

import com.example.youtube.model.Subscribe;
import com.example.youtube.repository.SubscribeRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscribeService {
    private final SubscribeRepository subscribeRepository;

    public SubscribeService(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }
    public void save (Subscribe subscribe){
        subscribeRepository.save(subscribe);
    }
}
