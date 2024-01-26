import { ModelInit, MutableModel, __modelMeta__, ManagedIdentifier } from "@aws-amplify/datastore";
// @ts-ignore
import { LazyLoading, LazyLoadingDisabled } from "@aws-amplify/datastore";



type EagerUsuario = {
  readonly nombre?: string | null;
  readonly email?: string | null;
}

type LazyUsuario = {
  readonly nombre?: string | null;
  readonly email?: string | null;
}

export declare type Usuario = LazyLoading extends LazyLoadingDisabled ? EagerUsuario : LazyUsuario

export declare const Usuario: (new (init: ModelInit<Usuario>) => Usuario)

type EagerVotos = {
  readonly puntuacion?: number | null;
  readonly usuario?: Usuario | null;
}

type LazyVotos = {
  readonly puntuacion?: number | null;
  readonly usuario?: Usuario | null;
}

export declare type Votos = LazyLoading extends LazyLoadingDisabled ? EagerVotos : LazyVotos

export declare const Votos: (new (init: ModelInit<Votos>) => Votos)

type EagerTareas = {
  readonly [__modelMeta__]: {
    identifier: ManagedIdentifier<Tareas, 'id'>;
    readOnlyFields: 'createdAt' | 'updatedAt';
  };
  readonly id: string;
  readonly puntuacion?: number | null;
  readonly votos?: (Votos | null)[] | null;
  readonly nombre: string;
  readonly createdAt?: string | null;
  readonly updatedAt?: string | null;
}

type LazyTareas = {
  readonly [__modelMeta__]: {
    identifier: ManagedIdentifier<Tareas, 'id'>;
    readOnlyFields: 'createdAt' | 'updatedAt';
  };
  readonly id: string;
  readonly puntuacion?: number | null;
  readonly votos?: (Votos | null)[] | null;
  readonly nombre: string;
  readonly createdAt?: string | null;
  readonly updatedAt?: string | null;
}

export declare type Tareas = LazyLoading extends LazyLoadingDisabled ? EagerTareas : LazyTareas

export declare const Tareas: (new (init: ModelInit<Tareas>) => Tareas) & {
  copyOf(source: Tareas, mutator: (draft: MutableModel<Tareas>) => MutableModel<Tareas> | void): Tareas;
}