package com.kdu.smartHome.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
      @Id
      private long kickstonId;
      private String username;
      private String password;
      private Timestamp manufactureDateTime;
      private String manufacturePlace;
      private Boolean verified;

}
