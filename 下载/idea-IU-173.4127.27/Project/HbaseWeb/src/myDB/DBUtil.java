package myDB;
import java.io.IOException;
import java.util.*;

import myBean.Movie;
import org.apache.hadoop.conf.Configurable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;



public class DBUtil {
    public static Movie getMovieById(String id) throws Exception{
        Configuration conf=HBaseConfiguration.create();

        HTable table=new HTable(conf,"movie");

        Get g=new Get(Bytes.toBytes(id));

        Result result=table.get(g);


        byte[] b_name=result.getValue(Bytes.toBytes("movie_info"),Bytes.toBytes("m_name"));
        byte[] b_type=result.getValue(Bytes.toBytes("movie_info"),Bytes.toBytes("m_type"));
        byte[] b_country=result.getValue(Bytes.toBytes("movie_info"),Bytes.toBytes("m_country"));
        byte[] b_year=result.getValue(Bytes.toBytes("movie_info"),Bytes.toBytes("m_year"));
        byte[] b_post_url=result.getValue(Bytes.toBytes("movie_info"),Bytes.toBytes("post_url"));
        byte[] b_summary=result.getValue(Bytes.toBytes("movie_info"),Bytes.toBytes("summary"));
        byte[] b_rating=result.getValue(Bytes.toBytes("movie_rating"),Bytes.toBytes("rating"));

        byte[] b_bad_count=result.getValue(Bytes.toBytes("sentimentclassify"),Bytes.toBytes("bad_count"));
        byte[] b_middle_count=result.getValue(Bytes.toBytes("sentimentclassify"),Bytes.toBytes("middle_count"));
        byte[] b_good_count=result.getValue(Bytes.toBytes("sentimentclassify"),Bytes.toBytes("good_count"));


        String m_name=Bytes.toString(b_name);
        String m_type=Bytes.toString(b_type);
        String m_country=Bytes.toString(b_country);
        String m_year=Bytes.toString(b_year);
        String post_url=Bytes.toString(b_post_url);
        String summary=Bytes.toString(b_summary);
        String rating=Bytes.toString(b_rating);
        String bad_count=Bytes.toString(b_bad_count);
        String middle_count=Bytes.toString(b_middle_count);
        String good_count=Bytes.toString(b_good_count);

        Movie m=new Movie();
        m.setM_id(id);
        m.setM_name(m_name);
        m.setM_type(m_type);
        m.setM_country(m_country);
        m.setM_year(m_year);
        m.setPost_url(post_url);
        m.setSummary(summary);
        m.setRating(rating);
        m.setBad_count(bad_count);
        m.setMiddle_count(middle_count);
        m.setGood_count(good_count);


        return m;
    }

    public static List<Movie> getMovieList() throws Exception{
        List<Movie> movies = new ArrayList<Movie>();
        Movie m = null;
        Configuration conf=HBaseConfiguration.create();
        HTable table=new HTable(conf,"movie");

        // Getting the scan result
        ResultScanner scanner = table.getScanner(new Scan());

        // Reading values from scan result
        for (Result result = scanner.next(); result != null; result = scanner.next()) {
            byte[] b_id = result.getRow();
            byte[] b_name = result.getValue(Bytes.toBytes("movie_info"), Bytes.toBytes("m_name"));
            byte[] b_post_url = result.getValue(Bytes.toBytes("movie_info"), Bytes.toBytes("post_url"));
            byte[] b_summary = result.getValue(Bytes.toBytes("movie_info"), Bytes.toBytes("summary"));

            String m_id = Bytes.toString(b_id);
            String m_name = Bytes.toString(b_name);
            String post_url = Bytes.toString(b_post_url);
            String summary = Bytes.toString(b_summary);

            m = new Movie();
            m.setM_id(m_id);
            m.setM_name(m_name);
            m.setPost_url(post_url);
            m.setSummary(summary);

            movies.add(m)
        }

        //closing the scanner
        scanner.close();

        return movies;
    }
}
