package com.iceberry.starterDemo.repository;

import com.iceberry.starterDemo.model.jpa.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    @Override
    @Transactional
    @Query(value = "SELECT id, author_name, cover_img_url, created_at, deleted_at, isbn, name, page_count, publish_date, publisher_name, updated_at FROM tb_book_info where deleted_at IS NULL", nativeQuery = true)
    Page<BookEntity> findAll(Pageable pageable);
}
