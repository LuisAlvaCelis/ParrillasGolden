function checkDatCantFocusOut(){
    var cant=document.getElementById("txtCantMenu").value;
    if(cant===""){
        document.getElementById("txtCantMenu").value="1";
    }
}
function checkDataCant(){
    var cant=document.getElementById("txtCantMenu").value;
    if(cant!==""){
        if(cant<=0){
            document.getElementById("txtCantMenu").value="1";
        }
    }
}