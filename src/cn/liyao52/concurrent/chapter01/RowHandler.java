package cn.liyao52.concurrent.chapter01;


import java.sql.ResultSet;

// this is strategy patterns
public interface RowHandler<T> {

    T handle(ResultSet rs);

}
