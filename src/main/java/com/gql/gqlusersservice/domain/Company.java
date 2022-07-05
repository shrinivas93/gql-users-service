package com.gql.gqlusersservice.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Company {
    String name;
    String catchPhrase;
    String bs;
}
