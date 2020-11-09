package com.cognizant.truckscheduling.AppointmentScheduling.service;

import com.cognizant.truckscheduling.AppointmentScheduling.dao.*;
import com.cognizant.truckscheduling.AppointmentScheduling.exception.*;
import com.cognizant.truckscheduling.AppointmentScheduling.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AppointmentService {

    @Autowired
    private MessageChannel output;
    @Autowired
    private PoInformationRepository poInformationRepository;
    @Autowired
    DCSlotsRepository dcSlotsRepository;
    @Autowired
    DCRepository dcRepository;
    @Autowired
    TruckRepository truckRepository;
    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    private AppointmentRepository repository;
    @Value("${app.exception.poNotAvailable}")
    String pounavailable;
    @Value("${app.exception.slotsFilled}")
    String slotsFilled;
    @Value("${app.exception.dcNotAvailable}")
    String dcUnavailable;
    @Value("${app.exception.slotNotFound}")
    String slotNotFound;
    @Value("${app.exception.truckNotFound}")
    String truckNotFound;
    @Value("${app.exception.vendorNotAvailable}")
    String vendorNotAvailable;

    public AppointmentScheduling saveAppointment(AppointmentScheduling scheduling) throws SlotsFilledException, PONotFoundException, DCNotAvailableException, DCSlotNotFoundException, TruckNotFoundException, VendorNotFoundException {
//        System.out.println(scheduling);
        int maxTrucks =0;
        scheduling.setPoInformation(getPoById(scheduling.getPoInformation().getPoNumber()));
        scheduling.setDc1(getDCByDCNumber(scheduling.getDc1().getDcNumber()));
//        System.out.println(scheduling.getDc1());
        scheduling.setTruck(getTruckByTruckNumber(scheduling.getTruck().getTruckNumber()));
        scheduling.setVendor(getVendorByName(scheduling.getVendor().getVendorId()));
//        scheduling.getDcSlots().setDc(getDCByDCNumber(scheduling.getDc1().getDcNumber()));
        System.out.println(scheduling.getDc1().getDcNumber());
        System.out.println(scheduling.getDcSlots().getTimeSlots());
        DCSlots dcSlots = getDCSlotByTime(scheduling.getDcSlots().getTimeSlots(), scheduling.getDc1());

//        DCSlots dcSlots = getDCSlotByTime(scheduling.getDcSlots().getTimeSlots());
           scheduling.setDcSlots(dcSlots);
        scheduling.getDcSlots().setDc(getDCByDCNumber(scheduling.getDc1().getDcNumber()));
        System.out.println(scheduling.getDcSlots().getDc().getDcNumber());
//          maxTrucks = dcSlots.getMaxTrucks();
//
////        System.out.println(dcSlots.getId());
////        System.out.println( scheduling.getDateOfAppointment());
//        if (repository.truckCount(dcSlots.getId(), scheduling.getDateOfAppointment()) == maxTrucks) {
//            throw new SlotsFilledException(slotsFilled);
//        }
//        Message<AppointmentScheduling> message = MessageBuilder.withPayload(scheduling).build();
//        output.send(message);
//        return repository.save(scheduling);
        System.out.println(scheduling);
        repository.save(scheduling);
        return scheduling ;
    }

    private Vendor getVendorByName(int vendorid) throws VendorNotFoundException {
        Vendor vendor = vendorRepository.findByVendorId(vendorid);
        if (vendor != null)
            return vendor;
        else
            throw new VendorNotFoundException(vendorNotAvailable);

    }

    private Truck getTruckByTruckNumber(Long truckNumber) throws TruckNotFoundException {

        Truck truck = truckRepository.findByTruckNumber(truckNumber);

        if (truck != null) {
            return truck;
        } else {
            throw new TruckNotFoundException(truckNotFound);
        }


    }

    private DCSlots getDCSlotByTime(String timeSlots, DC dcNumber) throws DCSlotNotFoundException {
        DCSlots dcSlots = dcSlotsRepository.findByTimeSlotsAndDc(timeSlots, dcNumber);
        System.out.println(dcSlots.getTimeSlots());
        DC dc1 = new DC();
        dc1.setDcNumber(dcSlots.getDc().getDcNumber());
        System.out.println(dc1);
        DCSlots required = new DCSlots();
        required.setId(dcSlots.getId());
        required.setTimeSlots(dcSlots.getTimeSlots());
        required.setMaxTrucks(dcSlots.getMaxTrucks());
        required.setDc(dc1);
        System.out.println(required);
        if (required != null)
            return required;
        else
            throw new DCSlotNotFoundException(slotNotFound);

    }


    private DC getDCByDCNumber(int dcNumber) throws DCNotAvailableException {

        DC existedDC = dcRepository.findByDcNumber(dcNumber);
        System.out.println(existedDC.getDcNumber());
        if (existedDC == null)
            throw new DCNotAvailableException(dcUnavailable);
        else
            return existedDC;

    }

    private PoInformation getPoById(Long poNumber) throws PONotFoundException {
        PoInformation existed = poInformationRepository.findByPoNumber(poNumber);
        if (existed != null)
            return existed;
        else
            throw new PONotFoundException(pounavailable);

    }

    public List<AppointmentScheduling> getList() {
//        System.out.println("********");
        return repository.findAll();
    }

    public Optional<AppointmentScheduling> getAppointments(int id) {
        return repository.findById(id);
    }

    public String modify(int id, AppointmentScheduling appointmentScheduling) {
       if(repository.findById(id).isPresent()) {
           AppointmentScheduling scheduling = repository.findById(id).get();
           PoInformation poInformation=new PoInformation();
           poInformation.setPoNumber(appointmentScheduling.getPoInformation().getPoNumber());
           Truck truck = new Truck();
           truck.setTruckNumber(appointmentScheduling.getTruck().getTruckNumber());
           Vendor vendor = new Vendor();
           vendor.setVendorId(appointmentScheduling.getVendor().getVendorId());
           DCSlots dcSlots = new DCSlots();
           dcSlots.setTimeSlots(appointmentScheduling.getDcSlots().getTimeSlots());
           DC dc = new DC();
           dc.setDcNumber(appointmentScheduling.getDc1().getDcNumber());
           scheduling.setDateOfAppointment(appointmentScheduling.getDateOfAppointment());
           scheduling.setPoInformation(poInformation);
           scheduling.setTruck(truck);
           scheduling.setVendor(vendor);
           scheduling.setDcSlots(dcSlots);
           scheduling.setDc1(dc);
            repository.save(scheduling);
           return  "Updated successfully";
       }

       else
          return "Id is not found";


    }

    public void deleteAppointment(int id) {
        System.out.println(id);
        if(repository.findById(id).isPresent())
//        repository.deleteQuery(id);
        repository.deleteById(id);
        else
            return;
    }

    public void deleteScheduling() {
        repository.deleteAll();
    }
}
