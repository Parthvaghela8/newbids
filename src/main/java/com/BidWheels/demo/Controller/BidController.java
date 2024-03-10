package com.BidWheels.demo.Controller;


import com.BidWheels.demo.Model.Bids;
import com.BidWheels.demo.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping("/getdata")
    public ResponseEntity<List<Bids>> getAllBids() {
        List<Bids> bids = bidService.getAllBids();
        return ResponseEntity.ok(bids);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bids> getBidById(@PathVariable Long id) {
        Bids bid = bidService.getBidById(id);

        if (bid != null) {
            return ResponseEntity.ok(bid);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Bids> createBid(@RequestBody Bids bid) {
        Bids createdBid = bidService.createBid(bid);
        return ResponseEntity.ok(createdBid);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bids> updateBid(@PathVariable Long id, @RequestBody Bids updatedBid) {
        Bids bid = bidService.updateBid(id, updatedBid);

        if (bid != null) {
            return ResponseEntity.ok(bid);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBid(@PathVariable Long id) {
        bidService.deleteBid(id);
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/insertBid")
//    public ResponseEntity<Object> insertBid(
//            @RequestParam Long shipmentId,
//            @RequestParam Long shipperId,
//            @RequestParam BigDecimal bidAmount,
//            @RequestParam String bidStatus,
//            @RequestParam LocalDateTime bidTime) {
//        bidService.insertBid(shipmentId, shipperId, bidAmount, bidStatus, bidTime);
//        return ResponseEntity.ok().build();
//    }
}
