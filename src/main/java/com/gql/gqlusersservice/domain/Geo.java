package com.gql.gqlusersservice.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Geo {
    String lat;
    String lng;
}
