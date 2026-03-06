<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="url">

<xsl: output method="html" indent="yes" encoding="UTF-8"/>

<xml: template match="/">

    <catalogo>
        <xsl: for-each select="catalogo/producto">
            <producto>
                <codigo>
                    <xsl: value-of select="@codigo"/>
                </codigo>
                <nombre>
                    <xsl: value-of select="@nombre"/>
                </nombre>
                <precio>
                    <xsl: value-of select="@precio"/>
                </precio>
                <categoria>
                    <xsl: value-of select="@categoria"/>
                </categoria>
            </producto>
        </xsl: for-each>
    </catalogo>
</xsl: template>
</xsl:stylesheet>
