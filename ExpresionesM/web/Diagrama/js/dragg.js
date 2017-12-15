var index = 3;
//Asigna valores a las cajas
var datos = ["drag1", "drag2", "drag3" ];
var datos2 = ["2", "5", "10" ];
//Crea nuevas cajas sobre pizarra azul
function getNewElement(value){
    var div = document.createElement('div');
    div.innerHTML = '<div class="box ' + datos[value-1] + '" id="' + ++index + '" draggable="true" ondragstart="start(event)" ondragend="end(event)" > <p class="valor">'+datos2[value-1]+'</p> </div>';
    return div.firstChild;
}

function toggleCheckbox(element){
    update();
}
//Función para guardar el ejercicio

function saveDiagrama() {
var juego = document.getElementById("contenedor").innerHTML;

var stringUrl = "http://127.0.0.1/peredo/guardaDiagrama?informacion=" + juego;
//Se guarda con el parametro "informacion". Si fuera un servlet, se recupera con getParameter("informacion");
console.log("Debug url:" + stringUrl);


//Instruccion para redirigir
window.location.href = stringUrl;

}

function start(e) {
    e.dataTransfer.effecAllowed = 'move'; // efecto mover
    e.dataTransfer.setData("Data", e.target.id); // elemento que se va a mover
    e.dataTransfer.setDragImage(e.target, 0, 0); // cómo se vera al ser arrastrado
    e.target.style.opacity = '0.4';
}

function end(e){
    e.target.style.opacity = ''; // Pone la opacidad del elemento a 1
    e.dataTransfer.clearData("Data"); //elimina datos

}

//Funciones para cuadro2
//ondragenter indica lo que realiza el elemento drag dentro de cuadro2
function enter(e) {
    var id = e.target.id;
    if (id == 'cuadro1' || id == 'cuadro2'){
        e.target.style.border = '3px dotted #555';
    }


}
//ondragleave: indica lo que hará cuadro2 cuando un elemento se suelte dentro de él
function leave(e) { //aqui agregar los nuevos drag
    e.target.style.border = '';
}
//ondragover: indica los elementos que se pueden soltar en cuadro2
function over(e) {
    var elemDrag = e.dataTransfer.getData("Data"); // Elemento arrastrado
    var id = e.target.id; // Elemento sobre el que se arrastra

    // return false para que se pueda soltar el elemento en cuadro2
    if (id == 'cuadro1'){
        return false; // Cualquier elemento se puede soltar
    }

    if (id == 'cuadro2') {
        return false; //
    }
}
//Mueve el elemento. ondrop: acción que se hará cuando se suelte un elemento dentro de cuadro2

function update(){
    var check = document.getElementById("check-value");

    var elements = document.getElementsByClassName("valor");
    if(check.checked){//muestra
        for(var i = 0; i < elements.length; i++){
            elements[i].style.display = 'block'
        }
    } else { //oculta
        for(var i = 0; i < elements.length; i++){
            elements[i].style.display = 'none'
        }
    }

    var cuadro2 = document.getElementById("cuadro2");
    var drag1 = cuadro2.getElementsByClassName("drag1").length;
    var drag2 = cuadro2.getElementsByClassName("drag2").length;
    var drag3 = cuadro2.getElementsByClassName("drag3").length;
//Suma del resultado
    console.log("Tenemos 2x" + drag1 + ", 5x" + drag2 + ", 10x" + drag3);
    document.getElementById("total").innerHTML = drag1*2 + drag2*5 + drag3*10;

}

function drop(e){
    var id = e.target.id;
    var elementoArrastrado = e.dataTransfer.getData("Data"); // Elemento arrastrado

    console.log("cuadro: " + e.target.id + "  box:" + elementoArrastrado);
    if(id == 'cuadro2' && elementoArrastrado <= 3){
        e.target.appendChild( getNewElement(elementoArrastrado) );

    } else if(id == 'cuadro1' && elementoArrastrado > 3){
        var element = document.getElementById(elementoArrastrado);
        element.outerHTML = "";
        delete element;
    }

    update();

    //e.target.appendChild(document.getElementById(elementoArrastrado));
    e.target.style.border = '';  // Quita el borde

    //tamElemX = $(elementoArrastrado).width();
    //tamElemY = $(elementoArrastrado).height();
    //document.getElementById(elementoArrastrado).style.position = "absolute";
}

