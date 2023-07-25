<<<<<<< HEAD
package com.example.youtube.Service;

import com.example.youtube.model.Tag;
import com.example.youtube.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    public List<Tag> findAll(){
        return tagRepository.findAll();
    }
    public Tag findById(int id){
       return tagRepository.findById(id);
    }

}
=======
<<<<<<< HEAD
package com.example.youtube.service;

import com.example.youtube.model.Tag;
import com.example.youtube.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    public List<Tag> findAll(){
        return tagRepository.findAll();
    }
    public Tag findById(int id){
       return tagRepository.findById(id);
    }

}
=======
package com.example.youtube.service;

import com.example.youtube.model.Tag;
import com.example.youtube.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    public List<Tag> findAll(){
        return tagRepository.findAll();
    }
    public Tag findById(int id){
       return tagRepository.findById(id);
    }

}
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630
>>>>>>> 4d72a10a6ea817d7aa0c72e78955ea98495048e1
