package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        List<String> dogsByCountry = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select name from dog_types where country = ? ")) {
            stmt.setString(1, country.toUpperCase());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                dogsByCountry.add(rs.getString("name").toLowerCase());
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by query", sqle);
        }
        return dogsByCountry;
    }


}
