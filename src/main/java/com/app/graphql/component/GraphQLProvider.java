package com.app.graphql.component;

import graphql.GraphQL;
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

@Configuration
public class GraphQLProvider {

    @Autowired
    private GraphQLDataFetchers graphQLDataFetchers;

    @Autowired
    ResourceLoader resourceLoader;

    @Bean
    public GraphQLSchema schema() throws IOException {

        SchemaParser schemaParser = new SchemaParser();
        SchemaGenerator schemaGenerator = new SchemaGenerator();

        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(resourceLoader.getResource("classpath:schema.graphqls").getFile());
        RuntimeWiring wiring = buildRuntimeWiring();

        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, wiring);
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query")
                        .dataFetcher("cityById", graphQLDataFetchers.getCityDataFetcher())
                ).build();
    }
}
