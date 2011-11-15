function moeda(z){
    	v = z.value;
    	v = v.replace(/\D/g,"");  //permite digitar apenas números
    	v = v.replace(/[0-9]{12}/,"");   //limita pra máximo 999.999.999,99 antes dos últimos 5
    	v = v.replace(/(\d{1})(\d{1,2})$/,"$1,$2");       //coloca virgula antes dos
    	z.value = v;
   }

function numberOnly(n){
	v = n.value;
	v = v.replace(/\D/g,"");  //permite digitar apenas números
	n.value = v;
}


function setFocus(id) {
    var element = document.getElementById(id);
    if (element && element.focus) {
        element.focus();
    }
}

function setFocusCorrectValue(id1, id2){
	var element = document.getElementById(id1);
	var element2 = document.getElementById(id2);
	if (element && element.focus && element2 && element2.focus) {
	if(element.value == ''){
		element.focus();
	}else{
		element2.focus();
	}
	}
}
	
function showDialog(id, devedor, dialog){
	var element = document.getElementById(id);
	var element2 = document.getElementById(devedor);
	if(element && element.focus){
		if(element.value == ''){
			element.focus();
		}else{
			if(element2.value == ''){
			dialog.show();
			}
		}
	}
}

function showDialogDevedor(id,devedor, dialog, devedorView){
	//showDialog(id, devedor, dialog);
	if(devedorView != null){
		devedorView.show();
	}
}

function showDialog2(dialog){
		
		if(dialog != null){
			dialog.show();
		}	
}

function showDialogUsuario(dialog, id){
	
	if(dialog != null){
		dialog.show();
	}
	setFocus(id);
}


	