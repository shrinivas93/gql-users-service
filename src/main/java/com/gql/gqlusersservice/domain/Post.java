package com.gql.gqlusersservice.domain;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    Integer id;
    Integer userId;
    String title;
    String body;
}
