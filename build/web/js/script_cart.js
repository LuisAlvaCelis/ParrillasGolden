$(function (){
    $('tr #removeitem').click(function (e){
        e.preventDefault();
        var element=$(this);
        var idmenu=element.parent().find('#idarticle').text();
        $.ajax({
            url: 'cart?acjsp=remove-cart',
            type: 'post',
            data: {idmenu: idmenu},
            success: function (r) {
                element.parent().parent().remove();
                var elementsTable=$('#table-shop tr');
                if(elementsTable.length<=1){
                    $('#console-items-notfound').text("Error: Menus no encontrados");
                    $('#txt-subtotal').text(0.0);
                    $('#txt-total').text(0.0);
                }else{
                    $('#txt-subtotal').text(r);
                    $('#txt-total').text(r);
                }
            }
       });
   }); 
});