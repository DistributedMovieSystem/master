package myBean;

public class Movie {

    private String m_id;

    private String bad_count;
    private String middle_count;
    private String good_count;

    private String rating ;

    private String m_name;
    private String m_type;
    private String m_country;
    private String m_year;
    private String post_url;
    private String summary;

    public Movie() {
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getBad_count() {
        return bad_count;
    }

    public void setBad_count(String bad_count) {
        this.bad_count = bad_count;
    }

    public String getMiddle_count() {
        return middle_count;
    }

    public void setMiddle_count(String middle_count) {
        this.middle_count = middle_count;
    }

    public String getGood_count() {
        return good_count;
    }

    public void setGood_count(String good_count) {
        this.good_count = good_count;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_type() {
        return m_type;
    }

    public void setM_type(String m_type) {
        this.m_type = m_type;
    }

    public String getM_country() {
        return m_country;
    }

    public void setM_country(String m_country) {
        this.m_country = m_country;
    }

    public String getM_year() {
        return m_year;
    }

    public void setM_year(String m_year) {
        this.m_year = m_year;
    }

    public String getPost_url() {
        return post_url;
    }

    public void setPost_url(String post_url) {
        this.post_url = post_url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "bad_count='" + bad_count + '\'' +
                ", middle_count='" + middle_count + '\'' +
                ", good_count='" + good_count + '\'' +
                ", rating='" + rating + '\'' +
                ", m_name='" + m_name + '\'' +
                ", m_type='" + m_type + '\'' +
                ", m_country='" + m_country + '\'' +
                ", m_year='" + m_year + '\'' +
                ", post_url='" + post_url + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
