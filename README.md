# spring-graphql-example

## Domain:

- Shop with Users that have Mail-Addresses
- check out schema.graphql in src/man/resources (like OpenAPI spec in REST)
- DTO java objects will be generated from schema via maven plugin

## Implementation:

- Controller to handle request (like RestController)
- @QueryMapping to get data, e.g. via graphiql ui (enable in application.yaml)
- @SchemaMapping to load additional properties
- virtual threads to load in parallel (enable in application.yaml)
- @BatchMapping to avoid n+1 problem of @SchemaMapping

## Based on:

Dan Vega:
- [Playlist GraphQL](https://www.youtube.com/playlist?list=PLZV0a2jwt22slmUC9iwGGWfRQRIhs1ELa)
- [Does Your API Need A REST? Check Out GraphQL](https://www.youtube.com/watch?v=tMPC-u891XA&t=1s)
- https://github.com/danvega/graphql-books
- https://github.com/danvega/graphql-store

Spring Conferences:
- [GraphQL Java and Spring: The Latest Features by Rossen Stoyanchev @ Spring I/O 2024](https://www.youtube.com/watch?v=_l4Dykjezjk)
- https://github.com/rstoyanchev/spring-graphql-activity
- [Build GraphQL Services With Spring Boot Like Netflix (SpringOne 2024)](https://www.youtube.com/watch?v=DYZEkOsiPY0&t=866s)
- [Learnings From Netflix To Effective Testing With Spring Boot (SpringOne 2024)](https://www.youtube.com/watch?v=2bTAb-2vhBk)

Spring Docs:
- https://github.com/spring-projects/spring-graphql-examples
