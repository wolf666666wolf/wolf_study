<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>

<xsl:template match="/">
	<html>
	<head>
		<title>
			<xsl:value-of select="reference/body/title"/>
		</title>
	</head>
	<body>
		<xsl:apply-templates select="reference/body"/>

	</body>
	</html>
</xsl:template>
<xsl:template match="title">
<h1>
<xsl:value-of select="."/>
</h1>
</xsl:template>
<xsl:template match="purpose">
<h2>Purpose</h2>
<xsl:apply-templates select="p"/>
</xsl:template>
<xsl:template match="usage">
<h2>Usage</h2>
<xsl:apply-templates select="p"/>
</xsl:template>
<xsl:template match="p">
<p>
<xsl:apply-templates/>
</p>
</xsl:template>
<xsl:template match="attr | element">
<code>
<xsl:value-of select="."/>
</code>
</xsl:template>
<xsl:template match="element" mode="index">
<ul>
<xsl:for-each select=".">
<li>
<xsl:value-of select="."/>
</li>
</xsl:for-each>
</ul>
</xsl:template>
<xsl:template match="code">
<xsl:copy-of select="."/>
</xsl:template>
</xsl:stylesheet>