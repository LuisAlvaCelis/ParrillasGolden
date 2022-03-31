function seePassword(){
    var pass=document.getElementById("txtPassword");
    var repass=document.getElementById("txtRepeatPassword");
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
function clearConsole(nameConsole){
    if(nameConsole==='1'){
        document.getElementById("consoleDNI").innerHTML=' ';
    }else if(nameConsole==='2'){
        document.getElementById("consolePassword").innerHTML=' ';
    }else if(nameConsole==='3'){
        document.getElementById("consoleRepeatPassword").innerHTML=' ';
    }
}
function viewDataDNI(){
    var dni=document.getElementById("txtDNI").value;
    if(dni!==""){
        if(dni.length===8){
            document.getElementById("consoleDNI").innerHTML=' ';
        }else{
            document.getElementById("consoleDNI").innerHTML='DNI debe contener 8 dígitos';
        }
    }
}

function viewDataPassword(){
    var pass=document.getElementById("txtPassword").value;
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
    var pass=document.getElementById("txtPassword").value;
    var repass=document.getElementById("txtRepeatPassword").value;
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

function closeAllTabs(){
    var i, tabcontents;
    tabcontents=document.getElementsByClassName("tabcontent");
    for(i=0;i<tabcontents.length;i++){
        tabcontents[i].style.display = "none";
    }
    document.getElementById("1").style.display = "block";
}
function openTab(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}