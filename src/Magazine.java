public class Magazine {
    private int id;
    private String Magazine_name;
    private double price;
    private double rating;
    private int copies;
    public Magazine(int id, String magazine_name, double price, double rating, int copies) {
        this.id = id;
        Magazine_name = magazine_name;
        this.price = price;
        this.rating = rating;
        this.copies = copies;
    }
    public Magazine(String magazine_name, double price, double rating, int copies) {
        Magazine_name = magazine_name;
        this.price = price;
        this.rating = rating;
        this.copies = copies;
    }
    public Magazine(String studLine) {
        String values[] = studLine.split(",");
        this.Magazine_name = values[0];
        this.price =Double.valueOf(values[1]);
        this.rating=Double.valueOf(values[2]);
        this.copies=Integer.valueOf(values[3]);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMagazine_name() {
        return Magazine_name;
    }
    public void setMagazine_name(String magazine_name) {
        Magazine_name = magazine_name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public int getCopies() {
        return copies;
    }
    public void setCopies(int copies) {
        this.copies = copies;
    }
    @Override
    public String toString() {
        return "Magazine [id:" + id + ", Magazine name:" + Magazine_name + ", price : "+price+",rating :"+rating+", copies:"+copies+"]";
    }
}
