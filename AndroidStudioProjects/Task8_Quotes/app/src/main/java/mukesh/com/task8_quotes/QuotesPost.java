package mukesh.com.task8_quotes;
/**
 * Created by Players on 14/02/2017.
 */
public class QuotesPost {

    private int id, cat_id;
    private String quote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
