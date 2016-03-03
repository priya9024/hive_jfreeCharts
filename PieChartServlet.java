package com.simplecodestuffs.action;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.jdbc.JDBCPieDataset;

import com.simplecodestuffs.jdbc.DataAccessObject;

public class PieChartServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private Connection dbConnection = null;

        public PieChartServlet() {
                dbConnection = DataAccessObject.getConnection();
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                JDBCPieDataset dataSet = new JDBCPieDataset(dbConnection);

                try {
                dataSet.executeQuery("select source,percentage from air_pollution");
                JFreeChart chart = ChartFactory.createPieChart3D(
                 "Source of Tweets Simple ", // Title
                 dataSet,                    // Data
                 true,                       // Display the legend
                 true,                       // Display tool tips
                 false                       // No URLs
                 );
                        
                if (chart != null) {
                        chart.setBorderVisible(true);
                        int width = 600;
                        int height = 400;
                        response.setContentType("image/jpeg");
                        OutputStream out = response.getOutputStream();
                        ChartUtilities.writeChartAsJPEG(out, chart, width, height);
                }
                }
                catch (SQLException e) {
                        System.err.println(e.getMessage());
                }
        }
}