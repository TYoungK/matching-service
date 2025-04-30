package com.taekyoungk.matching_service.domain.coupon.entity;

import java.time.LocalDate;

import com.taekyoungk.matching_service.domain.user.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Coupon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(nullable = false, columnDefinition = "TINYINT")
    private byte discountPercent;
    private int maxDiscountCost;
    @Column(nullable = false)
    private LocalDate expirationDate;

    public Coupon() {
    }

    public Coupon(User user, byte discountPercent, int maxDiscountCost, LocalDate expirationDate) {
        this.user = user;
        this.discountPercent = discountPercent;
        this.maxDiscountCost = maxDiscountCost;
        this.expirationDate = expirationDate;
    }

    public int getIdx() {
        return idx;
    }

    public User getUser() {
        return user;
    }

    public byte getDiscountPercent() {
        return discountPercent;
    }

    public int getMaxDiscountCost() {
        return maxDiscountCost;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

}
