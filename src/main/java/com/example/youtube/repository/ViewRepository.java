<<<<<<< HEAD
package com.example.youtube.repository;

import com.example.youtube.model.Video;
import com.example.youtube.model.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewRepository extends JpaRepository<View,Integer> {
    int countByVideoId(int videoId);
}
=======
package com.example.youtube.repository;

import com.example.youtube.model.Video;
import com.example.youtube.model.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewRepository extends JpaRepository<View,Integer> {


}
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630
