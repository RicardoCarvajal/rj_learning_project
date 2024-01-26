// @ts-check
import { initSchema } from '@aws-amplify/datastore';
import { schema } from './schema';



const { Tareas, Usuario, Votos } = initSchema(schema);

export {
  Tareas,
  Usuario,
  Votos
};