package com.gql.gqlusersservice.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Address {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;
}
