package com.BidWheels.demo.Controller;

<<<<<<< HEAD

=======
>>>>>>> dev
import com.BidWheels.demo.Model.Bids;
import com.BidWheels.demo.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
=======
import java.util.List;

@RestController

>>>>>>> dev
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping("/getdata")
    public ResponseEntity<List<Bids>> getAllBids() {
<<<<<<< HEAD
        List<Bids> bids = bidService.getAllBids();
        return ResponseEntity.ok(bids);
=======
        try {
            List<Bids> bids = bidService.getAllBids();
            return ResponseEntity.ok(bids);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Internal Server Error
        }
>>>>>>> dev
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bids> getBidById(@PathVariable Long id) {
<<<<<<< HEAD
        Bids bid = bidService.getBidById(id);

        if (bid != null) {
            return ResponseEntity.ok(bid);
        } else {
            return ResponseEntity.notFound().build();
=======
        try {
            Bids bid = bidService.getBidById(id);
            if (bid != null) {
                return ResponseEntity.ok(bid);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Internal Server Error
>>>>>>> dev
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Bids> createBid(@RequestBody Bids bid) {
<<<<<<< HEAD
        Bids createdBid = bidService.createBid(bid);
        return ResponseEntity.ok(createdBid);
=======
        try {
            Bids createdBid = bidService.createBid(bid);
            return ResponseEntity.ok(createdBid);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Internal Server Error
        }
>>>>>>> dev
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bids> updateBid(@PathVariable Long id, @RequestBody Bids updatedBid) {
<<<<<<< HEAD
        Bids bid = bidService.updateBid(id, updatedBid);

        if (bid != null) {
            return ResponseEntity.ok(bid);
        } else {
            return ResponseEntity.notFound().build();
=======
        try {
            Bids bid = bidService.updateBid(id, updatedBid);
            if (bid != null) {
                return ResponseEntity.ok(bid);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Internal Server Error
>>>>>>> dev
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBid(@PathVariable Long id) {
<<<<<<< HEAD
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
=======
        try {
            bidService.deleteBid(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Internal Server Error
        }
    }
>>>>>>> dev
}
