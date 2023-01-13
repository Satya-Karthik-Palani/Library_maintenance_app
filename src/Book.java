public class Book {
    private int id;
    private String book_name;
    private String category;
    private double price;
    private double rating;
    private int copies;
    
    public Book(String book_name, String category, double price, double rating, int copies) {
        this.book_name = book_name;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.copies = copies;
    }
    
    public Book(int id, String book_name, String category, double price, double rating, int copies) {
        this.id = id;
        this.book_name = book_name;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.copies = copies;
    }

    public Book(String studLine) {
        String values[] = studLine.split(",");
        this.book_name = values[0];
        this.category = values[1];
        this.price =Double.valueOf(values[2]);
        this.rating=Double.valueOf(values[3]);
        this.copies=Integer.valueOf(values[4]);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        return "Book [id:" + id + ", Book name:" + book_name + ", category:" + category + ", price : "+price+",rating :"+rating+", copies:"+copies+"]";
    }
    
}

