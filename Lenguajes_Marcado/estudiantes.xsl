<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html" indent="yes"/>

<xsl:template match="/">

    <html>

        <head>
            <title>Estudiantes que han aprobado</title>
        </head>

        <body>
            <h1>Listado de estudiantes que han aprobado la asignatura</h1>

            <p>
                Este es un listado en el que saldrás si has aprobado
                Mucha suerte XD
            </p>

            <ul>

                <xsl:for-each select="estudiantes/estudiante">

                    <xsl:if test="nota &gt; 5">

                        <li>
                            <strong>
                                <xsl:value-of select="nombre"/>
                            </strong>
                            -
                            <xsl:value-of select="nota"/>
                            -
                            <xsl:value-of select="curso"/>
                        </li>
                    </xsl:if>
                </xsl:for-each>
            </ul>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>
