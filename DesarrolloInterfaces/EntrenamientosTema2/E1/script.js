/*Este script sirve para gestionar una lista de tareas */

"use strict";

const lista = document.querySelector("#lista");
const botonAnadir = document.querySelector("#anadir");
const botonEliminar = document.querySelector("#eliminar");
const estado = document.querySelector("#estado");
let numeroTarea = lista.children.length + 1;

function actualizarEstado() {
  const cantidad = lista.children.length;
  estado.textContent = cantidad === 1 ? "Hay 1 tarea" : `Hay ${cantidad} tareas.`;
  botonEliminar.disabled = cantidad === 0;
}


function anadirTarea() {
  const nuevaTarea = document.createElement("li");
  nuevaTarea.textContent = `Nueva tarea ${numeroTarea}`;
  lista.appendChild(nuevaTarea);
  numeroTarea += 1;
  actualizarEstado();
}

function eliminarUltimaTarea() {
    
    const ultimaTarea = lista.lastElementChild;

    if (ultimaTarea === null) return;
    lista.removeChild(ultimaTarea);
    actualizarEstado();
  }

  botonAnadir.addEventListener("click", anadirTarea);
  botonEliminar.addEventListener("click", eliminarUltimaTarea);
  actualizarEstado();