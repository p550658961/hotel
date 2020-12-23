package com.mapper;

import com.pojo.InRoomInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface InRoomMapper {

    /**
     * 查询入住房间信息
     * @param paramMap
     * @return
     */
    List<Map<String,Object>> selectInRoomInfo(Map<String,Object> paramMap);

    @Select("select * from rooms where room_status = '0'")
    List<Map<String,Object>> selectKXRoom();

    @Select("select * from rooms where room_status = '1'")
    List<Map<String,Object>> selectYZRoom();

    int insertInRoomInfo(InRoomInfo inRoomInfo);

    @Update("update rooms set room_status = #{status} where id = #{roomId}")
    int updateRoomStatus(@Param("roomId") Long roomId, @Param("status") String status);

    /**
     *
     * Description: 根据房间状态获取房间信息<br/>
     *
     * @param status
     * @return
     */
    @Select("SELECT * FROM rooms WHERE room_status=#{0}")
    List<Map<String, Object>> getRoomsByStatus(String status);



    /**
     *
     * Description: 根据房间主键获取退房客人的信息<br/>
     *
     * @param roomId
     * @return
     */
    Map<String, Object> selectOutRoomInfoByRoomId(Long roomId);

    /**
     *
     * Description: 修改入住信息表中的状态:未退房--->已经退房<br/>
     *
     * @param iriId
     * @return
     */
    @Update("UPDATE in_room_info SET out_room_status='1' WHERE id=#{0}")
    int updateIRIStatus(Long iriId);

    /**
     *
     * Description: 修改订单结算状态<br/>
     *
     * @author 丁鹏
     * @param iriId
     * @return
     */
    @Update("UPDATE orders SET order_status='1' WHERE iri_id=#{0}")
    int updateOrderStatus(Long iriId);

    /**
     * Description: 查询消费记录，同时包括条件查询<br/>
     *
     * @param paramMap
     * @return
     */
    List<Map<String, Object>> selectCost(Map<String, Object> paramMap);

    @Update("UPDATE in_room_info SET `status` = 0 WHERE id = #{id}")
    int updateRecord(Integer id);
}
