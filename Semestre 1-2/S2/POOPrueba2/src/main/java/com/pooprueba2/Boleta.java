package com.pooprueba2;

import com.pooprueba2.helper.CanastaVaciaException;
import com.pooprueba2.helper.EstadosCanastaEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Jorge M.
 */
public class Boleta implements Imprimible {

    final String idBoleta;
    private Cliente cliente;
    private int totalDescuentos;
    private double total;

    public Boleta(Cliente cliente) {
        this.cliente = cliente;
        this.idBoleta = cliente.getRut() + " TODO + LocalDateTime";
    }

    @Override
    public void imprimir() {
        // TODO imprimir boleta y guardar archivo

        try {
            if (cliente.realizarCompra()) {

            }
        } catch (Exception e) {
            System.err.println(e);
        }

        throw new UnsupportedOperationException("TODO.");
    }

    public String mostrarDetalle() {
        String stringBuilder;
        Canasta canasta = cliente.getCanastaCliente();
        List<Double> precios = new ArrayList<>();

        stringBuilder = "---- DATOS CLIENTE ----\n";
        stringBuilder += cliente.toString() + "\n";

        stringBuilder += "\n---- DETALLE ----\n";
        stringBuilder = canasta.getProductos().stream().
                map(producto -> producto.toString() + "\n").
                reduce(stringBuilder, String::concat);
        
        // FIXME 
        canasta.getProductos().forEach(producto -> {
            precios.add(producto.getPrecio());
        });
        
        stringBuilder += "Total sin descuentos: $ "+ precios.stream().reduce(0.0, Double::sum);

        stringBuilder += "\n---- DESCRIPCIÓN ----\n";
        stringBuilder += canasta.getEstado().
                equals(EstadosCanastaEnum.REGRIGERADOS)
                ? "Refrigerados\n" : "Para servir\n";

        stringBuilder += "\nDescuento(s):";
        stringBuilder += "(Aplica para +10 productos del mismo tipo en canasta)\n";
        stringBuilder += getDescuentosAplicados();
        stringBuilder += "\nTotal descuentos aplicados: -" + totalDescuentos+ "%";
        

        stringBuilder += "\n---- TOTAL BOLETA ----\n";
        stringBuilder += "$ " + getTotal();

        return stringBuilder;
    }

    public String getDescuentosAplicados() {
        String strBuilder = "\n";
        Class claseFiltro;

        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    claseFiltro = Frio.class;
                    break;
                case 1:
                    claseFiltro = Fresco.class;
                    break;
                case 2:
                    claseFiltro = Congelado.class;
                    break;
                default:
                    throw new AssertionError();
            }
            if (cliente.getCanastaCliente().countProductos(claseFiltro) > 10) {
                strBuilder += "10% de descuento a productos "
                        + claseFiltro.getSimpleName() + "s\n";
                this.totalDescuentos += 10;
            }
        }
        
        return strBuilder.isBlank() ? "No aplica\n" : strBuilder;
    }

    public double getTotal() {
        calcTotal();
        return total;
    }

    public void calcTotal() {
        List<Double> precios = new ArrayList<>();
        Canasta canasta = cliente.getCanastaCliente();
        Class claseFiltro;
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    claseFiltro = Frio.class;
                    break;
                case 1:
                    claseFiltro = Fresco.class;
                    break;
                case 2:
                    claseFiltro = Congelado.class;
                    break;
                default:
                    throw new AssertionError();
            }

            if (cliente.getCanastaCliente().countProductos(claseFiltro) > 10) {
                discountTo(claseFiltro);
                this.totalDescuentos += 10;
            }
        }
        
        canasta.getProductos().forEach(producto -> {
            precios.add(producto.getPrecio());
        });
        
        this.total = precios.stream().reduce(0.0, Double::sum);
    }
    
    // FIXME
    public void discountTo(Class c) {
        List<Producto> productsDiscounted;
        
        productsDiscounted = cliente.getCanastaCliente().groupProductos(c);
        for (Producto producto : productsDiscounted) {
            producto.precio -= producto.getPrecio() * 0.1;
        }
        cliente.getCanastaCliente().setProductos(productsDiscounted);
    }
                
    

}
