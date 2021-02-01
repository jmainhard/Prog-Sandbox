package com.pooprueba2;

import com.pooprueba2.helper.CanastaVaciaException;
import com.pooprueba2.helper.EstadosCanastaEnum;
import com.pooprueba2.helper.TipoCongelacionEnum;
import java.util.ArrayList;

/**
 * 30-enero-2021
 * 1-febrero-2021
 * @author Jorge M.
 */

public class Main {
    public static void main(String[] args) throws CanastaVaciaException {
        
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Canasta canasta = new Canasta(EstadosCanastaEnum.REGRIGERADOS);
        
        listaProductos.add(new Fresco(35, "Longaniza", 24, 3500));
        listaProductos.add(new Frio("Verdura congelada", -15, 4500));
        listaProductos.add(new Frio("Verdura congelada", -15, 4500));
        listaProductos.add(new Frio("Verdura congelada", -15, 4500));
        listaProductos.add(new Frio("Verdura congelada", -15, 4500));
        listaProductos.add(new Frio("Verdura congelada", -15, 4500));
        listaProductos.add(new Frio("Verdura congelada", -15, 4500));
        listaProductos.add(new Frio("Verdura congelada", -15, 4500));
        listaProductos.add(new Frio("Verdura congelada", -15, 4500));
        listaProductos.add(new Frio("Verdura congelada", -15, 4500));
        listaProductos.add(new Frio("Verdura congelada", -15, 4500));
        listaProductos.add(new Frio("Verdura congelada", -15, 4500));
        listaProductos.add(new Congelado(TipoCongelacionEnum.LENTA, "Helado", -10, 400));
        listaProductos.add(new Congelado(TipoCongelacionEnum.RAPIDA, "Pollo", -23, 3600));
        listaProductos.add(new Congelado(TipoCongelacionEnum.RAPIDA, "Pollo", -23, 3600));
        listaProductos.add(new Congelado(TipoCongelacionEnum.RAPIDA, "Pollo", -23, 3600));
        listaProductos.add(new Congelado(TipoCongelacionEnum.RAPIDA, "Pollo", -23, 3600));
        listaProductos.add(new Congelado(TipoCongelacionEnum.RAPIDA, "Pollo", -23, 3600));
        listaProductos.add(new Congelado(TipoCongelacionEnum.RAPIDA, "Pollo", -23, 3600));
        listaProductos.add(new Congelado(TipoCongelacionEnum.RAPIDA, "Pollo", -23, 3600));
        listaProductos.add(new Congelado(TipoCongelacionEnum.RAPIDA, "Pollo", -23, 3600));
        listaProductos.add(new Congelado(TipoCongelacionEnum.RAPIDA, "Pollo", -23, 3600));
        listaProductos.add(new Congelado(TipoCongelacionEnum.RAPIDA, "Pollo", -23, 3600));
        listaProductos.add(new Congelado(TipoCongelacionEnum.RAPIDA, "Pollo", -23, 3600));
        
        canasta.setProductos(listaProductos);
        
        Cliente cliente1 = new Cliente("Raúl Pérez", "12345678-9", canasta);
        Boleta boleta = new Boleta(cliente1);
        
        System.out.println(boleta.mostrarDetalle());

    }

}
