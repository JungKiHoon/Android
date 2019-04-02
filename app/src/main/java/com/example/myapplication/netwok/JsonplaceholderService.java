package com.example.myapplication.netwok;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonplaceholderService {
    // get방식으로 요청. photos에 요청
    @GET("photos")
    // Call에다 결과 값 타입을 정해줌. 이것을 호출할 때 쓰는 메소드 이름
    Call<List<Photo>> listPhotos();
    @GET("users")
    Call<List<User>> listUser();
}