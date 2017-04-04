/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abel Chavanga <achavanga@fnb.co.za>
 */
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {

    public static void main(String[] args) {

        port(Integer.valueOf(System.getenv("PORT")));

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(System.getenv("JDBC_DATABASE_URL"));
        final HikariDataSource dataSource = (config.getJdbcUrl() != null)
                ? new HikariDataSource(config) : new HikariDataSource();

        staticFileLocation("/public");
        get("/hello", (req, res) -> "Hello World");

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            try (Connection connection = dataSource.getConnection()) {
                Statement stmt = connection.createStatement();
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
                stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
                ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

                ArrayList<String> output = new ArrayList<String>();
                while (rs.next()) {
                    output.add("Read from DB: " + rs.getTimestamp("tick"));
                }

                attributes.put("results", output);

            } catch (Exception e) {
                attributes.put("message", "There was an error: " + e);
                return new ModelAndView(attributes, "error.ftl");
            }

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

    }
}
