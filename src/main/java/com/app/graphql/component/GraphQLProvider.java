package com.app.graphql.component;

import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @Autowired
    private GraphQLDataFetchers graphQLDataFetchers;

    @Autowired
    ResourceLoader resourceLoader;

    @PostConstruct
    public void init() throws IOException {

        SchemaParser schemaParser = new SchemaParser();
        SchemaGenerator schemaGenerator = new SchemaGenerator();

        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(resourceLoader.getResource("classpath:schema.graphqls").getFile());
        RuntimeWiring wiring = buildRuntimeWiring();

        this.graphQL = GraphQL
                .newGraphQL(schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, wiring)).build();

    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query")
                        .dataFetchers(dataFetcherBuild())
                ).build();
    }

    private Map<String, DataFetcher> dataFetcherBuild() {
        Map<String, DataFetcher> map = new HashMap<>();
        map.put("cityById", graphQLDataFetchers.getCityDataFetcher());
        map.put("countryByCode", graphQLDataFetchers.getCountryDataFetcher());
        return map;
    }
}
