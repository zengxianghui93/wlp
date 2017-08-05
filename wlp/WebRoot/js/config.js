/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	config.language = 'zh-cn'; config.uiColor = '#f7f5f4';
	config.width = '99.7%'; config.height = '400px';
	config.removePlugins = 'elementspath,scayt';
	config.disableNativeSpellChecker = false;
	config.resize_dir = 'vertical';
	config.keystrokes =[[ CKEDITOR.CTRL + 13 /*Enter*/, 'maximize' ]];	
	config.extraPlugins = 'tableresize';
	config.enterMode = CKEDITOR.ENTER_P;
	config.shiftEnterMode = CKEDITOR.ENTER_BR;
	config.font_names='宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑;'+ config.font_names;
	config.image_previewText='&nbsp;';
	config.filebrowserUploadUrl = "${bathpath}/ckeditor/uploadImage.html";
	config.filebrowserBrowseUrl = "${bathpath}/ckeditor/uploadImage.html";
	config.filebrowserImageBrowseUrl = "${bathpath}/ckeditor/uploadImage.html";
	config.filebrowserFlashBrowseUrl = "${bathpath}/ckeditor/uploadImage.html";
	config.filebrowserUploadUrl = "${bathpath}/ckeditor/uploadImage.html";
	config.filebrowserImageUploadUrl = "${bathpath}/ckeditor/uploadImage.html";
	config.filebrowserFlashUploadUrl = "${bathpath}/ckeditor/uploadImage.html";
	config.toolbar_default = [
		['Source','-','Templates','Preview'],
	    ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print'],
	    ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],['ShowBlocks'],['Image','Capture','Flash'],['Maximize'],
	    '/',
	    ['Bold','Italic','Underline','Strike','-'],
	    ['Subscript','Superscript','-'],
	    ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
	    ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
	    ['Link','Unlink','Anchor'],
	    ['Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
	    '/',
	    ['Styles','Format','Font','FontSize'],
	    ['TextColor','BGColor']
	]; config.toolbar = 'default';
};
CKEDITOR.stylesSet.add( 'default', [
                                	/* Block Styles */
                                	{ name : '首行缩进'	, element : 'p', styles : { 'text-indent' : '8pt' } },
                                	/* Inline Styles */
                                	{ name : '标注黄色'	, element : 'span', styles : { 'background-color' : 'Yellow' } },
                                	{ name : '标注绿色'	, element : 'span', styles : { 'background-color' : 'Lime' } },
                                	/* Object Styles */
                                	{ name : '图片左对齐', element : 'img', attributes : { 'style' : 'padding: 5px; margin-right: 5px', 'border' : '2', 'align' : 'left' } },
                                	{ name : '图片有对齐', element : 'img', attributes : { 'style' : 'padding: 5px; margin-left: 5px', 'border' : '2', 'align' : 'right' } },
                                	{ name : '无边界表格', element : 'table', styles: { 'border-style': 'hidden', 'background-color' : '#E6E6FA' } }
                                ]);
