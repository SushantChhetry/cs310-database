package edu.jsu.mcis;


import java.sql.*;
import java.util.ArrayList;
import org.json.simple.*;

public class DatabaseTest {

    /**
     *
     */
    public static void main(String[] args)
    {
        JSONArray newArray = getJSONData(); 
        
        System.out.format("%35s", "DATABASE TO JSON CONVERTER");
        System.out.println();
        System.out.println(newArray);
    }
    public static JSONArray getJSONData() {
        
        Connection conn = null;
        PreparedStatement pstSelect = null, pstUpdate = null;
        ResultSet resultset = null;
        ResultSetMetaData metadata = null;
        
                    
        JSONArray dataArray = new JSONArray();                                
        
        ArrayList<String> key = new ArrayList();
        String query,value;
        
        
        boolean hasresults;
        int resultCount, columnCount, updateCount = 0;
        
        try {
           
            /* Identify the Server */
            
            String server = ("jdbc:mysql://localhost/p2_test");
            String username = "root";
            String password = "001201142";
            System.out.println("Connecting to " + server + "...");
            
            /* Load the MySQL JDBC Driver */
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            /* Open Connection */

            conn = DriverManager.getConnection(server, username, password);

            /* Test Connection */
            
            if (conn.isValid(0)) {
               
                /* Prepare Select Query */
                
                query = "SELECT * FROM people";
                pstSelect = conn.prepareStatement(query);
                
                /* Execute Select Query */
                
                System.out.println("Submitting Query ...");
                
                hasresults = pstSelect.execute();                
                
                /* Get Results */
                
                System.out.println("Getting Results ...");
                
                while ( hasresults || pstSelect.getUpdateCount() != -1 ) {

                    if ( hasresults ) {
                        
                        /* Get ResultSet Metadata */
                        
                        resultset = pstSelect.getResultSet();
                        metadata = resultset.getMetaData();
                        columnCount = metadata.getColumnCount();
                        
                        /* Get Column Names; Print as Table Header */
                        
                        for (int i = 2; i <= columnCount; i++) {

                            key.add(metadata.getColumnLabel(i));
                        }
                        
                        /* Get Data; Print as Table Rows */
                        
                        while(resultset.next()) {
                            
                            /* Begin Next ResultSet Row */

                            JSONObject jsonRecord = new JSONObject();   
                            
                            /* Loop Through ResultSet Columns; Print Values */

                            for (int i = 2; i <= columnCount; i++) {
                                JSONObject jsonObject = new JSONObject(); 
                                
                                
                                
                                value = resultset.getString(i);

                                if (resultset.wasNull()) {
                                    
                                    jsonObject.put(key.get(i-2), "NULL");
                                    
                                }

                                else {
                                    
                                    jsonObject.put(key.get(i-2), value);
                                }
                                jsonObject.toJSONString();
                                jsonRecord.putAll(jsonObject);
                            }
                          dataArray.add(jsonRecord);
                        }
                        
                    }

                    else {

                        resultCount = pstSelect.getUpdateCount();  

                        if ( resultCount == -1 ) {
                            break;
                        }

                    }
                    
                    /* Check for More Data */

                    hasresults = pstSelect.getMoreResults();

                }
                
            }
            
            System.out.println();
            
            /* Close Database Connection */
            
            conn.close();
            
            
            
        }
        
        catch (Exception e) {
            System.err.println(e.toString());
        }
        
        /* Close Other Database Objects */
        
        finally {
            
            if (resultset != null) { try { resultset.close(); resultset = null; } catch (Exception e) {} }
            
            if (pstSelect != null) { try { pstSelect.close(); pstSelect = null; } catch (Exception e) {} }
            
            if (pstUpdate != null) { try { pstUpdate.close(); pstUpdate = null; } catch (Exception e) {} }
            
        }
         return dataArray;
        
    }
   
}