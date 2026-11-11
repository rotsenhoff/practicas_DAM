/*Este script permite alternar la visibilidad de un elemento de información y actualizar el texto del botón correspondiente*/

"use strict";

const botonAlternar = document.querySelector("#botonAlternar");
const informacion = document.querySelector("#informacion");

function alternarInformacion() {
    const quedaraVisible = informacion.hidden;
    informacion.hidden = !quedaraVisible;
    botonAlternar.textContent = quedaraVisible
        ? "Ocultar información"
        : "Mostrar información";
    botonAlternar.setAttribute("aria-expanded", String(quedaraVisible));
}

botonAlternar.addEventListener("click", alternarInformacion);