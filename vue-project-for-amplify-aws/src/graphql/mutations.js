/* eslint-disable */
// this is an auto generated file. This will be overwritten

export const createTareas = /* GraphQL */ `
  mutation CreateTareas(
    $input: CreateTareasInput!
    $condition: ModelTareasConditionInput
  ) {
    createTareas(input: $input, condition: $condition) {
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
export const updateTareas = /* GraphQL */ `
  mutation UpdateTareas(
    $input: UpdateTareasInput!
    $condition: ModelTareasConditionInput
  ) {
    updateTareas(input: $input, condition: $condition) {
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
export const deleteTareas = /* GraphQL */ `
  mutation DeleteTareas(
    $input: DeleteTareasInput!
    $condition: ModelTareasConditionInput
  ) {
    deleteTareas(input: $input, condition: $condition) {
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
