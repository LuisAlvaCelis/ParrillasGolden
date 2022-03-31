package net.src;

public class Menu {
    
    private int id;
    private String name;
    private String description;
    private String category;
    private double cost;
    private boolean status;
    
    public Menu(int id,String name,String description,String category,double cost,boolean status){
        this.id=id;
        this.name=name;
        this.description=description;
        this.category=category;
        this.cost=cost;
        this.status=status;
    }
    
    public Menu(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
