import java.sql.*;

public class Assignment2 {
    
  // A connection to the database  
  Connection connection;
  
  // Statement to run queries
  Statement sql;
  
  // Prepared Statement
  PreparedStatement ps;
  
  // Resultset for the query
  ResultSet rs;
  
  //CONSTRUCTOR
  Assignment2(){
	  try {
			// Load JDBC driver
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			//e.printStackTrace();
			return;

		}
  }
  
  //Using the input parameters, establish a connection to be used for this session. Returns true if connection is sucessful
  public boolean connectDB(String URL, String username, String password){
	  try {
			//Make the connection to the database, ****** but replace "username" with your username ******
			System.out.println("*** Please make sure to replace 'username' with your cdf username in the jdbc connection string!!!");
			connection = DriverManager.getConnection(URL, username, password);
	if(connection!=null){
		return true;
	}else{
		return false;
	}

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			return false;
		}
  }
  
  //Closes the connection. Returns true if closure was sucessful
  public boolean disconnectDB(){
      return false;    
  }
    
  public boolean insertCountry (int cid, String name, int height, int population) {
	  try{
		  System.out.println("#####inside insertCountry");
		  sql=connection.createStatement();
		  String sqlText;
		  String sqlCheck;
		  Boolean retVal;
		  sqlCheck = "SELECT * FROM a2.country WHERE cid =" + cid;
		  System.out.println("sqlCheck "+sqlCheck+"\n");
		  rs = sql.executeQuery(sqlCheck);
		  if(rs.next()){
			  System.out.println("inside rs next if");
			  retVal = false;
		  }
		  else{
			  sqlText = "INSERT INTO a2.country " + "VALUES(" + cid + ",'" + name + "'," + height + ","+ population + ")";
			  System.out.println("Executing this command: \n" + sqlText + "\n");
			  sql.executeUpdate(sqlText);
			  retVal = true;
		  }
		  rs.close();
                  return retVal;
	  }catch (SQLException e){
		  return  false;
	  }
  }
  
  public int getCountriesNextToOceanCount(int oid) {
	return -1;  
  }
   
  public String getOceanInfo(int oid){
	  try{
		  String retVal = "";
		  sql = connection.createStatement();
		  String sqlText;
		  
		  sqlText = "SELECT *       " +
                  " FROM a2.ocean " +
				  " WHERE oid = " + oid;
		  System.out.println("Now executing the command: " + sqlText.replaceAll("\\s+", " ") + "\n");
       	  rs = sql.executeQuery(sqlText);
       	  if (rs != null){
       		System.out.println("Inside rs not null");
       		  while (rs.next()){
       			  System.out.println(rs.getInt("oid") + ":" + rs.getString("oname") + ":" + rs.getInt("depth") +"\n");
       			  retVal = rs.getInt("oid") + ":" + rs.getString("oname") + ":" + rs.getInt("depth");
       		  }
       	  }
       	  //Close the resultset
       	  rs.close();
	  return retVal;		  
	  }catch(SQLException e){
		  return "";
	  }
  }

  public boolean chgHDI(int cid, int year, float newHDI){
   return false;
  }

  public boolean deleteNeighbour(int c1id, int c2id){
	  try{
		  System.out.println("#####inside delete neighbor\n");
		  Boolean retVal=false;
		  sql = connection.createStatement();
		  String sqlText,sqlText2;
		  sqlText = "DELETE FROM a2.neighbour WHERE country =  " + c1id 
				  + " AND neighbor = " + c2id;
		  sqlText2 = "DELETE FROM a2.neighbour WHERE country = " 
				  + c2id + " AND neighbor = " + c1id;
		  if (sql.executeUpdate(sqlText)!=0 && sql.executeUpdate(sqlText2)!=0){
			  System.out.println("output true\n");
			  retVal = true;
   		  }
		  System.out.println("deleteNeighbor " + "SELECT * FROM neighbour WHERE country =  " + c1id 
				  + " AND neighbor = " + c2id 
				  + " UNION SELECT * FROM neighbour WHERE country = " + c2id
				  + "AND neighbor = " + c1id);
		   return retVal;
	  }catch(SQLException e){
		  return false;
	  }
  }
  
  public String listCountryLanguages(int cid){
	return "";
  }
  
  public boolean updateHeight(int cid, int decrH){
	  try{
		  Boolean retVal = false;
		  sql = connection.createStatement();
		  String sqlText,sqlQuery;
		  int height=0;
		  sqlQuery = "SELECT * FROM a2.country WHERE cid = "+ cid;
		  rs = sql.executeQuery(sqlQuery);
		  if (rs != null){
       		  while (rs.next()){
       			  //System.out.println(rs.getInt("oid") + ":" + rs.getString("oname") + ":" + rs.getInt("depth") +"\n");
       			  height = rs.getInt("height");
				System.out.println("height"+height+"\n");
       		  }
       	  }
		  sqlText = "UPDATE a2.country      " +
                  "   SET height = " + (height-decrH) + 
                  " WHERE  cid = " + cid; 
		  System.out.println("Executing this command: \n" + sqlText.replaceAll("\\s+", " ") + "\n");
		  sql.executeUpdate(sqlText);
		  System.out.println (sql.getUpdateCount() + " rows were update by this statement.\n");
		  rs.close();
		  return true;
	  }catch(SQLException e){
		  return false;
	  }
  }
    
  public boolean updateDB(){
	return false;    
  }
  
}
