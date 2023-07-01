import { Component } from '@angular/core';
import { People } from './people.model'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Proyecto de pruebas en Angular';
  isDisable = true;
  progreso = 0;

  persona = {
    nombre: "Ricardo",
    apellido: "Carvajal",
    edad: 39
  }

  names:string[] = ['Ricardo', 'Angelica', 'Miguel'];
  newName: string = '';

  peopleArray: People[] = [
    {
        firstname: 'Freddy',
        lastname: 'Vega',
        age: 35
    },
    {
        firstname: 'Nicolas',
        lastname: 'Molina',
        age: 29
    },
    {
        firstname: 'Ángela',
        lastname: 'Ocando',
        age: 30
    }
  ];

  toggleButton() {
    this.isDisable = !this.isDisable;
  }

  aumentoEdad() {
    this.persona.edad = ++this.persona.edad;
  }

  aumentoProgreso() {
    this.progreso = ++this.progreso;
  }

  onScroll(event: Event) {
    const element = event.target as HTMLElement;
    console.log(element.scrollTop);
  }

  changeName(event: Event) {
    const element = event.target as HTMLInputElement;
    this.persona.nombre = element.value;
  }

  addName(){
    this.names.push(this.newName);
  }

  deleteName(index:number){
    this.names.splice(index,1);
  }



}
