package com.service;

import com.pojo.InRoomInfo;

import java.util.List;
import java.util.Map;

public interface InRoomService {

    List<Map<String,Object>> findInRoomInfo(Map<String,Object> paramMap);

    List<Map<String,Object>> findKXRoom();

    List<Map<String,Object>> findYZRoom();

    boolean saveInRoomInfo(InRoomInfo inRoomInfo);

    int updateRecord(Integer id);

    List<Map<String, Object>> findRoomsByStatus(String status);

    Map<String, Object> findOutRoomInfoByRoomId(Long roomId);

    boolean outRoom(Long roomId, Long iriId, Float qita) throws Exception;

    List<Map<String, Object>> findCost(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);
}
