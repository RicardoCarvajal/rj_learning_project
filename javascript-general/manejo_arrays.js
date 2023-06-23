var articulos = [
      { nombre: "Bici", costo: 3000 },
      { nombre: "TV", costo: 2500 },
      { nombre: "Libro", costo: 320 },
      { nombre: "Celular", costo: 10000 },
      { nombre: "Laptop", costo: 20000 },
      { nombre: "Teclado", costo: 500 },
      { nombre: "Audifonos", costo: 1700 },
]


var articulosFiltrados = articulos.filter((articulo) => {
      return articulo.costo <= 500;
});

console.log(articulosFiltrados);

var articulosNombre = articulos.map((articulo) => {
      return articulo.nombre;
});

console.log(articulosNombre);

var articuloBuscado = articulos.find((articulo) => {
      return articulo.nombre === "Bici";
});

console.log(articuloBuscado);

articulos.forEach((articulo) => {
      console.log(articulo.nombre);
});


var articulosBaratos = articulos.some((articulo) => {
      return articulo.costo <= 700;
});

console.log(articulosBaratos);


const cars = [
      {
            color: 'red',
            brand: 'Kia',
      },
      {
            color: 'gray',
            brand: 'Chevrolet',
            licensePlate: 'AAA111',
      },
      {
            licensePlate: 'RGB255',
      },
];

function solution(cars) {
      return cars.filter(function (car) {
            if (car.licensePlate) {
                  return true;
            } else {
                  return false;
            }
      });
}

console.log(solution(cars));



