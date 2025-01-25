package com.example.numbers_batch.model;

public class Number {
    private Integer nbr1;
    private Integer nbr2;
    private Integer nbr3;
    private Integer nbr4;
    private Integer total;

    public Number() {
    }

    public Number(Integer nbr1, Integer nbr2, Integer nbr3, Integer nbr4) {
        this.nbr1 = nbr1;
        this.nbr2 = nbr2;
        this.nbr3 = nbr3;
        this.nbr4 = nbr4;
        this.total = nbr1+nbr2+nbr3+nbr4;
    }

    public Integer getNbr1() {
        return nbr1;
    }

    public void setNbr1(Integer nbr1) {
        this.nbr1 = nbr1;
    }

    public Integer getNbr2() {
        return nbr2;
    }

    public void setNbr2(Integer nbr2) {
        this.nbr2 = nbr2;
    }

    public Integer getNbr3() {
        return nbr3;
    }

    public void setNbr3(Integer nbr3) {
        this.nbr3 = nbr3;
    }

    public Integer getNbr4() {
        return nbr4;
    }

    public void setNbr4(Integer nbr4) {
        this.nbr4 = nbr4;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
