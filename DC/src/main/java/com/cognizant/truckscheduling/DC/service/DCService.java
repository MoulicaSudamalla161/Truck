package com.cognizant.truckscheduling.DC.service;

import com.cognizant.truckscheduling.DC.dao.DCTruckRepository;
import com.cognizant.truckscheduling.DC.exception.SlotExistException;
import com.cognizant.truckscheduling.DC.exception.SlotNotAvailableException;
import com.cognizant.truckscheduling.DC.model.DC;
import com.sun.deploy.security.SelectableSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DCService {
    @Value("${app.exception.slotNotAvailable}")
    private  String slotNotAvailable;
    @Value("${app.exception.slotAlreadyAvailable}")
    private String slotExistMessage;
    @Autowired
    DCTruckRepository repository;

    public List<DC> getDC() {
        return  repository.findAll();
    }

    public DC getDCList(int id) throws SlotNotAvailableException {

        DC dc = repository.findAll().stream()
                .filter(dcList -> id == dcList.getDcNumber())
                .findAny()
                .orElse(null);

        if(dc != null)
            return  dc;
           else
           throw new SlotNotAvailableException(slotNotAvailable + id);


    }

    public DC saveList(DC dcList) throws SlotExistException {
        if(repository.findById(dcList.getDcNumber()).isPresent())
            throw new SlotExistException(slotExistMessage+" "+dcList.getDcNumber());
        else

        return repository.save(dcList);

    }

    public DC updateDC(DC dc, int id) throws SlotNotAvailableException {
        if (repository.findById(id).isPresent()){
            DC d = repository.findById(id).get();
            d.setDcNumber(dc.getDcNumber());
            d.setDcCity(dc.getDcCity());
            d.setDcType(dc.getDcType());
            return  repository.save(d);
        }
            else
                throw new SlotNotAvailableException(slotNotAvailable+" "+id);



    }

    public void deleteById(int id) throws SlotNotAvailableException {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
            else
            throw new SlotNotAvailableException(slotNotAvailable+" "+id);
    }

    public void deleteAllDC() {
        repository.deleteAll();
    }
}
