<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/RetForm">
		<xsl:variable name="tName"/>
		<Return>
			<header>
				<formID>#FormID#</formID>
				<calendarType>#CalendarType#</calendarType>
			</header>
			<content>
				<xsl:for-each select="/RetForm/*">
					<xsl:choose>
						<xsl:when test="child::*">
							<xsl:variable name="tableName" select="local-name(.)"/>
							<xsl:if test="0>=count(preceding::*[local-name(.)=$tableName])">
								<xsl:variable name="t1Count" select="count(/RetForm/child::*[local-name(.)=$tableName])"/>
								<xsl:if test="$t1Count>0">
									<table>
										<xsl:attribute name="id" ><xsl:value-of  select="$tableName"/></xsl:attribute>
										<xsl:for-each select="/RetForm/child::*[local-name(.)=$tableName][1]/*">
											<xsl:variable name="fieldName" select="local-name(.)"/>
											<field>
												<id>
													<xsl:value-of select="$fieldName"/>
												</id>
												<xsl:call-template name="valueField">
													<xsl:with-param name="curCount">1</xsl:with-param>
													<xsl:with-param name="maxCount" select="$t1Count"/>
													<xsl:with-param name="tableId">
														<xsl:value-of select="$tableName"/>
													</xsl:with-param>
													<xsl:with-param name="fieldId">
														<xsl:value-of select="$fieldName"/>
													</xsl:with-param>
												</xsl:call-template>
											</field>
										</xsl:for-each>
									</table>
								</xsl:if>
							</xsl:if>
						</xsl:when>
						<xsl:otherwise>
							<field>
								<id>
									<xsl:value-of select="local-name(current())"/>
								</id>
								<value>
									<xsl:value-of select="current()"/>
								</value>
							</field>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:for-each>
			</content>
		</Return>
	</xsl:template>
	<xsl:template name="valueField">
		<xsl:param name="curCount"/>
		<xsl:param name="maxCount"/>
		<xsl:param name="tableId"/>
		<xsl:param name="fieldId"/>
		<xsl:if test="$maxCount>=$curCount">
			<value>
				<xsl:attribute name="rowNum" ><xsl:value-of select="$curCount"/></xsl:attribute>
				<xsl:value-of select="/RetForm/child::*[local-name(.)=$tableId][position()=$curCount]/child::*[local-name(.)=$fieldId]"/>
			</value>
			<xsl:call-template name="valueField">
				<xsl:with-param name="curCount" select="number($curCount)+1"/>
				<xsl:with-param name="maxCount" select="number($maxCount)"/>
				<xsl:with-param name="tableId" select="$tableId"/>
				<xsl:with-param name="fieldId" select="$fieldId"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
</xsl:stylesheet>
