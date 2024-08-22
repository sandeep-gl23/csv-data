package com.example.csv_data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Document(collection = "csv_data")
public class Model {
    @Id
    String id;

    String name;
    String email;
    String destination;

}
