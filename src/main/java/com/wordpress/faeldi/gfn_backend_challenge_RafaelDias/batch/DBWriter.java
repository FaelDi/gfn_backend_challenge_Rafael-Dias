package com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.batch;


import com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.model.Customers;
import com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.repository.CustomersRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Customers> {


    private CustomersRepository userRepository;

    public DBWriter(CustomersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void write(List<? extends Customers> users) {

        System.out.println("Data Saved for Users: " + users);
        userRepository.saveAll(users);
    }
}
