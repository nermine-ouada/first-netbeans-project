/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nermi
 */
public class Product {
    private int id,price,qte;
    private String label;

    public Product(String label,int price, int qte ) {
        this.price = price;
        this.qte = qte;
        this.label = label;
    }

    public Product(int id,String label, int price, int qte) {
        this.id = id;
        this.price = price;
        this.qte = qte;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getQte() {
        return qte;
    }

    public String getLabel() {
        return label;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
