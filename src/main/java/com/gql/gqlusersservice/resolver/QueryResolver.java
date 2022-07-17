package com.gql.gqlusersservice.resolver;

import com.gql.gqlusersservice.domain.User;
import graphql.kickstart.tools.GraphQLQueryResolver;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;

import static com.gql.gqlusersservice.util.Constants.USER_ENDPOINT;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    public User user(Integer id) {
        User user = Unirest.get(USER_ENDPOINT).routeParam("id", String.valueOf(id)).asObject(User.class).getBody();
        user.getAddress().setUserId(id);
        return user;
    }
}
