// 29-06-2021 Jorge M.
// Ejercicios Javascript
// exportando a ./index.html
// posible fixme: se está modificando el array original en muchas funciones
// warning: archivo alto en spanglish

// 1
export function biggie(arr) {
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > 0) {
            arr[i] = 'big';
        }
    }
    return arr;
}

// 2
export function printMinReturnMax(arr) {
    console.log(Math.min(...arr)); // ...spread operator
    return Math.max(...arr);
}

// es par
function isEven(number) {
    return number % 2 === 0;
}

// 3
export function printOneReturnOther(arr) {
    let penultimo = arr.slice(arr.length - 2 ,arr.length - 1)[0];
    // fuente: https://javascript.info/array-methods#find-and-findindex
    let primerImpar = arr.find(element => !isEven(element)); // lambda parecido al de Java (al reves, no sé)
    console.log("Penúltimo valor: " + penultimo);
    return primerImpar;
}

// 4
export function dobleVision(arr) {
    let newArray = [];
    arr.forEach(element => newArray.push(element * 2));
    return newArray;
}

// 5
export function countPositives(arr) {
    let positivos = 0;
    arr.forEach(element => {
        if (element > 0) positivos++;
    });
    arr[arr.length - 1] = positivos;
    return arr;
}

// 6
// Pares e Impares -Crea una función que acepte un array. Cada vez que ese array tenga 3 valores impares seguidos, 
// imprime (print) “¡Qué imparcial!”, y cada vez que tenga 3 pares seguidos, imprime (print) “¡Es para bien!”.

function initContador() {
    let contador = {
        pares: 0,
        impares: 0,
        resetPares: function() {
            this.pares = 0;
        },
        resetImpares: function() {
            this.impares = 0;
        }
    };
    return contador;
}

// impares y pares v2 (refactor v1)
export function oddAndEven(arr) {
    let contador = initContador();
    for (let i = 0; i < arr.length; i++) {
        if (isEven(arr[i])) {
            contador.pares++;
            // console.log('par: ' + contador.pares); // debug, se puede borrar
            if (contador.pares === 3) {
                console.log('!Es para bien!');
                contador.resetPares();
            }
            contador.resetImpares();
        } else {
            contador.impares++;
            // console.log('impar: ' + contador.impares);
            if(contador.impares === 3) {
                console.log('!Qué imparcial!');
                contador.resetImpares();
            }
            contador.resetPares();
        }
    }
}

// v1 enrealidad esta versión es mas limpia pero me gusta la segunda
// export function oddAndEven(arr) {
//     let pares = 0, impares = 0;
//     for (let i = 0; i < arr.length; i++) {
//         if (isEven(arr[i])) {
//             pares++;
//             if (pares === 3) {
//                 console.log('!Es para bien!');
//                 pares = 0;
//             }
//             impares = 0;
//         } else {
//             impares++;
//             if(impares === 3) {
//                 console.log('!Qué imparcial!');
//                 impares = 0;
//             }
//             pares = 0;
//         }
//     }
// }

// 7
export function aumentaImpares(arr) {
    for (let i = 0; i < arr.length; i++) {
        if (!isEven(i)) {
            arr[i]++;
        }
    }
    console.log(...arr);
    return arr;
}

// 8
export function longitudesPrevias(arr) {
    let longitudes = [];
    arr.forEach(element => longitudes.push(element.length));
    for (let i = 1; i < arr.length; i++) {
        arr[i] = longitudes[i - 1];   
    }
    return arr;
}

// 9
export function agregaSiete(arr) {
    let newArray = [];
    arr.forEach(element => newArray.push(element + 7));
    console.log('Old Array: ' + arr);
    return newArray;
}

// 10
export function invertirArray(arr) {
    return arr.reverse();
}

// 11
export function allNegatives(arr) {
    let newArray = [];
    arr.forEach((element) => 
         element > 0 ? newArray.push(element * -1) : newArray.push(element)
    );
    return newArray;
}

// 12 TODO
export function verComida(arr) {

}



