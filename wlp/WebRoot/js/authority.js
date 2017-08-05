function addSrcToDestList(listSrc,listDest) {
destList = listDest;
srcList = listSrc;
var len = destList.length;
for(var i = 0; i < srcList.length; i++) {
if ((srcList.options[i] != null) && (srcList.options[i].selected)) {

var found = false;
for(var count = 0; count < len; count++) {
if (destList.options[count] != null) {
if (srcList.options[i].value == destList.options[count].value) {
found = true;
break;
      }
   }
}
if (found != true) {
destList.options[len] = new Option(srcList.options[i].text);
destList.options[len].value=srcList.options[i].value;
len++;
         }
      }
   }
}

function deleteFromDestList(listDest) {
var destList  = listDest;
var len = destList.options.length;
for(var i = (len-1); i >= 0; i--) {
if ((destList.options[i] != null) && (destList.options[i].selected == true)) {
destList.options[i] = null;
      }
   }
}


function selectall(select){
for(i=0;i<select.length;i++)
  select.options[i].selected=true;
}