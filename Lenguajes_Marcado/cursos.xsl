<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html" indent="yes"/>

    <xsl:template match="/">

        <html>
            <head>
                <title>Oferta formativa</title>
            </head>

            <body>
                <!--Encabezado principal de la web-->
                <h1>Oferta formativa de cursos para elegir</h1>

                <!--Texto introductorio-->
                <p>
                    Esta es la lista de cursos en los que te puedes matricular
                </p>

                <!--Creamos la tabla con la información-->
                <table border="1" cellpadding="5">
                    <tr>
                        <th>Nombre del curso</th>
                        <th>Horas</th>
                        <th>Nivel</th>
                    </tr>
                    <xsl: for.each select="cursos/curso">
                        <tr>
                            <td>
                                <xsl:value-of select="nombre"/>
                            </td>
                            <td>
                                <xsl:value-of select="horas"/>
                            </td>
                            <td>
                                <xsl:value-of select="nivel"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>


                                