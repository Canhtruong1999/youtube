<<<<<<< HEAD
package com.example.youtube.repository;

import com.example.youtube.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Integer> {
    Tag findById(int id);

}
=======
package com.example.youtube.repository;

import com.example.youtube.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Integer> {
    Tag findById(int id);

}
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630
