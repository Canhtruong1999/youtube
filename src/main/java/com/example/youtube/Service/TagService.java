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
>>>>>>> 7190cba0e363ca23a9167210c16bff37f263ea00
