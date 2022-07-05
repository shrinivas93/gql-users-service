package com.gql.gqlusersservice.resolver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gql.gqlusersservice.domain.Post;
import com.gql.gqlusersservice.domain.User;
import graphql.kickstart.tools.GraphQLResolver;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gql.gqlusersservice.util.Constants.POSTS_ENDPOINT;

//@Component
public class UserResolver implements GraphQLResolver<User> {

    public List<Post> posts(User user) {
        // curl 'http://localhost:8002/graphql'
        // -H 'Accept-Encoding: gzip, deflate, br'
        // -H 'Content-Type: application/json'
        // -H 'Accept: application/json'
        // -H 'Connection: keep-alive'
        // -H 'DNT: 1'
        // -H 'Origin: http://localhost:8002'
        // --data-binary '{"query":"query {\n  posts(where: {userId: 1}) {\n    id\n    userId\n    title\n    body\n  }\n}"}' --compressed

        Map<String, String> query = new HashMap<>();
        query.put("query", "query {posts(where: {userId: "+user.getId()+"}) {id userId title body } }");
        ObjectMapper objectMapper = new ObjectMapper();
        String queryString;
        try {
            queryString = objectMapper.writeValueAsString(query);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        List<Post> posts = null;
        try {
            posts = objectMapper.readValue(Unirest.post(POSTS_ENDPOINT).body(queryString).header("Content-Type", "application/json").asJson().getBody().getObject().getJSONObject("data").getJSONArray("posts").toString(), new TypeReference<List<Post>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }

}
