package com.mapper;

import com.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface OrderMapper {

    @Select("SELECT iri.id FROM in_room_info iri INNER JOIN rooms  \n" +
            "rm ON iri.room_id = rm.id WHERE rm.id = #{id} AND iri.out_room_status = 0")
    Integer selectByInRoomInfo(Integer id);

    @Insert("insert into orders values(null,#{orderNum},#{orderMoney},#{remark},#{orderStatus}," +
            "#{iriId},#{createDate})")
    int insertOrder(Order order);
}
