package com.example.gracee.Models;

import javax.persistence.*;

@Entity
@Table(name = "coins")
public class Coin
{
    //coinid, name, namepural, value, quantity

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long coinid;

    String name;
    String namepural;
    double value;
    int quantity;

    public Coin()
    {
    }

    public Coin(String name, String namepural, double value, int quantity)
    {
        this.name = name;
        this.namepural = namepural;
        this.value = value;
        this.quantity = quantity;
    }

    public Long getCoinid()
    {
        return coinid;
    }

    public void setCoinid(Long coinid)
    {
        this.coinid = coinid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNamepural()
    {
        return namepural;
    }

    public void setNamepural(String namepural)
    {
        this.namepural = namepural;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    @Override
    public String toString()
    {
        return "Coin{" +
                "coinid=" + coinid +
                ", name='" + name + '\'' +
                ", namepural='" + namepural + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}
