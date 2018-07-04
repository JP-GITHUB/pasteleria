package com.jp.pasteleria.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.pasteleria.beans.AppConfig;
import com.jp.pasteleria.exception.ResourceNotFoundException;
import com.jp.pasteleria.model.Document;
import com.jp.pasteleria.pasteleria.PasteleriaApplication;
import com.jp.pasteleria.repository.DocumentRepository;

@RestController
@RequestMapping("/api")
public class DocumentController {
	public static final Logger logger = LoggerFactory.getLogger(PasteleriaApplication.class);
		
	@Autowired
	DocumentRepository documentRepository;
	
	@GetMapping("/documents")
	public List<Document> getAllDocuments() {
		return documentRepository.findAll();
	}
}