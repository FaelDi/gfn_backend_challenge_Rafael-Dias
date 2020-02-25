package com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.batch;


import com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.model.Customers;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<Customers, Customers> {

    private static final Map<String, String> DEPT_NAMES =
            new HashMap<>();

    public Processor() {

    }

    @Override
    public Customers process(Customers user) {
        return user;
    }
}
