package service.impl;

import org.springframework.stereotype.Service;
import repository.RiderRepository;

@Service
public class RiderServiceImpl {
    private final RiderRepository riderRepository;

    // Constructor injection
    public RiderServiceImpl(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }
}
