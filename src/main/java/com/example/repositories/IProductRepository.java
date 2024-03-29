package com.example.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Genre;
import com.example.entities.Language;
import com.example.entities.Product;
import com.example.entities.ProductType;
import com.example.entities.Publisher;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product,Integer> {
	@Query("SELECT p FROM Product p WHERE p.productId = :id")
    Product getById(int id);
    
	@Query(value = "SELECT * FROM Product p WHERE p.type_id = :typeId", nativeQuery = true)
    List<Product> findByProductType(@Param("typeId") int typeId);
	//    @Modifying
//    @Query("UPDATE Product p SET p.productName = :productName, p.productEngName = :productEngName, " +
//            "p.typeId = :typeId, p.basePrice = :basePrice, p.specialCost = :specialCost, p.offerPrice = :offerPrice, " +
//            "p.offerExpDate = :offerExpDate, p.shortDesc = :shortDesc, p.longDesc = :longDesc, p.ISBN = :ISBN, " +
//            "p.author = :author, p.publisher = :publisher, p.languageId = :languageId, p.genreId = :genreId, " +
//            "p.isRentable = :isRentable, p.isLibrary = :isLibrary, p.rentPerDay = :rentPerDay, p.minRentDays = :minRentDays " +
//            "WHERE p.productId = :productId")
//    void updateProduct(
//            String productName, String productEngName, ProductType typeId, float basePrice, float specialCost, float offerPrice,
//            Date offerExpDate, String shortDesc, String longDesc, String ISBN, String author, Publisher publisher,
//            Language languageId, Genre genreId, boolean isRentable, boolean isLibrary, float rentPerDay, int minRentDays, int productId);
}
