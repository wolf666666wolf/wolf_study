<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	

<xsl:template match="/">
			<xsl:apply-templates/>
</xsl:template>
<xsl:template match="examples">
	<h2>Example<xsl:if test="count(codeblock) gt 1">s</xsl:if></h2>
	<xsl:apply-templates/>
</xsl:template>
<xsl:template match="codeblock">
	<pre class="code">
			<xsl:value-of select="."/>
	</pre>
</xsl:template>

</xsl:stylesheet>


