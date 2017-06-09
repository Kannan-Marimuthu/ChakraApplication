package com.chakra.root.hrm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chakra.root.hrm.service.PagesService;

@RestController
@RequestMapping("/api")
public class PageController {

	public static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	PagesService pagesService;
}
