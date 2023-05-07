package com.example.bus.service;
import com.example.bus.model.Bus;
import com.example.bus.model.Reservation;
import com.example.bus.model.Traveler;
import com.example.bus.reposetory.BusRepository;
import com.example.bus.reposetory.ReservRepository;
import com.example.bus.reposetory.TravelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private ReservRepository reservRepository;
    @Autowired
    private TravelerRepository travelerRepository;



    public String addReservation(Reservation reserv, Integer key, Integer key2){
        Optional<Traveler> traveler1 = travelerRepository.findById(key);
        Optional<Bus> bus1 = busRepository.findById(key2);
        Traveler existingtraveler = traveler1.get();
        Bus existingbus = bus1.get();

        if(reserv.getJourneyDate().isBefore(LocalDate.now())) return "Please enter future date!";//ok
        if(!existingbus.getBusjourneydate().isEqual(reserv.getJourneyDate())) return"Bus is not available on "+reserv.getJourneyDate();
        if(!reserv.getSource().equalsIgnoreCase(existingbus.getRoutefrom()) || !reserv.getDestination().equalsIgnoreCase(existingbus.getRouteto()))
         return "Bus is not available on route : "+ reserv.getSource()+" - "+reserv.getDestination();
        int seatsAvailable = existingbus.getAvailableseats();
        if(seatsAvailable < reserv.getNoofseatsbooked()) return "Reservation Failed! Available seats:0 ";

        Reservation reservation = new Reservation();

        existingbus.setAvailableseats(seatsAvailable - reserv.getNoofseatsbooked());

        Bus updatedBus =busRepository.save(existingbus);

        reservation.setBus(updatedBus);

        reservation.setReservationstatus("Successfull");
        reservation.setReservationdate(LocalDate.now());
        reservation.setReservationtime(LocalTime.now());
        reservation.setSource(existingbus.getRoutefrom());
        reservation.setDestination(existingbus.getRouteto());
        reservation.setNoofseatsbooked(reserv.getNoofseatsbooked());
        reservation.setFare(existingbus.getFareperseat()*(reserv.getNoofseatsbooked()));
        reservation.setJourneyDate(reserv.getJourneyDate());

        List<Reservation> userReservations =existingtraveler.getReservations();
        userReservations.add(reservation);

        existingtraveler.setReservations(userReservations);

        reservation.setTraveler(existingtraveler);

        Reservation savedReservation = reservRepository.save(reservation);

        if(savedReservation == null) return "Could not reserve the seats";
        return "Reserved Successfully!!";
    }
    public String deleteReservation(Integer reservationId,Integer key)  {

        Optional<Traveler> loggedInUser= travelerRepository.findById(key);
        Traveler existingtraveler = loggedInUser.get();

        if(existingtraveler == null) {
           return "User not found!";
        }


        Optional<Reservation> reserv=reservRepository.findById(reservationId);
        if(reserv.isPresent()) {
            Reservation existingReservation = reserv.get();
            Bus bus = existingReservation.getBus();
            bus.setAvailableseats(bus.getAvailableseats()+existingReservation.getNoofseatsbooked());
            Bus updatedBus =busRepository.save(bus);
            reservRepository.delete(existingReservation);


            return "Deleted Successfully!!";
        }
        else
            return "Reservation doesn't exist with reservationId ";
    }
    public Object viewReservationByUser(Integer key)  {

        Optional<Traveler> traveler1 = travelerRepository.findById(key);
        Traveler existingtraveler = traveler1.get();

        if(existingtraveler == null) {
           return "Please provide a valid key to view reservation!";
        }



        return existingtraveler.getReservations();
    }


}
