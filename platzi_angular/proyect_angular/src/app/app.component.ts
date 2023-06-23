import { Component } from '@angular/core';


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




}
