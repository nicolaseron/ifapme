package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

  private final JdbcTemplate jdbcTemplate;

  public TestController(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @GetMapping("/{username}")
  public Object test(@PathVariable String username) {
    String query = "SELECT * FROM personne WHERE username = ?";
    return jdbcTemplate.queryForList(query, username);
  }

}
