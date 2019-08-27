
import java.sql.*;


public class demo {
      public static void main(String args[]) 
    {
        Connection cnn=null;
        Statement stnt= null;
        ResultSet rst=null;
        try{
            //b1 nap trinh dieu khien
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //b2. Dinh nghia kert noi
            String url = "jdbc:sqlserver://PC230\\SQLSERVER;" +
			"databaseName=QLSanpham";
            //3. tao doi tuong ket noi
            cnn=DriverManager.getConnection(url,"sa","123456");
            //4/ tao doi tuong thuc thi lenh truy cap 
            stnt=cnn.createStatement();
            //them 1 dong du lieu
            int row=stnt.executeUpdate("insert into LoaiSP(maloai,tenloai) values('DD',N'do dung dien')");
            System.out.println("row: "+row);
            //5. thuc thi lenh truy cap
            rst=stnt.executeQuery("Select * from LoaiSP");
            //6. xu ly ket qua tra ve
            while(rst.next())//duyet cac mau tin ket qua
            {
                System.out.println(rst.getString(1) +"  - "+rst.getNString(2));
            } 
        
        }catch(Exception ex)
        {
             System.err.println(ex.toString());
        }
    }

}
