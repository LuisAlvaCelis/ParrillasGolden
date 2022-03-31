function hiddenConsole(){
    var i,console=document.getElementsByClassName("console");
    for(i=0;i<console.length;i++){
        console[i].style.display="none";
    }
}
function seePassword(){
    var pass=document.getElementById("input-password");
    var repass=document.getElementById("input-repeatpassword");
    if(pass.type==="password"){
        pass.type="text";
        if(repass.type==="password"){
            repass.type="text";
        }
    }else{
        pass.type="password";
        if(repass.type==="text"){
            repass.type="password";
        }
    }
}
function viewDataPassword(){
    var pass=document.getElementById("input-password").value;
    var spaces=false;
    var cont=0;
    while(!spaces && (cont<pass.length)){
        if(pass.charAt(cont)===" ")
            spaces=true;
            cont++;
    }
    if(spaces){
        document.getElementById("consolePassword").innerHTML='La contraseña no debe contener espacios';
    }else{
        document.getElementById("consolePassword").innerHTML=' ';
    }
}
function viewDataRepeatPassword(){
    var pass=document.getElementById("input-password").value;
    var repass=document.getElementById("input-repeatpassword").value;
    var spaces=false;
    var cont=0;
    while(!spaces && (cont<repass.length)){
        if(repass.charAt(cont)===" ")
            spaces=true;
            cont++;
    }
    if(spaces){
        if(repass===pass){
            document.getElementById("consoleRepeatPassword").innerHTML='La contraseña repetida no debe contener espacios';
        }else{
            document.getElementById("consoleRepeatPassword").innerHTML='La contraseña repetida no debe contener espacios y las contraseñas no coinciden';
        }
    }else{
        if(repass===pass){
            document.getElementById("consoleRepeatPassword").innerHTML=' ';
        }else{
            document.getElementById("consoleRepeatPassword").innerHTML='Las contraseñas no coinciden';
        }
    }
}
