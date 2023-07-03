package com.ld.digitallibrary.repo;

import com.ld.digitallibrary.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllItemsByUserId(Long userId);
}

