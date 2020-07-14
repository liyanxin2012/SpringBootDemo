package com.lyx.demo.access.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ryan
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

}
