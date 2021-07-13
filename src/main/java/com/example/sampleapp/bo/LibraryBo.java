package com.example.sampleapp.bo;

import com.example.sampleapp.criteria.LibraryCriteria;
import com.example.sampleapp.dao.LibraryDao;
import com.example.sampleapp.model.Library;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryBo {

    @Autowired
    LibraryDao librarysDao;

    public List<Library> getAllRecords() {
        List<Library> librarys = new ArrayList<>();
        librarysDao.findAll().forEach(b -> librarys.add(b));
        return librarys;
    }

    public List<Library> getAllMatching(LibraryCriteria criteria) {
        List<Library> librarys = getAllRecords();
        if (criteria.getCity() != null) {
            librarys = librarys.stream().filter(b -> StringUtils.equals(b.getCity(), criteria.getCity())).collect(Collectors.toList());
        }

        if (criteria.getAddress() != null) {
            librarys = librarys.stream().filter(b -> StringUtils.equals(b.getAddress1(), criteria.getAddress())).collect(Collectors.toList());
        }

        return librarys;
    }

    public Library getRecord(int id) {
        return librarysDao.findById(id).get();
    }

    public void saveOrUpdate(Library librarys) {
        librarysDao.save(librarys);
    }

    public void delete(int id) {
        librarysDao.deleteById(id);
    }

    public void update(Library librarys, int libraryid) {
        librarysDao.save(librarys);
    }
}
