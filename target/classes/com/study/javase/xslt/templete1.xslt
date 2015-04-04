<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="html" version="1.0" encoding="GB2312" indent="yes"/>
	   <xsl:param name="title">helloworld</xsl:param>
	   <xsl:param name="style">reference.css</xsl:param>
	   
	<xsl:template match="/">
	    <xsl:variable name="antherdoc" select="doc('xsl_stylesheet.xml')"/>
		<html>
		<head>
			<xsl:call-template name="head">
				<xsl:with-param name="title" select="$title"/>
				<xsl:with-param name="style" select="$style"/>
			</xsl:call-template>
		</head>
		<body>
			<h1>Title:<xsl:value-of select="/school/name"/></h1>
			address:<xsl:value-of select="school/address"/>
			<p><xsl:apply-templates select="school/students"/></p>
			
			
			从另一个文档引用元素
			<xsl:value-of select="$antherdoc/reference/body/purpose/p"/><br/>
			<a>
					<xsl:attribute name="href">www.baidu.com</xsl:attribute>添加链接属性
			</a>
			
			<br/>
			<h2>translate study()</h2>
			<xsl:variable name="lowcase">abcdefghijklmnopqrstuvwxyz</xsl:variable>
			<xsl:variable name="uppercase">ABCDEFGHIJKLMNOPQRSTUVWXYZ</xsl:variable>
			<xsl:variable name="schooldoc" select="doc('school.xml')"/>
			<xsl:value-of select="translate($schooldoc/school/desc, $lowcase, $uppercase)"/>
			<br/>
		</body>
		</html>
		
	</xsl:template>
	<xsl:template name="head">
		<xsl:param name="title" >title</xsl:param>
		<xsl:param name="style" >style</xsl:param>
		<head>
			<meta content="text/xml; charset=UTF-8" http-equiv="Content-type"/>
			<title>
					<xsl:value-of select="$title"/>
			</title>
			<link rel="stylesheet" style="text/css">
				<xsl:attribute name="href">
					<xsl:value-of select="$style"/>
				</xsl:attribute>
			</link>
		</head>
	</xsl:template>
	<xsl:template match="name">
		<span style="background:yellow;"><xsl:value-of select="."/></span>
	</xsl:template>
		<xsl:template match="address">
		<h1><xsl:value-of select="."/></h1>
	</xsl:template>
</xsl:stylesheet>
