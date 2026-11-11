"use strict";

const productos = [
  { 
    id: "guantes",
    nombre: "Guantes de cuero",
    categoria: "Equipo de protección",
    imagen: "img/guantesCuero.jpg",
    textoAlternativo: "Guantes de cuero",
    descripcion: "Guantes de cuero resistentes para proteger tus manos durante el trabajo.",
    precio: 25.99,
    tallas: ["S", "M", "L", "XL"],
    caracteristicas: ["Material: Cuero", "Talla: S, M, L, XL", "Color: Negro"],
  },

    { id: "botas",
    nombre: "Botas de cuero",
    categoria: "Equipo de protección",
    imagen: "img/botaCuero.jpg",
    textoAlternativo: "Botas de cuero",
    descripcion: "Botas de cuero resistentes para proteger tus pies durante el trabajo.",
    precio: 49.99,
    tallas: ["36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46"],
    caracteristicas: ["Material: Cuero", "Talla: 36 al 46 EU", "Color: Negro"],
  },
];

const catalogo = document.querySelector("#catalogo");
const formatoPrecio = new Intl.NumberFormat("es-ES", {
  style: "currency",
  currency: "EUR"
});

function crearTarjeta(producto) {
  const tarjeta = document.createElement("article");
  tarjeta.className = "tarjeta";
  tarjeta.dataset.producto = producto.id;

  const imagen = document.createElement("div");
  imagen.className = "imagen-producto";
  imagen.innerHTML = `<img src="${producto.imagen}" alt="${producto.textoAlternativo}" loading="lazy">`;

  const contenido = document.createElement("div");
  contenido.className = "contenido-tarjeta";
  contenido.innerHTML = `
    <p class="categoria">${producto.categoria}</p>
    <h2>${producto.nombre}</h2>
    <p class="descripcion">${producto.descripcion}</p>
    <p class="precio">${formatoPrecio.format(producto.precio)}</p>
    <div class="acciones">
      <button class="boton boton-secundario" type="button" data-accion="detalles" aria-expanded="false">Ver más</button>
      <button class="boton boton-principal" type="button" data-accion="comprar">Comprar</button>
    </div>
    <section class="detalles" hidden aria-label="Información adicional">
      <h3>Características</h3>
      <ul>${producto.caracteristicas.map(caracteristica => `<li>${caracteristica}</li>`).join("")}</ul>
      <form class="formulario">
        <label class="campo">Cantidad
          <input name="cantidad" type="number" min="1" max="8" value="1" required>
        </label>
        <label class="campo">Método de pago simulado
          <select name="pago" required>
            <option value="">Elige una opción</option>
            <option value="tarjeta">Tarjeta de prueba</option>
            <option value="transferencia">Transferencia simulada</option>
          </select>
        </label>
         <label class="campo">talla
          <select name="talla" required>
            <option value="">Elige una opción</option>
            ${producto.tallas.map(talla => `
             <option value="${talla}">${talla}</option>
           `).join("")}
          </select>
        </label>
        <button class="boton boton-principal" type="submit">Validar pedido</button>
        <p class="mensaje" aria-live="polite"></p>
      </form>
    </section>`;

  tarjeta.append(imagen, contenido);
  return tarjeta;
}

productos.forEach(producto => catalogo.append(crearTarjeta(producto)));

catalogo.addEventListener("click", evento => {
  const boton = evento.target.closest("button[data-accion]");
  if (!boton) return;

  const tarjeta = boton.closest(".tarjeta");
  if (boton.dataset.accion === "detalles") {
    const panel = tarjeta.querySelector(".detalles");
    const abrir = panel.hidden;
    panel.hidden = !abrir;
    boton.setAttribute("aria-expanded", String(abrir));
    boton.textContent = abrir ? "Ver menos" : "Ver más";
    if (abrir) panel.querySelector("input").focus();
  }

  if (boton.dataset.accion === "comprar") {
    const producto = productos.find(elemento => elemento.id === tarjeta.dataset.producto);
    const deseaComprar = window.confirm(`Vas a simular la compra de ${producto.nombre} por ${formatoPrecio.format(producto.precio)}. ¿Continuar?`);
    if (deseaComprar) {
      const mensaje = tarjeta.querySelector(".mensaje");
      mensaje.textContent = "Compra de demostración confirmada. No se ha realizado ningún pago.";
      tarjeta.querySelector(".detalles").hidden = false;
      const botonDetalles = tarjeta.querySelector('[data-accion="detalles"]');
      botonDetalles.setAttribute("aria-expanded", "true");
      botonDetalles.textContent = "Ver menos";
    }
  }
});

catalogo.addEventListener("submit", evento => {
  if (!evento.target.matches(".formulario")) return;
  evento.preventDefault();

  const formulario = evento.target;
  if (!formulario.reportValidity()) return;

  const datos = new FormData(formulario);
  const cantidad = Number(datos.get("cantidad"));
  const metodoPago = datos.get("pago");
  const talla = datos.get("talla");
  const producto = productos.find(elemento => elemento.id === formulario.closest(".tarjeta").dataset.producto);
  const total = formatoPrecio.format(producto.precio * cantidad);
  formulario.querySelector(".mensaje").textContent = `Pedido válido: ${cantidad} × ${producto.nombre} · Total ${total} · Pago: ${metodoPago} · Talla: ${talla}. Simulación, sin cargo.`;
});
