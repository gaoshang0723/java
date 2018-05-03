package com.ishops.DBmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlDB {
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public void getConn() throws ClassNotFoundException, SQLException {				
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amn", "root", "root");
	}

	public List<AmnModel> show() throws SQLException {			//��ѯ
		String show = "select * from stu";
		pst = con.prepareStatement(show);
		rs = pst.executeQuery();
		List<AmnModel> list = new ArrayList<AmnModel>();		//����ArrayList����
		while (rs.next()) {										//������Դrs�����ڼ����������
			AmnModel amn = new AmnModel();
			amn.setName(rs.getString("name"));
			amn.setAge(rs.getInt("age"));
			list.add(amn);
		}

		return list;								//���ؼ���

	}
	public int insert(AmnModel amn) throws SQLException{		//����
		String insert="insert into stu (name,age) value (?,?)";
		pst=con.prepareStatement(insert);
		pst.setString(1, amn.getName());
		pst.setInt(2, amn.getAge());	
		int status=pst.executeUpdate();
		return status;
		
	}
}
