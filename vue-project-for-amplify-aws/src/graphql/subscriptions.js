/* eslint-disable */
// this is an auto generated file. This will be overwritten

export const onCreateTareas = /* GraphQL */ `
  subscription OnCreateTareas($filter: ModelSubscriptionTareasFilterInput) {
    onCreateTareas(filter: $filter) {
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
export const onUpdateTareas = /* GraphQL */ `
  subscription OnUpdateTareas($filter: ModelSubscriptionTareasFilterInput) {
    onUpdateTareas(filter: $filter) {
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
export const onDeleteTareas = /* GraphQL */ `
  subscription OnDeleteTareas($filter: ModelSubscriptionTareasFilterInput) {
    onDeleteTareas(filter: $filter) {
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
