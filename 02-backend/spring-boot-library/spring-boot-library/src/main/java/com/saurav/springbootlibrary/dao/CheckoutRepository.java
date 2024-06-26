package com.saurav.springbootlibrary.dao;

import com.saurav.springbootlibrary.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CheckoutRepository extends JpaRepository<Checkout,Long> {
    Checkout findByUserEmailAndBookId(String userEmail , Long bookId);

    List<Checkout> findBookByUserEmail(String userEmail);


    @Modifying
    @Query("delete from Checkout where book_id in :book_id")
    void deleteAllByBookId(@Param("book_id") Long bookId);

}
