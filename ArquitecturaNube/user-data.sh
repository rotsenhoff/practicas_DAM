#!/bin/bash
# AN · Clase 5 · bootstrapping
# Se pega en la consola:  Lanzar instancia -> Detalles avanzados -> Datos de usuario
# Se ejecuta UNA sola vez, como root, en el primer arranque.

NOMBRE="NESTOR"        # <-- CAMBIA ESTO POR TU NOMBRE

# Esperar a que unattended-upgrades suelte el candado de apt.
# Sin esto, el apt install falla en silencio en una maquina recien creada.
while fuser /var/lib/dpkg/lock-frontend >/dev/null 2>&1; do sleep 5; done

apt update -y
apt install -y apache2

cat > /var/www/html/index.html <<HTML
<h1>Servidor de $NOMBRE</h1>
<p>Nadie ha entrado en esta maquina.</p>
<p>Maquina: $(hostname)</p>
<p>Montada sola el $(date)</p>
HTML

systemctl enable --now apache2
