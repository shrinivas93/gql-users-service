package com.gql.gqlusersservice.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class User {
    Integer id;
    String name;
    String username;
    String email;
    String phone;
    String website;
    Company company;
    Address address;
}
