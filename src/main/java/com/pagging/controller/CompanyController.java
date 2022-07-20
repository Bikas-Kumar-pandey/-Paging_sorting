package com.pagging.controller;

import com.pagging.entity.CompanyEntity;
import com.pagging.reposotories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CompanyController {


    @Autowired
    private CompanyRepository repo;


    @Test
    @PostMapping("/save")
    public String saveData(@RequestBody CompanyEntity companyEntity, Pageable pageable) {
        repo.save(companyEntity);
        return "Saved!!";
    }

@GetMapping("/getdata")
    public Page<CompanyEntity> getAllEmployees(@RequestParam(value = "pNo",defaultValue = "0")Integer pNo,
 @RequestParam(value = "pSize",defaultValue = "5") int pSize, @RequestParam(value = "sortBy",defaultValue = "id")String sortBy) {

        Pageable paging = PageRequest.of(pNo, pSize, Sort.by(sortBy).descending());
        Page<CompanyEntity> pagedResult = repo.findAll(paging);
        return pagedResult;
    }

}