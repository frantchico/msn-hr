<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"><xsl:output method="html" omit-xml-declaration="yes" encoding="utf-8" indent="yes" doctype-system="about:legacy-compat"/><xsl:template match="/"><html><head><xsl:call-template name="IGRP-head"/><link rel="stylesheet" type="text/css" href="{$path}/core/igrp/toolsbar/toolsbar.css?v={$version}"/><link rel="stylesheet" type="text/css" href="{$path}/core/igrp/table/datatable/dataTables.bootstrap.css?v={$version}"/><link rel="stylesheet" type="text/css" href="{$path}/core/igrp/table/igrp.tables.css?v={$version}"/><style/></head><body class="{$bodyClass} sidebar-off"><xsl:call-template name="IGRP-topmenu"/><form method="POST" class="IGRP-form" name="formular_default" enctype="multipart/form-data"><div class="container-fluid"><div class="row"><xsl:call-template name="IGRP-sidebar"/><div class="col-sm-9 col-md-10 col-md-offset-2 col-sm-offset-3 main" id="igrp-contents"><div class="content"><div class="row row-msg"><div class="gen-column col-md-12"><div class="gen-inner"><xsl:apply-templates mode="igrp-messages" select="rows/content/messages"/></div></div></div><div class="row " id="row-d1c323b4"><div class="gen-column col-sm-9"><div class="gen-inner"><xsl:if test="rows/content/form_1"><div class="box igrp-forms gen-container-item " gen-class="" item-name="form_1"><xsl:call-template name="box-header"><xsl:with-param name="title" select="rows/content/form_1/@title"/><xsl:with-param name="collapsible" select="'true'"/><xsl:with-param name="collapsed" select="'true'"/></xsl:call-template><div class="box-body"><div role="form"><xsl:apply-templates mode="form-hidden-fields" select="rows/content/form_1/fields"/><xsl:if test="rows/content/form_1/fields/nome_f"><div class="form-group col-sm-6   gen-fields-holder" item-name="nome_f" item-type="text"><label for="{rows/content/form_1/fields/nome_f/@name}"><span><xsl:value-of select="rows/content/form_1/fields/nome_f/label"/></span></label><input type="text" value="{rows/content/form_1/fields/nome_f/value}" class="form-control  " inputmask="" id="{rows/content/form_1/fields/nome_f/@name}" name="{rows/content/form_1/fields/nome_f/@name}" disablehtml="true" maxlength="250" placeholder="{rows/content/form_1/fields/nome_f/@placeholder}"><xsl:call-template name="setAttributes"><xsl:with-param name="field" select="rows/content/form_1/fields/nome_f"/></xsl:call-template></input></div></xsl:if><xsl:if test="rows/content/form_1/fields/referencia_f"><div class="form-group col-sm-6   gen-fields-holder" item-name="referencia_f" item-type="text"><label for="{rows/content/form_1/fields/referencia_f/@name}"><span><xsl:value-of select="rows/content/form_1/fields/referencia_f/label"/></span></label><input type="text" value="{rows/content/form_1/fields/referencia_f/value}" class="form-control  " inputmask="" id="{rows/content/form_1/fields/referencia_f/@name}" name="{rows/content/form_1/fields/referencia_f/@name}" disablehtml="true" maxlength="250" placeholder="{rows/content/form_1/fields/referencia_f/@placeholder}"><xsl:call-template name="setAttributes"><xsl:with-param name="field" select="rows/content/form_1/fields/referencia_f"/></xsl:call-template></input></div></xsl:if></div></div><xsl:apply-templates select="rows/content/form_1/tools-bar" mode="form-buttons"/></div></xsl:if></div></div><div class="gen-column col-sm-3"><div class="gen-inner"><xsl:if test="rows/content/toolsbar_1"><div class="toolsbar-holder default gen-container-item " gen-structure="toolsbar" gen-fields=".btns-holder&gt;a.btn" gen-class="" item-name="toolsbar_1"><div class="btns-holder   pull-right" role="group"><xsl:apply-templates select="rows/content/toolsbar_1" mode="gen-buttons"><xsl:with-param name="vertical" select="'true'"/><xsl:with-param name="outline" select="'false'"/></xsl:apply-templates></div></div></xsl:if></div></div></div><div class="row " id="row-3a09d2ca"><div class="gen-column col-sm-12"><div class="gen-inner"><xsl:if test="rows/content/table_1"><div class="box box-table-contents gen-container-item " gen-class="" item-name="table_1"><div class="box-body "><div class="table-contents-head"><div class="table-contents-inner"></div></div><div class="table-box"><div class="table-box-inner"><table id="table_1" class="table table-striped  igrp-data-table IGRP_contextmenu " exports=""><thead><tr><xsl:if test="rows/content/table_1/fields/foto"><th td-name="foto" align="left" show-label="true" class="img  gen-fields-holder" group-in=""><span><xsl:value-of select="rows/content/table_1/fields/foto/label"/></span></th></xsl:if><xsl:if test="rows/content/table_1/fields/produto"><th td-name="produto" align="left" show-label="true" class="textarea  gen-fields-holder" group-in=""><span><xsl:value-of select="rows/content/table_1/fields/produto/label"/></span></th></xsl:if><xsl:if test="rows/content/table_1/fields/referencia"><th td-name="referencia" align="left" show-label="true" class="text  gen-fields-holder" group-in=""><span><xsl:value-of select="rows/content/table_1/fields/referencia/label"/></span></th></xsl:if><xsl:if test="rows/content/table_1/fields/registado_por"><th td-name="registado_por" align="left" show-label="true" class="text  gen-fields-holder" group-in=""><span><xsl:value-of select="rows/content/table_1/fields/registado_por/label"/></span></th></xsl:if><xsl:if test="rows/content/table_1/table/context-menu/item"><th class="igrp-table-ctx-th"/></xsl:if></tr></thead><tbody><xsl:for-each select="rows/content/table_1/table/value/row[not(@total='yes')]"><tr><xsl:apply-templates mode="context-param" select="context-menu"/><input type="hidden" name="p_id_fk" value="{id}"/><input type="hidden" name="p_id_fk_desc" value="{id_desc}"/><input type="hidden" name="p_id_user_fk" value="{id_user}"/><input type="hidden" name="p_id_user_fk_desc" value="{id_user_desc}"/><xsl:if test="foto"><td align="left" data-row="{position()}" data-title="{../../fields/foto/label}" class="img" item-name="foto"><img class="table-img   " src="{foto}"/></td></xsl:if><xsl:if test="produto"><td align="left" data-order="{produto}" data-row="{position()}" data-title="{../../../fields/produto/label}" class="textarea" item-name="produto"><span class=""><xsl:value-of select="produto"/></span></td></xsl:if><xsl:if test="referencia"><td align="left" data-order="{referencia}" data-row="{position()}" data-title="{../../../fields/referencia/label}" class="text" item-name="referencia"><span class=""><xsl:value-of select="referencia"/></span></td></xsl:if><xsl:if test="registado_por"><td align="left" data-order="{registado_por}" data-row="{position()}" data-title="{../../../fields/registado_por/label}" class="text" item-name="registado_por"><span class=""><xsl:value-of select="registado_por"/></span></td></xsl:if><xsl:if test="//rows/content/table_1/table/context-menu/item"><td class="igrp-table-ctx-td"><xsl:apply-templates select="../../context-menu" mode="table-context-inline"><xsl:with-param name="row-params" select="context-menu"/><xsl:with-param name="type" select="'inl'"/></xsl:apply-templates></td></xsl:if></tr></xsl:for-each></tbody></table></div></div></div></div></xsl:if></div></div></div></div></div></div></div><xsl:call-template name="IGRP-bottom"/></form><script type="text/javascript" src="{$path}/core/igrp/form/igrp.forms.js?v={$version}"/><script type="text/javascript" src="{$path}/core/igrp/table/datatable/jquery.dataTables.min.js?v={$version}"/><script type="text/javascript" src="{$path}/core/igrp/table/datatable/dataTables.bootstrap.min.js?v={$version}"/><script type="text/javascript" src="{$path}/core/igrp/table/igrp.table.js?v={$version}"/><script type="text/javascript" src="{$path}/core/igrp/table/bootstrap-contextmenu.js?v={$version}"/><script type="text/javascript" src="{$path}/core/igrp/table/table.contextmenu.js?v={$version}"/><script type="text/javascript" src="{$path}/plugins/inputmask/jquery.inputmask.min.js?v={$version}"/><script type="text/javascript" src="{$path}/plugins/inputmask/igrp.inputmask.js?v={$version}"/></body></html></xsl:template><xsl:include href="../../../xsl/tmpl/IGRP-functions.tmpl.xsl?v=19"/><xsl:include href="../../../xsl/tmpl/IGRP-variables.tmpl.xsl?v=19"/><xsl:include href="../../../xsl/tmpl/IGRP-home-include.tmpl.xsl?v=19"/><xsl:include href="../../../xsl/tmpl/IGRP-utils.tmpl.xsl?v=19"/><xsl:include href="../../../xsl/tmpl/IGRP-form-utils.tmpl.xsl?v=19"/><xsl:include href="../../../xsl/tmpl/IGRP-table-utils.tmpl.xsl?v=19"/></xsl:stylesheet>