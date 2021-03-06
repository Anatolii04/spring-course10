package com.luxoft;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import lombok.val;

import java.sql.DriverManager;

@Value
@FieldNameConstants
public class Student {

    static String DB_URL = "jdbc:h2:mem:useExtensionMethods;DB_CLOSE_DELAY=-1";

    //language=H2
    static String CREATE_TABLE_SQL = "create table student (id identity, name varchar not null, groupId int)";//language=H2
    static String INSERT_STUDENT_SQL = "insert into student (name, groupId) values ('Вася Пупкин', 123456)";//language=H2
    static String GET_STUDENTS_SQL = "select id, name, groupId from student";

    Long id;
    String name;
    Integer groupId;

    @SneakyThrows
    public static void main(String... __) {
        @Cleanup val connection = DriverManager.getConnection(DB_URL);
        @Cleanup val statement = connection.createStatement();
        statement.executeUpdate(CREATE_TABLE_SQL);
        statement.executeUpdate(INSERT_STUDENT_SQL);
        @Cleanup val resultSet = statement.executeQuery(GET_STUDENTS_SQL);
        while (resultSet.next())
            System.out.println(new Student(
                    resultSet.getLong(FIELD_ID),
                    resultSet.getString(FIELD_NAME),
                    resultSet.getInt(FIELD_GROUP_ID)));
    }
}
