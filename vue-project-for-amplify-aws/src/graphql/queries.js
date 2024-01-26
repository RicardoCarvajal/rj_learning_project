/* eslint-disable */
// this is an auto generated file. This will be overwritten

export const getTareas = /* GraphQL */ `
  query GetTareas($id: ID!) {
    getTareas(id: $id) {
      id
      puntuacion
      votos {
        puntuacion
        __typename
      }
      nombre
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
      __typename
    }
  }
`;
export const listTareas = /* GraphQL */ `
  query ListTareas(
    $filter: ModelTareasFilterInput
    $limit: Int
    $nextToken: String
  ) {
    listTareas(filter: $filter, limit: $limit, nextToken: $nextToken) {
      items {
        id
        puntuacion
        nombre
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        __typename
      }
      nextToken
      startedAt
      __typename
    }
  }
`;
export const syncTareas = /* GraphQL */ `
  query SyncTareas(
    $filter: ModelTareasFilterInput
    $limit: Int
    $nextToken: String
    $lastSync: AWSTimestamp
  ) {
    syncTareas(
      filter: $filter
      limit: $limit
      nextToken: $nextToken
      lastSync: $lastSync
    ) {
      items {
        id
        puntuacion
        nombre
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        __typename
      }
      nextToken
      startedAt
      __typename
    }
  }
`;
