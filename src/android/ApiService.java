package com.medleymed.TwilioAudio;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import src.cordova.plugin.videocall.CompleteRoomResponse;
import src.cordova.plugin.videocall.Response;

public interface ApiService {

    @GET("/api/twilio-voice/accessToken")
    Single<String> getData(@Query("identity") String identity);

    @FormUrlEncoded
    @POST("/api/twilio-video/completeRoom")
    Single<CompleteRoomResponse> completeRoom(@Field("sid") String sid);

    @GET("/api/AvailabilityLogs/by-room-name")
    Single<Response> getAllRoomParticipants(@Query("roomName") String roomName);

    @FormUrlEncoded
    @POST("/api/Users/sendnotification")
    Single<Object> sendNotification(@Field("roomName") String roomName,
                                    @Field("roomSid") String roomSid,
                                    @Field("identity") String identity,
                                    @Field("user_type") String role,
                                    @Field("senderId") String senderId,
                                    @Field("receivedId") String receivedId,
                                    @Field("called_in") String calledIn,
                                    @Header("Authorization") String accessToken);
}
