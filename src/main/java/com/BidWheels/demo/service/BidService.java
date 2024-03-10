package com.BidWheels.demo.service;


import com.BidWheels.demo.Model.Bids;
import com.BidWheels.demo.Repositry.BidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BidService {

    @Autowired
    private BidsRepository bidRepository;

    public List<Bids> getAllBids() {
        return bidRepository.findAll();
    }

    public Bids getBidById(Long id) {
        return bidRepository.findById(id).orElse(null);
    }

    public Bids createBid(Bids bid) {
        return bidRepository.save(bid);
    }

    public Bids updateBid(Long id, Bids updatedBid) {
        Bids existingBid = bidRepository.findById(id).orElse(null);

        if (existingBid != null) {
            // Update existingBid with values from updatedBid
            existingBid.setShipmentId(updatedBid.getShipmentId());
            existingBid.setShipperId(updatedBid.getShipperId());
            existingBid.setBidAmount(updatedBid.getBidAmount());
            existingBid.setBidStatus(updatedBid.getBidStatus());
            existingBid.setBidTime(updatedBid.getBidTime());

            return bidRepository.save(existingBid);
        } else {
            // Handle bid not found
            return null;
        }
    }

    public void deleteBid(Long id) {
        bidRepository.deleteById(id);
    }
//    public void insertBid(Long shipmentId, Long shipperId, BigDecimal bidAmount, String bidStatus, LocalDateTime bidTime) {
//        bidRepository.insertBid(shipmentId, shipperId, bidAmount, bidStatus, bidTime);
//    }
}
