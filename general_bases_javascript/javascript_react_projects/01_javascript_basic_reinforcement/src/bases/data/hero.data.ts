type TOwner = 'DC' | 'Marvel'// Los type son reglas de valores

//Los enum si son un objeto con una extructura de datos
//Los valores por defecto son 0
// Y uno pero esto se puede cambiar con el signo de igual para indicar el valor
export enum Onwer { 
    DC = 'DC',
    Marvel = 'Marvel'
} 

export interface Hero {
    id: number;
    name:string;
    owner:Onwer;
}


export const heroes: Hero[] = [// se puede hacer una exportacion directa (opcion preferida)
  {
    id: 1,
    name: 'Batman',
    owner: Onwer.DC,
  },
  {
    id: 2,
    name: 'Spiderman',
    owner: Onwer.Marvel,
  },
  {
    id: 3,
    name: 'Superman',
    owner: Onwer.DC,
  },
  {
    id: 4,
    name: 'Flash',
    owner: Onwer.DC,
  },
  {
    id: 5,
    name: 'Wolverine',
    owner: Onwer.Marvel,
  },
];

export default heroes; // Se puede hacer una exportacion por defecto tambien 