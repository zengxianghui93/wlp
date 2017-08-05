/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	/**
	 * 该配置文件为数据导入录入模板准备
	 * @author lilongbiao
	 */
	config.language = 'zh-cn'; 
	config.removePlugins = 'elementspath,scayt';
	config.disableNativeSpellChecker = false;
	config.resize_dir = 'vertical';
	config.keystrokes =[[ CKEDITOR.CTRL + 13 /*Enter*/, 'maximize' ]];	
	config.enterMode = CKEDITOR.ENTER_BR;
	config.shiftEnterMode = CKEDITOR.ENTER_P;
	config.font_names='宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑;'+ config.font_names;
	config.image_previewText='&nbsp;';
	config.filebrowserUploadUrl = "${context}/ckeditor/uploadImage.html";
	config.filebrowserBrowseUrl = "${context}/ckeditor/uploadImage.html";
	config.filebrowserImageBrowseUrl = "/upload.html";
	config.filebrowserFlashBrowseUrl = "${context}/ckeditor/uploadImage.html";
	config.filebrowserUploadUrl = "uploadFile.html";
	config.filebrowserImageUploadUrl = '../CKeditor/uploadImage.html?type=Images';
	config.filebrowserFlashUploadUrl = "${context}/ckeditor/uploadImage.html";
	config.pasteFromWordRemoveFontStyles = false;
	config.pasteFromWordRemoveStyles = false;
	config.height = 400; //高度   
	
	config.enterMode = CKEDITOR.ENTER_P;
	config.tabSpaces = 4;
};
CKEDITOR.stylesSet.add( 'default', [
                                	/* Block Styles */
                                	{ name : '首行缩进'	, element : 'p', styles : { 'text-indent' : '20pt' } },
                                	/* Inline Styles */
                                	{ name : '标注黄色'	, element : 'span', styles : { 'background-color' : 'Yellow' } },
                                	{ name : '标注绿色'	, element : 'span', styles : { 'background-color' : 'Lime' } },
                                	/* Object Styles */
                                	{ name : '图片左对齐', element : 'img', attributes : { 'style' : 'padding: 5px; margin-right: 5px', 'border' : '2', 'align' : 'left' } },
                                	{ name : '图片有对齐', element : 'img', attributes : { 'style' : 'padding: 5px; margin-left: 5px', 'border' : '2', 'align' : 'right' } },
                                	{ name : '无边界表格', element : 'table', styles: { 'border-style': 'hidden', 'background-color' : '#E6E6FA' } }
                                ]);
CKEDITOR.on( 'instanceReady', function( ev ) { with (ev.editor.dataProcessor.writer) {
	setRules("p", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("h1", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("h2", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("h3", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("h4", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("h5", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("div", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("table", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("tr", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("td", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("iframe", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("li", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("ul", {indent : false, breakAfterOpen : false, breakBeforeClose : false} );
	setRules("ol", {indent : false, breakAfterOpen : false, breakBeforeClose : false} ); }
/*	config.toolbar = [
	          		{ name: 'document', items: [ 'Source', '-',  'Preview', 'Print', '-', 'Templates' ] },
	          		{ name: 'clipboard', items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
	          		{ name: 'forms', items: [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField' ] },
	          		'/',
	          		{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', 'CreateDiv', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl' ] },
	          		{ name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] },
	        		{ name: 'insert', items: [ 'Image', 'Flash', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak', 'Iframe' ] },
	          		{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
	          		{ name: 'tools', items: [ 'Maximize', 'ShowBlocks' ] },
	          	];
	config.startupMode = 'source';*/
	/*config.image_previewText='&nbsp;';*/
	
});